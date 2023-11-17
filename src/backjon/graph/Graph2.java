package backjon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1260
// DFS와 BFS
public class Graph2 {
	static int[][] map;
	static boolean[] isVisited;
	static int n;
	static int m;
	public static void main(String[] args)  {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		int start = scanner.nextInt();
		map = new int[n+1][n+1];
		isVisited = new boolean[n+1];
		
		for(int i = 0; i<m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		dfs (start);
		
		for(int i = 0; i<n+1; i++) {
			isVisited[i] = false;
		}
		System.out.println();
		bfs(start);
	}

	private static void dfs (int start) {
		isVisited[start] = true;
		System.out.print(start + " ");
		for(int i = 0; i<n+1; i++) {
			if(map[start][i] == 1 && !isVisited[i]) {
				dfs(i);
			}
		}
		
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		isVisited[start] = true;
		while(!queue.isEmpty()) {
			start = queue.poll();
			System.out.print(start + " ");
			for(int i = 0; i<n+1; i++) {
				if(!isVisited[i] && map[start][i] == 1) {
					queue.offer(i);
					isVisited[i] = true;
				}
			}
		}
	}

}
