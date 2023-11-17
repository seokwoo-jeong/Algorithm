package backjon2.binarySearch;

import java.io.*;

// https://www.acmicpc.net/problem/2805
// 나무 자르기 (실2)

public class BinarySearch04 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		int[] array = new int[n];
		
		temp = br.readLine().split(" ");
		
		long left = 0;		
		long right = 0;
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
			
			right = Math.max(array[i], right);
		}
		
		while(left <= right) {
			long mid = (left+right) / 2;
			
			long sum = 0;
			
			for(int i = 0; i<n; i++) {
				if(array[i] > mid) {
					sum += array[i]-mid;
				}
			}
			if(sum >= m) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
			
		}
		System.out.println(right);
		
	}

}
