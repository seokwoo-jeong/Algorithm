package backjon2.dfs;

import java.io.*;

// https://www.acmicpc.net/problem/1103
// 게임 (골2)

public class DFS05 {

	private static int[][] matrix;
	private static boolean[][] isVisit;
	private static int[][] moveCount;
	private static int result;
	private static int n;
	private static int m;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		result = Integer.MIN_VALUE;
		isVisit = new boolean[n][m];
		matrix = new int[n][m];
		moveCount = new int[n][m];
		for(int i = 0; i<n; i++) {
			char[] temp2 = br.readLine().toCharArray();
			
			for(int z = 0; z<m; z++) {
				if(temp2[z] == 'H') {
					matrix[i][z] = 0;
					continue;
				}
				matrix[i][z] = Character.digit(temp2[z], 10);
			}
		}
		
		dfs(0,0,1);
		System.out.println(result);
	}
	
	private static void dfs(int x, int y, int count) {
		result = Math.max(result, count);
		
		
		int nx = 0;
		int ny = 0;
		moveCount[x][y] = count;
		for(int i = 0; i<4; i++) {
			if(i == 0) {
				nx = x;
				ny = y + matrix[x][y];
			}else if(i == 1) {
				nx = x;
				ny = y - matrix[x][y];
			}else if(i == 2) {
				nx = x + matrix[x][y];
				ny = y;
			}else {
				nx = x - matrix[x][y];
				ny = y ;
			}

			if(result == -1) {
				return;
			}
			
			if(isOut(nx,ny) || matrix[nx][ny] == 0) {
				continue;
			}
			if(isVisit[nx][ny]) {
				result = -1;
				return;
			}
			if(moveCount[nx][ny] > count) {
				continue;
			}
			
			isVisit[x][y] = true;
			dfs(nx,ny,count+1);
			isVisit[x][y] = false;
		}
		
	}
	
	private static boolean isOut(int x, int y) {
		if(0<= x && x < n && 0<= y && y < m) {
			return false;
		}
		return true;
	}

}