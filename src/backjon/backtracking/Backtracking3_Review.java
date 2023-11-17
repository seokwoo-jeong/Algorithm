package backjon.backtracking;

import java.util.*;
import java.io.*;

public class Backtracking3_Review {
	private static int n;
	private static int m;
	private static int[] array;
	private static BufferedWriter out;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		array = new int[m];
		dfs(0);
		
		out.flush();
		out.close();
	}

	private static void dfs(int depth) throws IOException {
		if(depth == m) {
			for(int answer: array) {
				out.write(String.valueOf(answer) + " ");
			}
			out.newLine();
			return;
		}
		
		for(int i = 1; i<=n; i++) {
			array[depth] = i;
			dfs(depth+1);
		}
	}
}
