package backjon2.twopoint;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1940
// 주몽 (실4)

public class TwoPoint06 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		String[] temp = br.readLine().split(" ");
		
		
		int[] array = new int[n];
		for(int i = 0 ; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(array);
		
		int start = 0;
		int end = n-1;
		
		int sum = 0;
		int count = 0;
		while(start < end) {
			sum = array[start] + array[end];
			if(sum > m) {
				end --;
			}else if(sum < m){
				start ++;
			}else {
				//System.out.println(array[start] + " " + array[end]);
				count++;
				end--;
				
			}
		}
		System.out.println(count);
			

	}

}
