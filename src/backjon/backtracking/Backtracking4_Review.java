package backjon.backtracking;

import java.util.*;
import java.io.*;

public class Backtracking4_Review {
	
	private static int n;
	private static int m;
	private static int[] array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		array = new int[m];
		
		
		dfs(0, 1);
		

	}
	private static void dfs(int depth, int start) {
		if(depth == m) {
			for(int answer: array) {
				System.out.print(answer + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i<=n; i++) {
			array[depth] = i;
			dfs(depth+1, i);
		}
	}

}
