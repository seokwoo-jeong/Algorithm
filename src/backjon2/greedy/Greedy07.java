package backjon2.greedy;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2212
// 센서 (골5)


public class Greedy07 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		if(n<=k) {
			System.out.println(0);
			return;
		}
		
		String[] temp = br.readLine().split(" ");
		
		int[] array = new int[n];
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(array);
		
		int sum = 0;
		Integer[] diffArray = new Integer[n-1];
		for(int i = 0; i<n-1; i++) {
			diffArray[i] = array[i+1] - array[i];
			sum += diffArray[i];
		}
		
		Arrays.sort(diffArray,Collections.reverseOrder());
		
		for(int i = 0; i<k-1; i++) {
			sum -= diffArray[i];
		}
		
		System.out.println(sum);
		
		
	}

}
