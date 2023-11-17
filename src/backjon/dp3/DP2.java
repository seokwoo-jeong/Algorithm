package backjon.dp3;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9465
// 스티커
public class DP2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t != 0) {
			t--;
			
			int n = Integer.parseInt(br.readLine());
			int[][] array = new int[2][n+1];
			int[][] dp = new int[2][n+1];
			
			for(int i = 0; i<2; i++) {
				String[] temp = br.readLine().split(" ");
				
				for(int z = 1; z <= n; z++) {
					array[i][z] = Integer.parseInt(temp[z-1]);
				}				
			}
			dp[0][1] = array[0][1];
			dp[1][1] = array[1][1];
			
			for(int i = 2; i<=n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + array[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + array[1][i];
			}
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
		
	}

}
