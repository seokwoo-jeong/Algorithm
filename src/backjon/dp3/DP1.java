package backjon.dp3;
import java.io.*;

// https://www.acmicpc.net/problem/2579
// 계단 오르기

public class DP1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = array[1];
		
		if(n >= 2) {
			dp[2] = array[1] + array[2];
		}
		
		for(int i = 3; i<=n; i++) {
			dp[i] = Math.max(dp[i-3]+array[i-1], dp[i-2]) + array[i];
		}
		
		System.out.println(dp[n]);
	}

}
