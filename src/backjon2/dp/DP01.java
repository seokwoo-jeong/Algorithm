package backjon2.dp;

import java.io.*;

// https://www.acmicpc.net/problem/2748
// 피보나치 수2 (브1)

public class DP01 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] array = new long[n+1];
		
		array[0] = 0;
		array[1] = 1;
		
		for(int i = 2; i<n+1; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		System.out.println(array[n]);

	}

}
