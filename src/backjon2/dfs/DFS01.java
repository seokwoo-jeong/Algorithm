package backjon2.dfs;

import java.io.*;

// https://www.acmicpc.net/problem/10026
// 적록색약 (골5)

public class DFS01 {

	private static boolean[][] isVisit;
	private static char[][] matrix;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	private static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		matrix = new char[n][n];
		
		
		
		for(int i = 0; i<n; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		
		boolean isSame = false;
		
		int round = 0;
		int[] result = new int[2];
		while(round <=1) {
			isVisit = new boolean[n][n];	
			for(int i = 0; i<n; i++) {
				for(int z = 0; z<n; z++) {
					if(!isVisit[i][z]) {
						isVisit[i][z] = true;
						dfs(i,z, isSame);
						result[round]++;
					}
				}
			}
			isSame = true;
			
			round++;
		}
		
		for(int r: result) {
			System.out.print(r + " ");
		}
	}
	
	private static void dfs(int x, int y, boolean isSame) {
		
		int nx = 0;
		int ny = 0;
		for(int i = 0; i<dx.length; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(isOut(nx, ny) || isVisit[nx][ny]) {
				continue;
			}
			
			if(isSame) {	//적록색약
				if((matrix[x][y] == matrix[nx][ny]) || (matrix[x][y] == 'R' && matrix[nx][ny] == 'G') || (matrix[x][y] == 'G' && matrix[nx][ny] == 'R')) {
					isVisit[nx][ny] = true;
					dfs(nx,ny,isSame);
				}
			}else {	//적록색약 x
				if(matrix[x][y] == matrix[nx][ny]){
					isVisit[nx][ny] = true;
					dfs(nx,ny,isSame);
				}
			}
		}
	}
	
	private static boolean isOut(int x, int y) {
		if(0<= x && x < n & 0<= y && y < n) {
			return false;
		}
		return true;
	}

}
