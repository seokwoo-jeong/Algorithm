package backjon2.backtracking;

import java.io.*;

// https://www.acmicpc.net/problem/15651
// N과 M (3) 실버3

public class BackTracking03 {
	private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		int[] array = new int[m];
		dfs(n, array, 0);
		
		br.close();
		out.flush();
		out.close();
	}
	
	private static void dfs(int n, int[] array, int depth) throws IOException {
		if(depth == array.length) {
			for(int answer : array) {
				out.write(String.valueOf(answer+1) + " ");
			}
			out.newLine();

			return;
		}
		
		
		for(int i = 0; i<n; i++) {
			array[depth] = i;
			dfs(n, array, depth+1);
			
		}
	}

}
