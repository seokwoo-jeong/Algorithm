package backjon2.dfs;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/9466
// 텀 프로젝트 (골3)

public class DFS04 {
	
	private static boolean[] isVisit;
	private static int[] array;
	private static boolean[] done;
	private static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int t = Integer.parseInt(br.readLine());
		int round = 0;
		
		String[] temp = null;
		StringBuilder sb = new StringBuilder();
		while(round < t) {
			int n = Integer.parseInt(br.readLine());
			
			isVisit = new boolean[n];
			temp = br.readLine().split(" ");
			array = setArray(temp);
			done = new boolean[n];
			
			for(int i = 0; i<n; i++) {
				if(!done[i]) {
					dfs(i);
				}
			}
			sb.append(n-result + "\n");
			result=0;
			round ++;
		}
		System.out.println(sb.toString());
	}
	
	private static void dfs(int index) {

		if(done[index]) {
			return;
		}
		
		if(isVisit[index]) {
			done[index] = true;
			result++;
		}
		
		isVisit[index] = true;
		dfs(array[index]);
		done[index] = true;
		isVisit[index] =false;
	}
	
	private static int[] setArray(String[] temp) {
		int[] array = new int[temp.length];
		
		for(int i = 0; i<temp.length; i++) {
			array[i] = Integer.parseInt(temp[i])-1;
		}
		
		return array;
	}

}
