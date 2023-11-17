package backjon2.twopoint;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/21921
// 블로그 (실3)

public class TwoPoint07 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int x = Integer.parseInt(temp[1]);
		
		temp = br.readLine().split(" ");
		
		int[] array = new int[n];
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		int start = 0;
		int end = x;
		
		int sum = 0;
		for(int i = 0; i<x; i++) {
			sum += array[i];
		}
		int visit = sum;
		int count = 1;
		
		while(true) {
			if(end ==n) {
				break;
			}
			sum -= array[start];
			sum += array[end];
			start++;
			end++;
			
			if(visit < sum) {
				count = 1;
				visit = sum;
			}else if(visit == sum) {
				count +=1;
			}
		}
		
		if(visit == 0) {
			System.out.println("SAD");
		}else {
			System.out.println(visit);
			System.out.println(count);
		}
		
	}

}
