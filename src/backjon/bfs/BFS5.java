package backjon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BFS5 {
//https://www.acmicpc.net/problem/1261
//알고스팟
	static boolean[][] isVisited;
	static char[][] matrix;
	static int[][] countMatrix;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] def = in.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		m = Integer.parseInt(def[1]);
		isVisited = new boolean[m][n];
		matrix = new char[m][n];
		countMatrix = new int[m][n];
		for(int i = 0; i<m; i++) {
			matrix[i] = in.readLine().toCharArray();
		}
		
		bfs(0,0);

		System.out.println(countMatrix[m-1][n-1]);
	}
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		isVisited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			int startX = xy[0];
			int startY = xy[1];
			
			for(int i =0; i<dx.length; i++) {
				int nx = startX + dx[i];
				int ny = startY + dy[i];
				
				if(0<=nx&& nx<m && 0<=ny && ny<n) {
					if(matrix[nx][ny] == '1') {//벽을 만난경우
						if(!isVisited[nx][ny] || countMatrix[startX][startY] + 1 < countMatrix[nx][ny]) { //한번도 방문하지 않은경우  or 현재방문+1이 전 방문 값보다 작은 경우
							countMatrix[nx][ny] = countMatrix[startX][startY] + 1;
							isVisited[nx][ny] = true;
							queue.offer(new int[] {nx,ny});
						}
						
					}else {//벽을 만나지 않은경우
						if(!isVisited[nx][ny] || countMatrix[startX][startY] < countMatrix[nx][ny]) { //한번도 방문하지 않은경우 or 현재방문이 전 방문보다 값이 작은 경우 
							countMatrix[nx][ny] =  countMatrix[startX][startY] ;
							isVisited[nx][ny] = true;
							queue.offer(new int[] {nx,ny});
						}
					}
				}
			}
		}
		
	}

}
