package backjon2.twopoint;

import java.io.*;

// https://www.acmicpc.net/problem/2559
// 수열 (실3)

public class TwoPoint08 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		temp = br.readLine().split(" ");
		
		int[] array = new int[n];
		
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		int start = 0;
		int end = k;
		
		int sum = 0;
		
		for(int i = 0; i<k; i++) {
			sum += array[i];
		}
		int result = sum;
		while(end < n) {
			sum -= array[start];
			sum += array[end];
			
			start++;
			end ++;
			
			result = Math.max(sum, result);
		}
		System.out.println(result);

	}

}
