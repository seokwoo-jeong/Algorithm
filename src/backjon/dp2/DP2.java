package backjon.dp2;
import java.io.*;

// https://www.acmicpc.net/problem/11060
// 점프 점프
public class DP2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] temp = br.readLine().split(" ");
		int[] array = new int[n];
		int[] dp = new int[n];
		boolean[] isVisit = new boolean[n];
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		dp[0] = 0;
		isVisit[0] = true;
		for(int i = 1; i<n; i++) {
			for(int j = i-1; j>=0; j--) {
				if(array[j] == 0 || !isVisit[j]) {
					continue;
				}
				if(i-j <= array[j]) {
					if(dp[i] == 0) {
						isVisit[i]  = true;
						dp[i] = dp[j]+1;
					}else {
						dp[i] = Math.min(dp[i], dp[j]+1);
					}
					
				}
			}
		}

		if(n==1) {
			System.out.println(0);
		}else if(dp[n-1] == 0) {
			System.out.println(-1);
		}else {
			System.out.println(dp[n-1]);
		}
	}

}
