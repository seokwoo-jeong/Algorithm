package backjon2.prefixsum;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2167
// 2차원 배열의 합(실5)

public class PrefixSum02 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");

		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		int[][] matrix = new int[n][m];
		int[][] prefixSum = new int[n+1][m+1];
		
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			
			for(int z = 0; z<m; z++) {
				matrix[i][z] = Integer.parseInt(temp[z]);
			}
		}
		
		for(int i = 1; i<=n; i++) {
			for(int z = 1; z<=m; z++) {
				prefixSum[i][z] = prefixSum[i-1][z] + prefixSum[i][z-1] - prefixSum[i-1][z-1] + matrix[i-1][z-1];
			}
			
		}
		
		int k = Integer.parseInt(br.readLine());
		
		int index = 0;
		int i = 0;
		int j = 0;
		int x = 0;
		int y = 0;
		long result = 0;
		
		while(index < k) {
			index++;
			temp = br.readLine().split(" ");
			i = Integer.parseInt(temp[0]);
			j = Integer.parseInt(temp[1]);
			x = Integer.parseInt(temp[2]);
			y = Integer.parseInt(temp[3]);
			result = prefixSum[x][y]-(prefixSum[x][j-1]+prefixSum[i-1][y])+prefixSum[i-1][j-1];
			System.out.println(result);
		}
	}
}
