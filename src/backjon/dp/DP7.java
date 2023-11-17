package backjon.dp;

import java.io.*;

// https://www.acmicpc.net/problem/15990
// 1, 2, 3 더하기 5
public class DP7 {
	//static int[] array = {1,2,3};
	//static int count;
	static int max = 1000000009;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long[][] dp = new long[100001][4];
		dp[1][1] = 1;	// 1
		dp[2][2] = 1;	// 2
		dp[3][1] = 1;	// 1+2
		dp[3][2] = 1;	// 2+1
		dp[3][3] = 1;	// 3
		for(int i = 4; i<=100000; i++) {
			dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % max;
			dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % max;
			dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % max;
		}
		
		
		for(int i = 0; i<t; i++) {
			int result = Integer.parseInt(br.readLine());
			System.out.println((dp[result][1] + dp[result][2] + dp[result][3]) % max);
			
			//count = 0;

			//dfs(0,result,-1);
			//System.out.println(count % 1000000009);
		}
		
	}
	
	/*
	public static void dfs(int current, int result, int beforeIndex) { //dfs로 풀어보기
		if(current == result) {
			count++;
			return;
		}else if(current > result) {
			return;
		}
		
		for(int i = 0; i<array.length; i++) {
			if(i != beforeIndex) {
				dfs(current+array[i],result,i);
			}
		}
	}
	*/

}
