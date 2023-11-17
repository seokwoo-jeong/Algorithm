package backjon2.binarySearch;

import java.io.*;

// https://www.acmicpc.net/problem/6236
// 용돈 관리 (실2)

public class BinarySearch05 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);	// 100,000
		int m = Integer.parseInt(temp[1]);	// 100,000

		int[] array = new int[n];
		int min = 0;
		int max = 0;
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(br.readLine());
			
			min = Math.max(array[i], min);
			max += array[i];
		}
		
		while(min <= max) {
			int mid = (min+max) / 2;
			
			int sum = 0;
			int count = 1;
			
			for(int money : array) {
				sum += money;
				
				if(sum > mid) {
					sum = money;
					count++;
				}
			}
			
			if(count > m) {
				min = mid + 1;
			}else {
				max = mid -1;
			}
		}
		System.out.println(min);
	}

}
