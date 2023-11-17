package backjon2.backtracking;

import java.io.*;

// https://www.acmicpc.net/problem/18290
// NM과 K(1) 실(1)
public class BackTracking09 {

	private static int[][] matrix;
	private static boolean[][] isVisit;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	private static int result;
	private static int n;
	private static int m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		int k = Integer.parseInt(temp[2]);
		matrix = new int[n][m];
		isVisit = new boolean[n][m];
		
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			for(int z = 0; z<temp.length; z++) {
				matrix[i][z] = Integer.parseInt(temp[z]);
			}
		}
		
		result = Integer.MIN_VALUE;
		
		dfs(0,k,0,0,0);
		System.out.println(result);
	}
	
	private static void dfs(int count, int finish, int value,int bx, int by) {
		if(count == finish) {
			result = Math.max(value, result);
			return;
		}
		
		for(int i = bx; i<n; i++) {
			
			if(bx < i) {	//똑같은거 뽑는거 방지
				by = 0;
			}
			
			for(int z = by; z < m; z++) {
				
				
				boolean flag = false;
				for(int k = 0; k<4; k++) {
					if(!isGo(i+dx[k], z+dy[k])) {
						continue;
					}
					
					if(isVisit[i+dx[k]][z+dy[k]]) {
						flag = true;
						break;
					}
				}
				if(flag) {
					continue;
				}
				
				if(isVisit[i][z]) {
					continue;
				}
				
				isVisit[i][z] = true;
				//System.out.println(i + " " + z + " " + count);
				dfs(count+1, finish, value + matrix[i][z],i,z);
				isVisit[i][z] = false;
			}
		}
	}
	private static boolean isGo(int x, int y) {
		if(0<= x && x < n && 0<=y && y <m) {
			return true;
		}
		return false;
	}

}
