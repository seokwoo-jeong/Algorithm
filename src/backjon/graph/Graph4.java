package backjon.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph4 {
	static ArrayList<ArrayList<Integer>> array;
	static int[] isVisited;
	static int v;
	static int e;
	static String result;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		
		for(int i =0; i<k; i++) {
			result = "YES";
			v = scanner.nextInt();
			e = scanner.nextInt();
			array = new ArrayList<>();
			isVisited = new int[v+1];
			
			for(int j = 0; j<v+1; j++) {
				isVisited[j] = 0;	//0이면 아직방문x, 1이면 흰, -1이면 검
				array.add(new ArrayList<Integer>());
			}
			
			for(int z = 0; z<e; z++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				array.get(a).add(b);
				array.get(b).add(a);
			}
			for(int q = 1; q<v+1; q++) {
				if(isVisited[q] == 0) {
					dfs(q, 1);
				}
			}
			
			System.out.println(result);
		}

	}
	private static void dfs(int start, int color) {
		isVisited[start] = color;
		for(int i : array.get(start)) {
			if(isVisited[i] == color) {
				result = "NO";
				return;
			}
			
			
			if(isVisited[i] == 0) {
				dfs(i,-color);
			}
		}
		
	}

}
