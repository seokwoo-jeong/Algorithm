package backjon.bfs2;

import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/17086
// 아기 상어2
public class BFS17 {
	static String[][] matrix;
	static int[] dx = {1,-1,0,0,-1,-1,1,1};
	static int[] dy = {0,0,1,-1,-1,1,-1,1};
	static boolean[][] isVisit;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] t = br.readLine().split(" ");
		n = Integer.parseInt(t[0]);
		m = Integer.parseInt(t[1]);
		matrix = new String[n][m];
		isVisit = new boolean[n][m];
		for(int i = 0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			matrix[i] = temp;
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(matrix[i][j].equals("0")) {
					max = Math.max(bfs(i,j), max);
					isVisit = new boolean[n][m];
				}
			}
		}
		System.out.println(max);

	}
	private static int bfs(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {startX, startY,0});
		isVisit[startX][startY] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curx = cur[0];
			int cury = cur[1];
			int curCount = cur[2];
			for(int i = 0; i<dx.length; i++) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				
				if(!isGo(nx,ny) || isVisit[nx][ny]) {
					continue;
				}
				
				if(matrix[nx][ny].equals("1")) {
					return curCount+1;
				}
				
				queue.add(new int[] {nx,ny,curCount+1});
				isVisit[nx][ny] = true;
				
			}
		}
		
		return 0;
	}
	
	private static boolean isGo(int x, int y) {
		if(0<= x && x<n && 0<= y && y < m) {
			return true;
		}
		return false;
	}

}
