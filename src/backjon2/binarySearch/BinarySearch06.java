package backjon2.binarySearch;

import java.io.*;

// https://www.acmicpc.net/problem/1654
// 렌선 자르기 (실2)

public class BinarySearch06 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int k = Integer.parseInt(temp[0]);
		int n = Integer.parseInt(temp[1]);
		
		long[] array = new long[k];
		
		long min = 1;
		long max = 0;
		for(int i = 0; i<k; i++) {
			array[i] = Long.parseLong(br.readLine());
			
			max = Math.max(max, array[i]);
		}
		
		while(min <= max) {
			long mid = (min+max)/2;
			
			long count = 0;
			
			for(long line : array) {
				count += (line / mid);
			}
			
			if(count < n) {
				max = mid-1;
			}else {
				min = mid+1;
			}
			
		}
		System.out.println(max);


	}

}
