package backjon2.dp;

import java.io.*;
import java.util.*;

public class DP04 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] matrix = new int[n+2][2];
		int[] dp = new int[n+2];
		
		String[] temp = null;
		for(int i = 1; i<n+1; i++) {
			temp = br.readLine().split(" ");
			matrix[i][0] = Integer.parseInt(temp[0]);
			matrix[i][1] = Integer.parseInt(temp[1]);
			
		}
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i<=n+1; i++) {
			if(max <dp[i]) {
				max = dp[i];
			}
			
			int next = i + matrix[i][0];
			if(next < n+2) {
				dp[next] = Math.max(dp[next], max + matrix[i][1]);
			}
		}
		System.out.println(dp[n+1]);

	}

}
