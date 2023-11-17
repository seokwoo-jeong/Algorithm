package backjon.dp2;
import java.io.*;

// https://www.acmicpc.net/problem/11048
// 이동하기
public class DP1 {
	private static int n;
	private static int m;
	private static int[][] matrix;
	private static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		matrix = new int[n][m];
		dp = new int[n][m];
		for(int i = 0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j<line.length; j++) {
				matrix[i][j] = Integer.parseInt(line[j]);
				
				
			}
		}
		dp[0][0] = matrix[0][0];
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(i == 0 && j == 0) {
					continue;
				}
				if(i-1 < 0) {
					dp[i][j] = dp[i][j-1] + matrix[i][j];
				}else if(j-1 <0) {
					dp[i][j] = dp[i-1][j] + matrix[i][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j] + matrix[i][j], dp[i][j-1] + matrix[i][j]);
				}
				
				
			}
		}
		System.out.println(dp[n-1][m-1]);

	}

}
