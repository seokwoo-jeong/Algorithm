package backjon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Graph10 {
//https://www.acmicpc.net/problem/16929
//Two Dots
	static char[][] matrix;
	static boolean[][] isVisited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int startX;
	static int startY;
	static String result;
	static int n;
	static int m;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] def = in.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		m = Integer.parseInt(def[1]);
		matrix = new char[n][m]; 
		isVisited = new boolean[n][m];
		result = "No";
		for(int i = 0; i<n; i++) {
			matrix[i] = in.readLine().toCharArray();
		}
		for(int i =0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(!flag) {
					startX = i;
					startY = j;
					dfs(i,j,0);
				}else {
					break;
				}
				
			}
			if(flag) {
				break;
			}
		}
		System.out.println(result);
	}
	private static void dfs(int x, int y, int count) {
		if(startX == x && startY == y && count>=4) {
			result = "Yes";
			flag = true;
			return;
		}
		for(int i = 0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0<= nx && nx < n && 0<= ny && ny< m) {
				if(matrix[nx][ny] == matrix[x][y]) {
					if(!isVisited[nx][ny]) {
						isVisited[nx][ny] = true;
						dfs(nx,ny,count+1);
						isVisited[nx][ny] = false;
					}

				}
			}
		}
		
		
	}

}
