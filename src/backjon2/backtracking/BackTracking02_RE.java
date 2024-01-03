package backjon2.backtracking;
//https://www.acmicpc.net/problem/15650

//N과M (2) 실3

import java.io.*;

public class BackTracking02_RE {
	private static int n;
	private static int m;
	private static boolean[] isVisit;
	private static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		isVisit = new boolean[n];
		array = new int[m];
		
		dfs(0,0);

	}
	
	private static void dfs(int depth, int before) {
		if(depth == m) {
			for(int result : array) {
				System.out.print(result+1 + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = before; i<n; i++) {
			if(isVisit[i]) {
				continue;
			}
			isVisit[i] = true;
			array[depth] = i;
			dfs(depth+1, i);
			isVisit[i] = false;
		}
	}

}
