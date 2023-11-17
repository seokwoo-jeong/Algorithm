package backjon.dp;

import java.io.*;
//https://www.acmicpc.net/problem/11052
//카드 구매하기

//dfs 완전탐색의 경우 o(n^2)으로 시간 초과
public class DP5 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] def = br.readLine().split(" ");
		int[] array = new int[def.length + 1];
		int[] dp = new int[def.length + 1];		//dp[카드개수] = 최대 값
		for(int i = 0; i<def.length; i++) {
			array[i+1] = Integer.parseInt(def[i]);
			
		}
		dp[1] = array[1];
		
		for(int i = 2; i<array.length; i++) {
			dp[i] = array[i];
			for(int j = 1; j<=i/2+1; j++) {
				dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
			}
		}
		System.out.println(dp[n]);
	}
}
