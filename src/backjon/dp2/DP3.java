package backjon.dp2;
import java.io.*;

// https://www.acmicpc.net/problem/10942
// 팰린드롬?
public class DP3 {
	private static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		String[] temp = br.readLine().split(" ");
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		boolean[][] dp = setDP(array);
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<m; i++) {
			String[] line = br.readLine().split(" ");
			int start = Integer.parseInt(line[0]) -1;
			int finish = Integer.parseInt(line[1])-1;
			if(dp[start][finish]) {
				sb.append("1\n");
			}else {
				sb.append("0\n");
			}
		}
		System.out.print(sb.toString());

	}
	
	private static boolean[][] setDP(int[] array){
		boolean[][] dp = new boolean[n][n];
		
		for(int i = 0; i<n; i++) { //start:i
			for(int j = 0; j<n; j++) {	//finish:j
				dp[i][j] = isPel(array, i,j);
			}
		}
		
		return dp;
	}
	private static boolean isPel(int[] array, int start, int finish) {
		while(start <= finish) {
			if(array[start] != array[finish]) {
				return false;
			}
			start++;
			finish--;
		}
		return true;
	}

}
