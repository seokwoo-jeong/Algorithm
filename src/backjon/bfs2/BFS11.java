package backjon.bfs2;
import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/6087
// 레이저 통신

public class BFS11 {
	static int w;
	static int h;
	static char[][] matrix;
	static int[][] isVisit;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};  
	static int answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		w = Integer.parseInt(temp[0]);
		h = Integer.parseInt(temp[1]);
		matrix = new char[h][w];
		isVisit = new int[h][w];
		answer = Integer.MAX_VALUE;
		int startX = 0;
		int startY = 0;
		int finishX = 0;
		int finishY = 0;
		int count = 0;
		for(int i = 0; i<h; i++) {
			char[] oneLine = br.readLine().toCharArray();
			for(int j = 0; j<oneLine.length; j++) {
				matrix[i][j] = oneLine[j];
				if(matrix[i][j] == 'C') {
					if(count == 0) {
						startX = i;
						startY = j;
						count++;
					}else {
						finishX = i;
						finishY = j;
					}
				}

			}
		}
		bfs(startX,startY,finishX,finishY);
		System.out.println(answer);
	}

	private static void bfs(int startX, int startY, int finishX, int finishY) {
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(startX, startY, 0, -1));
		isVisit[startX][startY] = 1;
		
		while(!queue.isEmpty()) {
			Info cur = queue.poll();
			
			if(cur.x == finishX && cur.y == finishY) {
				answer = Math.min(answer, cur.mirrorCnt);
				continue;
			}
			for(int i = 0; i < dx.length; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int ndir = i;
				int nCnt = cur.mirrorCnt;
				
				if(!isGo(nx,ny) || matrix[nx][ny] == '*') { // 맵 밖으로 넘어간 경우 or 벽 만난 경우
					continue;
				}
				
				if(cur.dir != -1 && ndir != cur.dir) {
					nCnt++;
				}
				
				if(isVisit[nx][ny] == 0) {
					isVisit[nx][ny] = nCnt;
					queue.add(new Info(nx,ny,nCnt,ndir));	
				}else if(isVisit[nx][ny] >= nCnt) {
					isVisit[nx][ny] = nCnt;
					queue.add(new Info(nx,ny,nCnt, ndir));	
				}
				

			}
		}
	}
	
	private static boolean isGo(int x, int y) {
		if(0<= x && x < h && 0<= y && y < w) {
			return true;
		}
		return false;
	}
	
	private static class Info{
		int x;
		int y;
		int mirrorCnt;
		int dir;	//0:동 1:서 2:남 3:북
		
		public Info(int x, int y, int mirrorCnt, int dir) {
			this.x = x;
			this.y = y;
			this.mirrorCnt = mirrorCnt;
			this.dir = dir;
		}
		
	}
}
