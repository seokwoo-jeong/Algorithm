package backjon.dp2;
import java.io.*;

// https://www.acmicpc.net/problem/15989
// 1, 2, 3 더하기 4
public class DP4 {
	private static int max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		max = 10001;
		int[][] dp = new int[max][4];
		
		dp[1][1] = 1;	// 1
		dp[2][1] = 1;	// 1+1
		dp[2][2] = 1;	// 2
		dp[3][1] = 1;	// 1+1+1
		dp[3][2] = 1; 	// 1+2
		dp[3][3] = 1;	// 3
		
		
		for(int i = 4; i<max; i++) {
			dp[i][1] = dp[i-1][1];
			dp[i][2] = dp[i-2][1] + dp[i-2][2];
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}
		
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++) {
			int t = Integer.parseInt(br.readLine());
			sb.append(dp[t][1] + dp[t][2] + dp[t][3] + "\n");
		}
		
		System.out.print(sb.toString());
	}

}
