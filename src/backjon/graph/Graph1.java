package backjon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// https://www.acmicpc.net/problem/13023
// ABCDE
public class Graph1 {
	static boolean[] isVisited;
	static int result;
	static ArrayList<Integer>[] map;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] def = in.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		m = Integer.parseInt(def[1]);
		map = new ArrayList[n];
		isVisited = new boolean[n];
		
		for(int i =0; i<n; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0; i<m; i++) {
			String[] friends = in.readLine().split(" ");
			map[Integer.parseInt(friends[0])].add(Integer.parseInt(friends[1]));
			map[Integer.parseInt(friends[1])].add(Integer.parseInt(friends[0]));
		}
		
		for(int i = 0; i<n; i++) {
			if(result == 0) {
				dfs(i,0);
			}else {
				break;
			}
		}
		System.out.println(result);
	}
	private static void dfs(int start, int count) {
		if(count == 4) {
			result = 1;
			return;
		}
		
		isVisited[start] = true;
		for(int a: map[start]) {
			if(!isVisited[a]) {
				dfs(a, count+1);
			}
		}
		isVisited[start] = false;		//모든 경우의 수를 찾아야 하므로 backtracking으로 구현
	}
}
