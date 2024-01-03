package backjon2.backtracking;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15649
// N과 M (1) 실3
public class BackTracking01_RE {

	private static int[] array;
	private static boolean[] isVisit;
	private static int n;
	private static int m;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		array = new int[m];
		isVisit = new boolean[n];
		
		dfs(0);

	}

	private static void dfs(int depth) {
		if(depth == m) {
			for(int result : array) {
				System.out.print(result+1 + " ");
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
			dfs(depth+1);
			isVisit[i] = false;
		}
	}
}
