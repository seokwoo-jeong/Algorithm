package backjon2.twopoint;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/20922
// 겹치는 건 싫어 (실1)

public class TwoPoint04_RE {

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
		
		Map<Integer,Integer> hash= new HashMap<>();
		
		int left = 0;
		int right = 0;
		int count = 0;
		int result = Integer.MIN_VALUE;
		
		int value = 0;
		while(left < n) {
			result = Math.max(count, result);
			
			if(right < n && isNextOk(array[right],k, hash) ) {
				count++;
				if(!hash.containsKey(array[right])) {
					hash.put(array[right], 1);
				}else {
					value = hash.get(array[right]);
					hash.remove(array[right]);
					hash.put(array[right], value+1);					
				}
				right++;
			}else {
				count--;
				value = hash.get(array[left]);
				hash.remove(array[left]);
				hash.put(array[left], value-1);
				left++;
			}
		}
		System.out.println(result);
	}
	private static boolean isNextOk(int key, int k, Map<Integer,Integer> hash) {
		if(!hash.containsKey(key)) {
			return true;
		}
		
		if(hash.get(key) +1 > k) {
			return false;
		}
		
		return true;
	}

}
