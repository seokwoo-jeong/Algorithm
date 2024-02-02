package backjon2.backtracking;
// https://www.acmicpc.net/problem/15657
// N과 M (7)

import java.io.*;
import java.util.Arrays;

public class BackTracking08_RE {
	
	private static int[] array;
	private static int n;
	private static int m;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		array = new int[n];
		
		temp = br.readLine().split(" ");
		
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(array);
		sb = new StringBuilder();
		dfs(0,0,new int[m]);
		System.out.println(sb.toString());
	}
	
	private static void dfs(int depth, int start, int[] answer) {
		if(depth == m) {
			for(int a : answer) {
				sb.append(a + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < n; i++) {
			answer[depth] = array[i];
			dfs(depth+1,i,answer);
		}
	}
	
	
}
