package backjon2.greedy;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2212
// 센서 (골5)


public class Greedy07_RE {

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
		
		int[] diff = new int[n-1];
		int sum = 0;
		
		for(int i = 0; i<n-1; i++) {
			diff[i] = array[i+1] - array[i];
			sum += diff[i];
		}
		
		Arrays.sort(diff);
		
		for(int i = n-2; i>n-k-1; i--) {
			sum -= diff[i];
		}
		System.out.println(sum);
	}

}
