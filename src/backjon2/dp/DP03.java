package backjon2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9095
// 1,2,3 더하기 (실3)

public class DP03 {

	private static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int index = 0;
		
		int[] dp = new int[12];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i<=11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		int n = 0;
		while(index < t) {
			n = Integer.parseInt(br.readLine());
			
			System.out.println(dp[n]);
			index++;
		}
	}

}
