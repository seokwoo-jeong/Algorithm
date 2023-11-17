package backjon2.twopoint;

import java.io.*;

// https://www.acmicpc.net/problem/2470
// 두 용액(골5)

import java.util.Arrays;

public class TwoPoint01 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] temp = br.readLine().split(" ");
		
		int[] array = new int[n];
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(array);
		
		int start = 0;
		int end = n-1;
		// -99 -2 -1 4 98
		int min = Integer.MAX_VALUE;
		int beforeS = 0;
		int beforeE = 0; 
		while(start < end) {
			int sum = array[start] + array[end];
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				beforeS = array[start];
				beforeE = array[end];
				
			}
			
			if(sum < 0) {
				start ++;
			}else if(sum>0) {
				end--;
			}else {
				break;
			}
		}
		
		System.out.print(beforeS + " " + beforeE);

	}

}
