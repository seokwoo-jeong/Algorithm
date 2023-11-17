package backjon2.bfs;

import java.io.*;
import java.util.*;
// https://www.acmicpc.net/problem/1261
// 알고스팟 (골4)
public class BFS05 {
	private static char[][] matrix;
	private static int[][] value;
	private static boolean[][] isVisit;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	private static int n;
	private static int m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		m = Integer.parseInt(temp[0]);	//가로
		n = Integer.parseInt(temp[1]);	//세로
		
		matrix = new char[n][m];
		isVisit = new boolean[n][m];
		value = new int[n][m];
		for(int i = 0; i<n; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		bfs(0,0);
		System.out.println(value[n-1][m-1]);
	}
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		isVisit[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			for(int i = 0; i<dx.length; i++) {
				int newX = curX + dx[i];
				int newY = curY + dy[i];
				
				if(!isGo(newX, newY)) {
					continue;
				}
				
				if(matrix[newX][newY] == '1') {	// 벽인경우
					if(!isVisit[newX][newY] || value[newX][newY]>value[curX][curY]+1) {
						isVisit[newX][newY] = true;
						value[newX][newY] = value[curX][curY] + 1;
						queue.add(new int[] {newX,newY});
					}
					
				}else {	//벽 아닌경우
					if(!isVisit[newX][newY] || value[newX][newY] > value[curX][curY]) {
						isVisit[newX][newY] = true;
						value[newX][newY] = value[curX][curY];
						queue.add(new int[] {newX,newY});
					}
				}
				
			}
		}
	}
	private static boolean isGo(int x, int y) {
		if(0<= x && x <n && 0<=y && y < m) {
			return true;
		}
		return false;
	}

}
