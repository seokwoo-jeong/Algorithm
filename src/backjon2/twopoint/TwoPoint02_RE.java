package backjon2.twopoint;

import java.io.*;

// https://www.acmicpc.net/problem/2003
// 수 들의 합2 실4

public class TwoPoint02_RE {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		int[] array = new int[n];
		
		temp = br.readLine().split(" ");
		
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		int left = 0;
		int right = 0;
		int sum = array[0];
		int result = 0;
		while(left < n) {
			if(sum == m) {
				result++;
			}
			if(sum < m) {
				right++;
				if(right == n) {
					break;
				}
				sum += array[right];
			}else {
				sum -= array[left];
				left++;
			}
		}
		System.out.println(result);
	}

}
