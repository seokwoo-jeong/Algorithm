package backjon2.implement;

import java.io.*;
import java.util.*;


// https://www.acmicpc.net/problem/14503
// 로봇 청소기 (골5)

public class Implement02 {
	
	private static int[][] matrix;
	private static int[] dx = {-1,0,1,0};
	private static int[] dy = {0,1,0,-1};
	private static int n;
	private static int m;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]); // 세로
		m = Integer.parseInt(temp[1]); // 가로
		
		temp = br.readLine().split(" ");
		
		int x = Integer.parseInt(temp[0]);
		int y = Integer.parseInt(temp[1]);
		int d = Integer.parseInt(temp[2]);	// 0 북, 1 동, 2 남, 3 서
		
		matrix = new int[n][m];
		
		for(int i =0; i<n; i++) {
			temp = br.readLine().split(" ");
			
			for(int z = 0; z<m; z++) {
				matrix[i][z] = Integer.parseInt(temp[z]);
			}
		}
		
		int result = bfs(x,y,d);	
		
		System.out.println(result);
	}
	
	private static int bfs(int x, int y, int d) {
		Queue<int[]> queue = new LinkedList<>();
		int count = 0;
		queue.add(new int[] {x,y,d});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int curX = cur[0];
			int curY = cur[1];
			int curD = cur[2];
			//System.out.println(curX + " " + curY);
			if(matrix[curX][curY] == 0) {	// 청소되지 않은 경우
				count++;
				matrix[curX][curY] = -1;
			}
			
			boolean flag = false;	// 주변 3칸 중 청소되지 않은 곳 있는지 확인
			int newX = 0;
			int newY = 0;
			for(int i = 0; i<dx.length; i++) {
				newX = curX + dx[i];
				newY = curY + dy[i];
				
				if(isOut(newX,newY)) {
					continue;
				}
				
				if(matrix[newX][newY] == 0) {	//청소되지 않은 칸 있니
					flag = true;
					break;
				}
			}
			
			int newD = 0;
			if(flag) {	//4칸중 청소되지 않은 빈칸이 있는 경우
				if(curD == 0) {
					newD = 3;
				}else {
					newD = curD -1;
				}
				newX = curX + dx[newD];
				newY = curY + dy[newD];
				
				if(isOut(newX,newY)) {
					continue;
				}
				if(matrix[newX][newY] == 0) {
					queue.add(new int[] {newX,newY,newD});
				}else {
					queue.add(new int[] {curX,curY,newD});	
				}
				
				
			}else {
				if(curD == 0 || curD == 1) {
					newD = curD + 2;
				}else {
					newD = curD - 2;
				}
				newX = curX + dx[newD];
				newY = curY + dy[newD];
				
				if(isOut(newX,newY) || matrix[newX][newY] == 1) {
					break;
				}
				queue.add(new int[] {newX,newY,curD});
			}

			
		}
		return count;
	}
	
	private static boolean isOut(int x,int y) {
		if(0<= x && x < n && 0<= y && y < m) {
			return false;
		}
		return true;
	}
}
