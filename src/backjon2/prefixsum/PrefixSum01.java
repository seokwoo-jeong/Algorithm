package backjon2.prefixsum;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/14929
// 귀찮아(실5)

public class PrefixSum01 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		int[] prefixSum = new int[n+1];
		int sum = 0;
		
		String[] temp = br.readLine().split(" ");
		
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
			sum += array[i];
			prefixSum[i+1] = sum;
		}
		
		int cur = 0;
		int sumCur = 0;
		long result = 0;
		for(int i = 0; i<n; i++) {
			cur = array[i];
			sumCur = prefixSum[n] - prefixSum[i+1];
			result += cur * sumCur;
		}
		System.out.println(result);
	}

}
