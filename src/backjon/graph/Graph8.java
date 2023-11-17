package backjon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//https://www.acmicpc.net/problem/7576
//토마토

//동시다발적으로 발생하므로 bfs를 이용하여 동시에 발생하는 이슈를 해결
public class Graph8 {
	static boolean[][] isVisited;
	static int[][] matrix;
	static int m;
	static int n;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] def = in.readLine().split(" ");
		m = Integer.parseInt(def[0]);
		n = Integer.parseInt(def[1]);
		matrix = new int[n][m];
		isVisited = new boolean[n][m];
		for(int i =0; i<n; i++) {
			String[] arr = in.readLine().split(" ");
			
			for(int j = 0; j<m; j++) {
				matrix[i][j] = Integer.parseInt(arr[j]);
			}
		}
		
		bfs();
		int result = 0;
		boolean flag = false;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(matrix[i][j] == 0) {
					result = -1;
					flag = true;
					break;
				}
				result = Math.max(result, matrix[i][j]-1);
			}
			if(flag) {
				break;
			}
		}
		System.out.println(result);
	}
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		for(int i =0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(matrix[i][j] == 1) {
					queue.offer(new int[] {i,j});
					isVisited[i][j] = true;
				}

			}
		}
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int arrX = arr[0];
			int arrY = arr[1];
			for(int i =0; i<dx.length; i++) {
				int nx = arrX + dx[i];
				int ny = arrY + dy[i];
				
				if((0<=nx && nx<n) && (0<=ny && ny<m) ) {
					if(!isVisited[nx][ny] && matrix[nx][ny] == 0) {
						queue.offer(new int[] {nx,ny});
						matrix[nx][ny] = matrix[arrX][arrY] + 1;
						isVisited[nx][ny] = true;
					}
				}
			}
			
		}
		
	}

}
