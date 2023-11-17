package backjon2.twopoint;

import java.io.*;

// https://www.acmicpc.net/problem/20922
// 겹치는 건 싫어 (실1)

public class TwoPoint04 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);	// 배열길이 n
		int k = Integer.parseInt(temp[1]);	// 원소 k개 이하
		
		int[] array = new int[n];
		temp = br.readLine().split(" ");
		
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		int[] countArray = new int[100001];
		int start = 0;
		int end = 0;
		int count = 0;
		int result = Integer.MIN_VALUE;
		while(end < n) {
			
			if(countArray[array[end]] ==k){
				count--;
				countArray[array[start]]--;
				start++;
				
			}else {
				countArray[array[end]]++;
				count++;
				end++;
				result = Math.max(count, result);
			}
			//System.out.println(start + " " + end + " " + count);
		}
		
		System.out.println(result);
	}

}
