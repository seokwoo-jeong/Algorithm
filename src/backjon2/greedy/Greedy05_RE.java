package backjon2.greedy;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/13164
// 행복 유치원 (골5)

public class Greedy05_RE {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		int[] array = new int[n];
		
		temp = br.readLine().split(" ");
		
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		int[] diff = new int[n-1];
		int diffSum = 0;
		for(int i = 0; i<n-1; i++) {
			diff[i] = array[i+1] - array[i];
			diffSum += diff[i];
		}
		
		Arrays.sort(diff);
		
		for(int i = n-2; i>=n-k; i--) {
			diffSum -= diff[i]; 
		}
		System.out.println(diffSum);
	}
}
