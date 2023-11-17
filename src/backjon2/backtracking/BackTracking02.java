package backjon2.backtracking;
// https://www.acmicpc.net/problem/15650
// N과M (2) 실3

import java.io.*;
public class BackTracking02 {
	private static boolean[] isVisit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		int[] array = new int[m];
		isVisit = new boolean[n];
		
		dfs(n,array, 0,0);
	}
	
	private static void dfs(int n, int[] array, int depth, int before) {
		if(depth == array.length) {
			for(int answer : array) {
				System.out.print(answer+1 + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i =before; i<n; i++) {
			if(isVisit[i]) {
				continue;
			}
			
			isVisit[i] = true;
			array[depth] = i;
			dfs(n, array, depth+1, i);
			isVisit[i] = false;
		}
	}

}
