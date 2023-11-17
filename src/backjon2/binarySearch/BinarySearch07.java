package backjon2.binarySearch;

// https://www.acmicpc.net/problem/2343
// 기타 레슨 (실1)

import java.io.*;

public class BinarySearch07 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		int[] array = new int[n];
		
		temp = br.readLine().split(" ");
		
		int min = 1;
		int max = 0;
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
			
			max += array[i];
			min = Math.max(min, array[i]);
		}
		
		while(min <= max) {
			int mid = (min+max)/2;
			
			int sum = 0;
			int count = 0;
			for(int minute : array) {
				sum += minute;
				
				if(sum > mid) {
					sum = minute;
					count++;
				}
			}
			if(sum != 0) {
				count++;
			}
			
			if(count > m) {
				min = mid+1;
			}else {
				max = mid-1;
			}
		}
		
		System.out.println(min);
	}

}
