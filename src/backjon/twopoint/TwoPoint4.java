package backjon.twopoint;
import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/20922
// 겹치는 건 싫어
public class TwoPoint4 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		int[] array = new int[n];
		int[] countArray = new int[100001];
		
		temp = br.readLine().split(" ");
		for(int i =0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		int left = 0;
		int right = 0;
		int result = Integer.MIN_VALUE;
		
		while(left < n) {
			while(right < n && countArray[array[right]] < k) {
				countArray[array[right]] += 1;
				//System.out.println(array[right] + " " + countArray[array[right]]);
				right++;
				
			}
			result = Math.max(right-left, result);
			countArray[array[left]] -= 1;
			left++;
		}
	
		System.out.println(result);
		

	}

}
