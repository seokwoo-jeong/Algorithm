package backjon2.backtracking;

import java.io.*;

// https://www.acmicpc.net/problem/18290
// NM과 K(1) 실(1)
public class BackTracking09_RE {
	
	private static int[][] matrix;
	private static int n;
	private static int m;
	private static int k;
	private static boolean[][] isVisit;
	private static int result;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		k = Integer.parseInt(temp[2]);
		
		matrix = new int[n][m];
		isVisit = new boolean[n][m];
		
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			for(int z= 0; z<m; z++) {
				matrix[i][z] = Integer.parseInt(temp[z]);
			}
		}
		result = Integer.MIN_VALUE;
		dfs(0,0,0,0);
		System.out.println(result);
	}
	
	private static void dfs(int count, int x, int y, int sum) {
		if(count == k) {
			result = Math.max(result, sum);
			return;
		}
		
		for(int i = x; i<n; i++) {
			y = resetY(x,y,i);
			for(int z = y; z<m; z++) {
				if(isVisit[i][z] || isNext(i,z)) {
					continue;
				}
				isVisit[i][z] = true;
				dfs(count+1,i,z,sum+matrix[i][z]);
				isVisit[i][z] = false;
			}
		}
	}
	private static int resetY(int x, int y, int i) {
		if(i != x) {
			return 0;
		}
		return y;
	}
	
	private static boolean isNext(int x, int y) {

		
		int nearX = 0;
		int nearY = 0;
		
		for(int i = 0; i<dx.length; i++) {
			nearX = x + dx[i];
			nearY = y + dy[i];
			
			if(isOut(nearX,nearY)) {
				continue;
			}
			
			if(isVisit[nearX][nearY]) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isOut(int x, int y) {
		if(0<=x && x < n && 0<= y && y < m) {
			return false;
		}
		return true;
	}

}
