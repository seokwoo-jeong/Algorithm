package backjon2.backtracking;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15649
// N과 M (1) 실3
public class BackTracking01 {
	private static boolean[] isVisit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int[] array = new int[m];
		isVisit = new boolean[n];
		dfs(n, array,0);

	}
	
	private static void dfs(int n, int[] array, int depth) {
		if(depth == array.length) {
			for(int i = 0; i<array.length; i++) {
				System.out.print(array[i]+1 + " ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i = 0; i<n; i++) {
			if(isVisit[i]) {
				continue;
			}
			isVisit[i] = true;
			array[depth] = i;
			dfs(n,array,depth+1);
			isVisit[i] = false;
			
		}
	}

}
