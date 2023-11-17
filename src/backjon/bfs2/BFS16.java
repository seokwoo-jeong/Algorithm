package backjon.bfs2;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1600
// 말이 되고픈 원숭이
public class BFS16 {
	static int k;
	static int w;	//가로길이
	static int h;	//세로길이
	static String[][] matrix;
	static boolean[][][] isVisit; //x,y,k
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[] hx = {-1, 1, -2, 2, -2, 2, -1, 1};
	static int[] hy = {-2,-2, -1,-1,  1, 1,  2, 2};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		w = Integer.parseInt(temp[0]);
		h = Integer.parseInt(temp[1]);
		matrix = new String[h][w];
		isVisit = new boolean[h][w][k+1];
		for(int i = 0; i<h; i++) {
			String[] temp2 = br.readLine().split(" ");
			matrix[i] = temp2;
		}
		
		int answer = bfs();
		System.out.println(answer);
	
	}
	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0,0,0});	//x,y,k, move
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curx = cur[0];
			int cury = cur[1];
			int curk = cur[2];
			int curMove = cur[3];
			if(curx == h-1 && cury == w-1) {
				return curMove;
			}
			
			for(int i = 0; i<dx.length; i++) {	//인접한것 가는 거
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				
				if(!isGo(nx,ny) || matrix[nx][ny].equals("1")) {
					continue;
				}
				
				
				if(!isVisit[nx][ny][curk]) {
					isVisit[nx][ny][curk] = true;
					queue.add(new int[] {nx,ny,curk, curMove+1});
 				}
			}
			
			if(curk < k) {
				for(int i = 0; i<hx.length; i++) {	//말처럼 가는 거
					int nx = curx + hx[i];
					int ny = cury + hy[i];
					
					if(!isGo(nx,ny)|| matrix[nx][ny].equals("1")) {
						continue;
					}
					
					if(!isVisit[nx][ny][curk+1]) {
						isVisit[nx][ny][curk+1] = true;
						queue.add(new int[] {nx,ny,curk+1, curMove+1});
	 				}
				}
			}
		}
		return -1;
	}
	
	private static boolean isGo(int x, int y) {
		if(0<= x && x< h && 0<= y && y < w) {
			return true;
		}
		
		return false;
	}

}
