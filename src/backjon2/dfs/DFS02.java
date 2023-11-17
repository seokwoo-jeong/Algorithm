package backjon2.dfs;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2668
// 숫자고르기 (골5)

public class DFS02 {

	private static int[][] matrix;
	private static boolean[] isVisit;
	private static HashSet<Integer> hash;
	private static ArrayList<Integer> array;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		matrix = new int[2][n];
		isVisit = new boolean[n];
		
		for(int i = 0; i<n; i++) {
			matrix[0][i] = i+1;
			matrix[1][i] = Integer.parseInt(br.readLine());
		}
		
		hash = new HashSet<>();
		array = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			dfs(i);
			
			if(!isSame()) {
				revoke();
			}else {
				result.addAll(result.size(), array);
			}
			hash = new HashSet<>();
			array = new ArrayList<>();
		}
		Collections.sort(result);
		
		System.out.println(result.size());
		for(int r : result) {
			System.out.println(r);
		}
		
	}
	private static void revoke() {
		for(int a : array) {
			isVisit[a-1] = false;
		}
	}
	
	private static boolean isSame() {
		for(int a : array) {
			if(!hash.contains(a)) {
				return false;
			}
		}
		return true;
	}
	
	private static void dfs(int y) {
		if(isVisit[y]) {
			return;
		}
		hash.add(matrix[1][y]);
		array.add(y+1);
		
		isVisit[y] = true;
		
		dfs(matrix[1][y]-1);
	}

}
