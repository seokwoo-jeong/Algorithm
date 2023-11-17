package backjon.dp;
import java.io.*;

// https://www.acmicpc.net/problem/16194
// 카드 구매하기2
public class DP6 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] def = br.readLine().split(" ");
		int[] array = new int[n+1];
		
		int[] dp = new int[n + 1];		//dp[카드개수] = 최소 값
		for(int i = 0; i<n; i++) {
			array[i+1] = Integer.parseInt(def[i]);
			
		}
		dp[1] = array[1];
		
		for(int i = 2; i<n+1; i++) {
			dp[i] = array[i];
			for(int j = 1; j<i/2+1; j++) {
				dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
			}
		}
		System.out.println(dp[n]);
	}

}
