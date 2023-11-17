package backjon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//https://www.acmicpc.net/problem/2178
//미로탐색

//dfs의 경우 최단거리를 찾을려면 backtracking을 이용해 완전탐색을 한 후, 최단거리 비교를 해서 최소값을 찾아야한다.
//그래서 최단거리 문제의 경우 최단거리가 보장이 되는 bfs를 이용해서 풀어주어야 한다.
public class Graph7 {
	static char[][] matrix;
	static int[][] isVisited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,1,0};
	static int n;
	static int m;
	static int result;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		matrix = new char[n][m];
		isVisited = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			matrix[i]  = scanner.next().toCharArray();
		}
		bfs(0,0);
		
		System.out.println(isVisited[n-1][m-1]);
		

	}
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>(); 
		isVisited[x][y] = 1;
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int arrX = arr[0];
			int arrY = arr[1];
			
			for(int i = 0; i<dx.length; i++) {
				int nx = arrX + dx[i];
				int ny = arrY + dy[i];
				
				if((0<=nx && nx<n) && (0<=ny && ny<m)) {
					if(isVisited[nx][ny] == 0 && matrix[nx][ny] == '1') {
						isVisited[nx][ny] = isVisited[arrX][arrY] + 1;
						queue.add(new int[] {nx,ny});
					}
					
				}
			}
		}
		
	}

}
