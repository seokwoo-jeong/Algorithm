package backjon2.greedy;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1092
// 배 (골5)

public class Greedy08_RE {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] crainArray = new int[n];
		
		String[] temp = br.readLine().split(" ");
		for(int i = 0; i<n; i++) {
			crainArray[i] = Integer.parseInt(temp[i]);
		}
		
		int m = Integer.parseInt(br.readLine());
		
		int[] boxArray = new int[m]; 
		
		temp = br.readLine().split(" ");
		for(int i = 0; i<m; i++) {
			boxArray[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(crainArray);
		Arrays.sort(boxArray);
		
		int crainIndex = n-1;
		int boxIndex = m-1;
		
		if(crainArray[crainIndex] < boxArray[boxIndex]) {
			System.out.println(-1);
			return;
		}
		
		boolean flag = true;
		int result = 0;
		boolean[] isVisit = new boolean[m];
		int count = m;
		int lastBoxIndex = m-1;
		boolean isFirstIn = false;
		while(count > 0) {
			flag = true;
			isFirstIn = true;
			while(flag) {
				if(!isVisit[boxIndex]) {
					if(crainArray[crainIndex] >= boxArray[boxIndex]) {
						count--;
						isVisit[boxIndex] = true;
						boxIndex--;
						crainIndex--;
						if(isFirstIn) {
							lastBoxIndex = boxIndex;
							isFirstIn = false;
						}
					}else {
						boxIndex--;
					}
				}else {
					boxIndex--;
				}
				
				if(crainIndex < 0 || boxIndex < 0) {
					result++;
					flag = false;
				}
			}
			crainIndex = n-1;
			boxIndex = lastBoxIndex;
		}
		
		System.out.println(result);
	}

}
