package backjon2.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// https://www.acmicpc.net/problem/15656
// N과 M (7)
public class BackTracking07_RE {
	
	private static int[] array;
	private static int n;
	private static int m;
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		sb = new StringBuilder();
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		temp = br.readLine().split(" ");
		
		array = new int[n];
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(array);
		
		int[] answer = new int[m];
		
		dfs(0,answer);
		System.out.println(sb.toString());
		
	}
	private static void dfs(int depth, int[] answer) {
		if(depth == m) {
			for(int a : answer) {
				sb.append(a + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i<n; i++) {
			answer[depth] = array[i];
			dfs(depth+1,answer);
		}
		
	}

}