package backjon.graph;

import java.util.Scanner;
// https://www.acmicpc.net/problem/11724
// 연결 요소의 개수
public class Graph3 {
	static int n;
	static int m;
	static int[][] matrix;
	static boolean[] isVisited;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		matrix = new int[n+1][n+1];
		isVisited = new boolean[n+1];
		int result = 0;
		for(int i = 0; i<m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}
		
		for(int i = 1; i<=n; i++) {
			if(!isVisited[i]) {
				dfs(i);
				result++;
			}
			
		}
		System.out.println(result);

	}
	private static void dfs(int start) {
		isVisited[start] = true;
		for(int i =1; i<=n;i++) {
			if(!isVisited[i] && matrix[start][i]== 1) {
				dfs(i);
			}
		}
		
	}

}
