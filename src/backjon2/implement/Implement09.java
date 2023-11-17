package backjon2.implement;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2636
// 치즈 (골4)
public class Implement09 {
	private static int[][] matrix;
	private static boolean[][] isVisit;
	private static int n;
	private static int m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);

		matrix = new int[n][m];
		isVisit = new boolean[n][m];
		
		// matrix set
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			
			for(int z = 0; z<m; z++) {
				matrix[i][z] = Integer.parseInt(temp[z]);
			}
		}
		// matrix set end
		
		int beforeCount = 0;
		int curCount = 0;
		int time = 0;
		while(true) {
			isVisit = new boolean[n][m];
			curCount = bfs(0,0);
			
			if(curCount !=0) {
				beforeCount = curCount;
			}else {
				break;
			}
			time++;
			curCount = 0;
		}
		System.out.println(time);
		System.out.println(beforeCount);
		
	}
	private static int bfs(int x, int y) {
		int count = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		isVisit[x][y] = true;
		ArrayList<int[]> deleteArray = new ArrayList<>();
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int curX = cur[0];
			int curY = cur[1];
			
			for(int i = 0; i<dx.length; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				
				if(isOut(nextX,nextY) || isVisit[nextX][nextY]) {
					continue;
				}
				
				isVisit[nextX][nextY] = true;
				if(matrix[nextX][nextY] == 0) {
					queue.add(new int[] {nextX,nextY});
				}else if(matrix[nextX][nextY] == 1) {
					count++;
					deleteArray.add(new int[] {nextX,nextY});
				}
			}
		}
		for(int[] delete : deleteArray) {
			matrix[delete[0]][delete[1]] = 0;
		}
		
		return count;
	}
	private static boolean isOut(int x, int y) {
		if(0<= x && x < n && 0<= y && y < m) {
			return false;
		}
		return true;
	}
	

}
