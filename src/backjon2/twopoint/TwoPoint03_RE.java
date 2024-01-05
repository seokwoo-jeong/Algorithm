package backjon2.twopoint;

import java.io.*;

// https://www.acmicpc.net/problem/1806
// 부분합(골4)

public class TwoPoint03_RE {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int s = Integer.parseInt(temp[1]);
		
		temp = br.readLine().split(" ");
		
		int[] array = new int[n];
		
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		int left = 0;
		int right = 0;
		int sum = array[0];
		int count = 1;
		int result = Integer.MAX_VALUE;
		
		while(left < n) {
			if(sum >= s) {
				result = Math.min(count, result);
			}
			
			if(sum < s) {
				right++;
				
				if(isDone(right,n)) {
					break;
				}
				
				sum += array[right];
				count++;
			}else {
				sum -= array[left];
				left++;
				count--;
			}
		}
		
		if(result == Integer.MAX_VALUE) {
			result = 0;
		}
		System.out.println(result);
	}
	private static boolean isDone(int cur, int n) {
		if(cur == n) {
			return true;
		}
		return false;
	}

}
