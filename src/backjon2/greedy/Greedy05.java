package backjon2.greedy;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/13164
// 행복 유치원 (골5)

public class Greedy05 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);	// 원생 수
		int k = Integer.parseInt(temp[1]);	// 조 개수
		
		temp = br.readLine().split(" ");
		
		int[] array = new int[n];
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		
		Integer[] diffArray = new Integer[n-1];
		int sum = 0;
		for(int i = 0; i<n-1; i++) {
			diffArray[i] = array[i+1] - array[i];
			sum += diffArray[i];
		}
		
		Arrays.sort(diffArray, Collections.reverseOrder());

		for(int i = 0; i<k-1; i++) {
			sum -= diffArray[i];
		}
		
		System.out.println(sum);
		

	}

}
