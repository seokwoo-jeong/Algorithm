package backjon2.greedy;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1092
// 배 (골5)

public class Greedy08 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Integer[] crainArray = new Integer[n];
		String[] temp = br.readLine().split(" ");
		
		for(int i = 0; i<n; i++) {
			crainArray[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(crainArray, Collections.reverseOrder());
		
		int m = Integer.parseInt(br.readLine());
		Integer[] boxArray = new Integer[m];
		temp = br.readLine().split(" ");
		
		for(int i = 0; i<m; i++) {
			boxArray[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(boxArray, Collections.reverseOrder());
		
		
		if(boxArray[0] > crainArray[0]) {
			System.out.println(-1);
			return;
		}
		
		boolean[] isVisit = new boolean[m];
		int count = 0;
		int result = 0;
		
		int boxIndex = 0;
		int crainIndex = 0;
		while(count < m) {
			if(boxArray[boxIndex] <= crainArray[crainIndex]) {
				if(!isVisit[boxIndex]) {
					isVisit[boxIndex] = true;
					count++;
					boxIndex++;
					crainIndex++;					
				}else {
					boxIndex++;
				}
			}else {
				boxIndex++;
			}
			
			if(crainIndex == n || boxIndex == m) {
				crainIndex = 0;
				boxIndex = 0;
				result++;
			}
		}
		if(crainIndex != 0) {
			result++;
		}
		
		System.out.println(result);
	}

}
