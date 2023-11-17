package backjon2.dp;

import java.io.*;

// https://www.acmicpc.net/problem/1463
// 1로 만들기 (실3)

public class DP02 {

	private static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[n+1];
		
		for(int i = 2; i<=n; i++) {
			dp[i] = dp[i-1] + 1;
			
			if(i%3==0) {
				dp[i] = Math.min(dp[i/3]+1, dp[i]);
			}
			if(i%2==0) {
				dp[i] = Math.min(dp[i/2]+1, dp[i]);
			}
		}
		System.out.println(dp[n]);
	}
	


}
