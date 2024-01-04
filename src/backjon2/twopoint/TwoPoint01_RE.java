package backjon2.twopoint;

import java.io.*;

//https://www.acmicpc.net/problem/2470
//두 용액(골5)

import java.util.Arrays;

public class TwoPoint01_RE {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		String[] temp = br.readLine().split(" ");
		
		int[] array = new int[n];
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(array);
		
		int left = 0;
		int right = n-1;
		
		int[] result = new int[2];
		int value = Integer.MAX_VALUE;
		int diff = 0;
		
		while(left < right) {
			diff = array[right] + array[left];
			
			if(Math.abs(diff) < Math.abs(value)) {
				value = diff;
				result[0] = array[left];
				result[1] = array[right];
			}
			
			if(diff > 0) {
				right --;
			}else {
				left ++;
			}

		}
		System.out.println(result[0] + " " + result[1]);
		
	}

}
