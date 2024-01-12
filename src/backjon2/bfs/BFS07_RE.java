package backjon2.bfs;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/3055
// 탈출 (골4)

public class BFS07_RE {

	private static char[][] matrix;
	private static boolean[][] isVisit;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	private static int result;
	private static int n;
	private static int m;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		matrix = new char[n][m];
		isVisit = new boolean[n][m];
		
		result = Integer.MAX_VALUE;
		
		
		int x = 0;
		int y = 0;
		
		Queue<int[]> waterQueue= new LinkedList<>();
		for(int i = 0; i<n; i++) {
			matrix[i] = br.readLine().toCharArray();
			
			for(int z = 0; z<m; z++) {
				if(matrix[i][z] == 'S') {	//현재 고슴도치 위치
					x = i;
					y = z;
					matrix[i][z] = '.';
				} else if(matrix[i][z] == '*') { //물
					waterQueue.add(new int[] {i,z,0});
				}
			}
		}
		bfs(x,y,waterQueue);
		
		if(result == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(result);
		}
	}

	private static void bfs(int x,int y, Queue<int[]> waterQueue) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y,0});
		isVisit[x][y] = true;
		boolean flag = false;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int curX = cur[0];
			int curY = cur[1];
			int curT = cur[2];
			
			while(!waterQueue.isEmpty() && curT == waterQueue.peek()[2]) {
				moveWater(waterQueue);
			}
			
			for(int i = 0; i<dx.length; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(isOut(nx,ny) || isVisit[nx][ny]) {
					continue;
				}
				
				if(matrix[nx][ny] == 'D') {
					result = curT+1;
					flag = true;
					break;
				}
				
				if(matrix[nx][ny] != '.') {
					continue;
				}
				queue.add(new int[] {nx,ny,curT+1});
				isVisit[nx][ny] = true;
			}
			if(flag) {
				break;
			}
		}
	}
	
	private static void moveWater(Queue<int[]> queue) {
		int[] cur = queue.poll();
		int curX = cur[0];
		int curY = cur[1];
		int curT = cur[2];
		
		for(int i = 0; i<dx.length; i++) {
			int nx = curX + dx[i];
			int ny = curY + dy[i];
			
			if(isOut(nx,ny)) {
				continue;
			}
			
			if(matrix[nx][ny] == '.') {
				matrix[nx][ny] = '*';
				queue.add(new int[] {nx,ny,curT+1});
			}
		}
	}
	
	private static boolean isOut(int x, int y) {
		if(0<= x && x <n && 0<= y && y < m) {
			return false;
		}
		return true;
	}

}
