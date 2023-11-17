package backjon2.twopoint;

import java.io.*;

// https://www.acmicpc.net/problem/2003
// 수 들의 합2 실4

public class TwoPoint02 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		
		temp = br.readLine().split(" ");
		int[] array = new int[n];
	
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		
		int start = 0;
		int end = 0;
		int count = 0;
		int sum = 0;
		while(true) {
			if(start == n) {
				break;
			}
			
			if(end == n || sum > m) {
				sum -= array[start];
				start++;
			}else if(sum <=m) {
				sum += array[end];
				end++;
			}
			
			if(sum == m) {
				count++;
			}
			
		}
		System.out.println(count);
		
		
		

	}

}
