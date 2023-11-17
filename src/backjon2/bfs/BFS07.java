package backjon2.bfs;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/3055
// 탈출 (골4)

public class BFS07 {

	private static char[][] matrix;
	private static boolean[][] isVisit;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	private static int n;
	private static int m;
	private static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		int x = 0;
		int y = 0;
		ArrayList<int[]> waterArray = new ArrayList<>();
		matrix = new char[n][m];
		isVisit = new boolean[n][m];
		
		for(int i = 0; i<n; i++) {
			matrix[i] = br.readLine().toCharArray();
			
			for(int z = 0; z<m; z++) {
				
				if(matrix[i][z] == 'S') {
					x = i;
					y = z;
				}else if(matrix[i][z] == '*') {
					waterArray.add(new int[] {i,z,0});
				}
			}
			
		}
		
		if(bfs(x,y,waterArray)) {
			System.out.println(result);
		}else {
			System.out.println("KAKTUS");
		}
	}
	
	private static boolean bfs(int x, int y, ArrayList<int[]> waterArray) {
		
		Queue<int[]> queue = new LinkedList<>();
		Queue<int[]> waterQueue = new LinkedList<>();
		
		isVisit[x][y] = true;
		queue.add(new int[] {x,y,0});
		
		for(int[] water : waterArray) {
			waterQueue.add(water);
		}
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			int curT = cur[2];
			
			
			while(!waterQueue.isEmpty() && waterQueue.peek()[2] == curT) {
				moveWater(waterQueue);
			}
			
			for(int i = 0; i<dx.length; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(isOut(nx,ny)) {
					continue;
				}
				if(isVisit[nx][ny]) {
					continue;
				}
				
				if(matrix[nx][ny] == '.') {
					isVisit[nx][ny] = true;
					queue.add(new int[] {nx,ny,curT+1});
				}else if(matrix[nx][ny] == 'D') {
					result = curT+1;
					return true;
				}
			}
		}
		return false;
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
				queue.add(new int[] {nx,ny, curT+1});
			}
		}
	}
	
	private static boolean isOut(int x,int y) {
		if(0<= x && x < n && 0<=y && y <m) {
			return false;
		}
		return true;
	}
	

}
