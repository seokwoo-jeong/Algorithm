package backjon2.simulation;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/16234
// 인구 이동(골4)

public class Simulation03 {

	private static int[][] matrix;
	private static boolean[][] isVisit;
	
	private static int n;
	private static int l;
	private static int r;
	
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	private static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		n = Integer.parseInt(temp[0]); // size
		l = Integer.parseInt(temp[1]); // L명이상
		r = Integer.parseInt(temp[2]); // R명이하

		matrix = new int[n][n];
		isVisit = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for(int z= 0; z<n; z++) {
				matrix[i][z] = Integer.parseInt(temp[z]);
			}
		}
		
		
		int result = 0;
		while(true) {
			flag = false;
			for(int i = 0; i<n; i++) {
				for(int z = 0; z<n; z++) {
					if(!isVisit[i][z]) {
						bfs(i,z);
					}
				}
			}
			if(!flag) {
				break;
			}
			
			result++;
			isVisit = new boolean[n][n];
			
			/*
			for(int i = 0; i <n; i++) {
				for(int z = 0; z<n; z++) {
					System.out.print(matrix[i][z] + " ");
				}
				System.out.println();
			}
			System.out.println("--------------");
			*/
		}
		System.out.println(result);

	}
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		isVisit[x][y] = true;
		ArrayList<int[]> moveArray = new ArrayList<>();
		moveArray.add(new int[] {x,y});
		int sum = matrix[x][y];
		
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int curX = cur[0];
			int curY = cur[1];
			
			for(int i = 0; i<dx.length; i++) {
				int newX = curX + dx[i];
				int newY = curY + dy[i];
				
				if(!isGo(newX, newY) || isVisit[newX][newY]) {
					continue;
				}
				
				int diff = Math.abs(matrix[newX][newY] - matrix[curX][curY]);
				
				if(l <= diff && diff <= r) {
					flag = true;
					isVisit[newX][newY] = true;
					moveArray.add(new int[] {newX,newY});
					queue.add(new int[] {newX, newY});
					
					sum += matrix[newX][newY];
				}
			}
		}
		
		int size = moveArray.size();
		int value = sum / size;
		if(size != 1) {
			for(int[] temp : moveArray) {
				matrix[temp[0]][temp[1]] = value;
			}
		}
	}
	
	
	
	private static boolean isGo(int x, int y) {
		if( 0<= x && x < n && 0<= y && y < n) {
			return true;
		}
		return false;
	}

}
