package backjon.bfs2;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16933
// 벽 부수고 이동하기 3
public class BFS8 {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static char[][] matrix;
	static int n;
	static int m;
	static int k;
	static boolean[][][][] isVisit;	
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def = br.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		m = Integer.parseInt(def[1]);
		k = Integer.parseInt(def[2]);
		matrix = new char[n][m];
		isVisit = new boolean[n][m][k+1][2];	//x,y,파괴횟수,낮밤(0:낮 1:밤)
		answer = -1;
		for(int i = 0; i<n; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		bfs(0,0);
		System.out.println(answer);
	}

	private static void bfs(int sx,int sy) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {sx,sy,0,0,1});// x, y, 벽부신횟수,낮밤(0:낮 1:밤),  이동횟수
		isVisit[sx][sy][0][0] = true;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];
			int curBreak= current[2];
			int curDay = current[3];
			int curMove = current[4];
			if(curX == n-1 && curY == m-1) {
				answer = curMove;
				return;
			}			
			for(int i = 0; i<dx.length; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if(!isGo(nx,ny)) {
					continue;
				}

				if(curDay == 0) {	//현재 낮
					if(!isVisit[curX][curY][curBreak][curDay+1]) { //현재 위치 밤 방문한적없는 경우
						isVisit[curX][curY][curBreak][curDay+1] = true;
						queue.add(new int[] {curX,curY,curBreak,curDay+1,curMove+1});
					}
					if(matrix[nx][ny] == '0' &&!isVisit[nx][ny][curBreak][curDay+1]) { //다음 위치 벽 아니고, 다음 위치 밤 방문한적없는 경우
						isVisit[nx][ny][curBreak][curDay+1] = true;
						queue.add(new int[] {nx,ny,curBreak,curDay+1,curMove+1});						
					}
					if(matrix[nx][ny] == '1' && curBreak < k) {	//다음 위치 벽이고, 다음 위치 밤 방문한적없는 경우
						if(!isVisit[nx][ny][curBreak+1][curDay+1]) {
							isVisit[nx][ny][curBreak+1][curDay+1] = true;
							queue.add(new int[] {nx,ny,curBreak+1,curDay+1,curMove+1});							
						}
					}
				}else {	//현재 밤
					if(!isVisit[curX][curY][curBreak][curDay-1]) { //현재 위치 낮 방문한적없는 경우
						isVisit[curX][curY][curBreak][curDay-1] = true;
						queue.add(new int[] {curX,curY,curBreak,curDay-1,curMove+1});
					}					
					if(matrix[nx][ny] == '0' &&!isVisit[nx][ny][curBreak][curDay-1]) { //다음 위치 벽 아니고, 다음 위치 낮 방문한적없는 경우
						isVisit[nx][ny][curBreak][curDay-1] = true;
						queue.add(new int[] {nx,ny,curBreak,curDay-1,curMove+1});						
					}
					
				}
				

			}
		}
	}
	
	private static boolean isGo(int x, int y) {
		if(0<=x && x<n && 0<=y && y<m) {
			return true;
		}
		return false;
	}

}
