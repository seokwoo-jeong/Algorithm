package backjon2.twopoint;

import java.io.*;

// https://www.acmicpc.net/problem/1806
// 부분합

public class TwoPoint03 {

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
		
		int start = 0;
		int end = 1;
		int sum = array[0];
		int length = 1;
		int count = Integer.MAX_VALUE;
		while(true) {
			if(start == n) {
				break;
			}
			
			if(sum >= s || end == n) { //s보다 넘거나 같아?  start++ || end == n
				if(sum >= s) {
					count = Math.min(count, length);
				}
				sum -= array[start];
				start++;
				length--;

			}else {		//s보다 안넘어? end 늘려
				sum += array[end];
				end++;
				length++;
			}
			
			//System.out.println(start + " " + end + " " + sum + " " + count);
		}
		
		if(count == Integer.MAX_VALUE) {
			count = 0;
		}
		
		System.out.println(count);
	}

}
