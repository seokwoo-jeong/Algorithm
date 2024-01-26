package backjon2.dfs;

import java.io.*;

// https://www.acmicpc.net/problem/1103
// 게임 (골2)

public class DFS05_RE {
	private static int n;
	private static int m;
	private static char[][] matrix;
	private static boolean[][] isVisit;
	private static int[][] moveCount;
	private static int result;
	
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		matrix = new char[n][m];
		isVisit = new boolean[n][m];
		moveCount = new int[n][m];
		result = Integer.MIN_VALUE;
		
		for(int i = 0; i<n; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		dfs(0,0,1);//x,y,count
		
		System.out.println(result);
	}
	
	private static void dfs(int x, int y, int count) {

		
		result = Math.max(result, count);
		
		moveCount[x][y] = count;
		for(int i = 0; i<dx.length; i++) {
			int nx = x + dx[i] * Character.digit(matrix[x][y],10);
			int ny = y + dy[i] * Character.digit(matrix[x][y],10);
			
			if(result == -1) {
				return;
			}
			
			if(isOut(nx,ny) || isHoll(nx,ny)) {
				continue;
			}
			
			if(moveCount[nx][ny] > count) {
				continue;
			}
			
			if(isVisit[nx][ny]) {
				result = -1;
				return;
			}
			
			isVisit[x][y] = true;
			dfs(nx,ny,count+1);
			isVisit[nx][ny] = false;
		}
	}
	
	private static boolean isHoll(int x, int y) {
		if(matrix[x][y] == 'H') {
			return true;
		}
		return false;
	}
	
	private static boolean isOut(int x, int y) {
		if(0<= x && x < n && 0<= y && y <m) {
			return false;
		}
		return true;
	}

}