package codingtest.ssg202205;

import java.util.*;

public class Ssg4_re {

	private int[][] matrix;
	private int size;
	private ArrayList<int[]> bombList;
	public String[] solution(int[][] macaron) {
		size = 6;
		matrix = new int[size][size];
		
		int y = 0;
		int color = 0;
		for(int i = 0; i<macaron.length; i++) {
			y = macaron[i][0] - 1;
			color = macaron[i][1];
			
			setMacaron(y, color);
			
			while(true) {
				if(!isBomb()) {
					break;
				}
				bombMacaron();
			}
		}
		
		String[] result = new String[size];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<size; i++) {
			for(int z= 0; z<size; z++) {
				sb.append(matrix[i][z]);
			}
			result[i] = sb.toString();
			sb.delete(0, 6);
		}
		for(String a : result) {
			System.out.println(a);
		}
		
		return result;
	}
	private void bombMacaron() {
		for(int[] bomb : bombList) {
			matrix[bomb[0]][bomb[1]] = 0;
		}
		
		int x = 0;
		int y = 0;
		for(int[] bomb : bombList) {
			x = bomb[0];
			y = bomb[1];
			for(int i = x; i>=1; i--) {
				matrix[i][y] = matrix[i-1][y];
			}
		}
	}
	
	
	private boolean isBomb() {
		bombList = new ArrayList<>();
		boolean[][] isVisit = new boolean[size][size];
		for(int i = 0; i<size; i++) {
			for(int z = 0; z<size; z++) {
				if(!isVisit[i][z] && matrix[i][z] != 0) {
					ArrayList<int[]> temp = bfs(i,z,isVisit);
					
					if(temp.size() >= 3) {
						for(int[] bomb : temp) {
							bombList.add(bomb);
						}
					}
				}
			}
		}
		if(bombList.size() >= 3) {
			return true;
		}
		
		return false;
	}
	
	private ArrayList<int[]> bfs(int x, int y, boolean[][] isVisit) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		ArrayList<int[]> temp = new ArrayList<>();
		isVisit[x][y] = true;
		temp.add(new int[] {x,y});
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		int[] cur = null;
		int curX = 0;
		int curY = 0;
		int nextX = 0;
		int nextY = 0;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			curX = cur[0];
			curY = cur[1];
			
			for(int i = 0; i<dx.length; i++) {
				nextX = curX + dx[i];
				nextY = curY + dy[i];
				
				if(isOut(nextX, nextY) || isVisit[nextX][nextY]) {
					continue;
				}
				
				if(matrix[curX][curY] == matrix[nextX][nextY]) {
					isVisit[nextX][nextY] = true;
					temp.add(new int[] {nextX, nextY});
					queue.add(new int[] {nextX, nextY});
				}
			}
		}
		
		return temp;
	}
	
	private boolean isOut(int x, int y) {
		if(0<=x && x < size && 0<= y && y<size) {
			return false;
		}
		return true;
	}
	
	
	private void setMacaron(int y, int color) {
		for(int i = size-1; i>=0; i--) {
			if(matrix[i][y] == 0) {
				matrix[i][y] = color;
				break;
			}
		}
	}
	
	private void print() {
		for(int i = 0; i<size; i++) {
			for(int z = 0; z<size; z++) {
				System.out.print(matrix[i][z] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}
	
}
