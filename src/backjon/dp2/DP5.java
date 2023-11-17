package backjon.dp2;
import java.io.*;

// https://www.acmicpc.net/problem/11066
// 파일 합치기
public class DP5 {
	// dp[i][j] = i부터 j까지 합치는 비용
	// dp[i][i] = array[i]
	// dp[i][i+1] = array[i] + array[i+1]
	// dp[i][i+2] = min(dp[i][i+1] + dp[i+2][i+2] + (array[i] + array[i+1] + array[i+2]), dp[i][i] + dp[i+1][i+2] + (array[i] + array[i+1] + array[i+2]))
	// dp[i][j] = min(dp[i][k] + dp[k+1][j] + sum(array[i~j])
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<t; i++) {
			int k = Integer.parseInt(br.readLine());
			int[] array = new int[k];
			int[] sum = new int[k];
			String[] temp = br.readLine().split(" ");
			
			for(int j = 0; j<k; j++) {
				array[j] = Integer.parseInt(temp[j]);
				if(j != 0) {
					sum[j] = sum[j-1] + array[j];
				}else {
					sum[0] = array[0];
				}
				
			}
			System.out.println(dp(k, array,sum));
		}

	}
	
	private static int dp(int n, int[] array, int[] sum) {
		int[][] dp = new int[n][n];
		
		for(int i = 0; i<n-1; i++) {
			dp[i][i+1] = array[i] + array[i+1];
		}
		
		for(int gap = 2; gap<n; gap++) {	//i부터 j까지의 차이
			for(int i = 0; i+gap<n; i++) {
				int j = i+gap;
				dp[i][j] = Integer.MAX_VALUE;
				
				for(int k = i; k<j; k++) {
					dp[i][j] = Math.min(dp[i][k] + dp[k+1][j] + sum(sum,i,j), dp[i][j]);
				}
			}
		}
		return dp[0][n-1];
	}
	
	private static int sum(int[] sum, int i, int j) {
		if(i == 0) {
			return sum[j];
		}else {
			return sum[j] - sum[i-1];
		}
	}

}
