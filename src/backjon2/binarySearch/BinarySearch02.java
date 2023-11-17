package backjon2.binarySearch;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2512
// 예산 (실2)

public class BinarySearch02 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] temp = br.readLine().split(" ");
		
		int[] array = new int[n];
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(array);
		
		long pay = Integer.parseInt(br.readLine());
		long left = 0;
		long right = array[n-1];
		
		while(left <= right) {
			long middle = (left+right)/2;
			
			long sum = 0;
			
			for(int money : array) {
				if(money >= middle) {
					sum+=middle;
				}else {
					sum += money;
				}
			}
			
			if(sum > pay) {
				right = middle-1;
			}else {
				left = middle+1;
			}
		}
		System.out.println(right);
	}

}
