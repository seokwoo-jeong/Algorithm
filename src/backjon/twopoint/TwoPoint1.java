package backjon.twopoint;

import java.io.*;

// https://www.acmicpc.net/problem/2003
// 수들의 합 2
public class TwoPoint1 {
	private static int n; // array size
	private static int m; // sum
	private static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);

		temp = br.readLine().split(" ");
		array = new int[n];
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int count = 0;
		while(true) {
			if(start ==n ) {
				break;
			}
			if(sum >= m || end == n) {
				sum -= array[start];
				start++;
			}else if(sum<m) {
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
