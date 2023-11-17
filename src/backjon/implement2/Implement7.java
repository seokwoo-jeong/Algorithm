package backjon.implement2;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/17837
//새로운 게임2

public class Implement7 {
	private static int n; // 체스판 크기
	private static int k; // 말의 개수
	private static int[][] matrix;
	private static LinkedList<Integer>[][] horseMatrix;
	private static int[] direction = { 1, 0, 3, 2 };
	private static Horse[] horses;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		horses = new Horse[k];
		matrix = new int[n][n];
		horseMatrix = new LinkedList[n][n];

		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < temp.length; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
				horseMatrix[i][j] = new LinkedList<>();
			}
		}

		for (int i = 0; i < k; i++) {
			temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]) - 1;
			int y = Integer.parseInt(temp[1]) - 1;
			int dir = Integer.parseInt(temp[2]) - 1;
			Horse horse = new Horse(x, y, dir);
			horseMatrix[x][y].add(i);
			horses[i] = horse;
		}
		int count = 0;
		boolean flag = false;
		while (true) {
			count++;
			//System.out.println("------------------------");
			for (int i = 0; i < horses.length; i++) {
				Horse cur = horses[i];
				int dir = cur.dir;
				int cx = cur.x;
				int cy = cur.y;
				int nx = cx + dx[dir];
				int ny = cy + dy[dir];
				
				if (!isGo(nx, ny) || matrix[nx][ny] == 2) { // 나간 경우 or 파란색 만난경우
					dir = direction[dir];

					nx = cx + dx[dir];
					ny = cy + dy[dir];
					horses[i].dir = dir;
				}

				int size = horseMatrix[cx][cy].size();
				
				if (!isGo(nx, ny) || matrix[nx][ny] == 2) {	//파란색 만난경우 
					continue;
				} else if (matrix[nx][ny] == 0) { // 흰색 만난 경우
					int loc = 0;
					for (int z = 0; z < size; z++) {
						if(horseMatrix[cx][cy].get(z) == i) {
							loc = z;
							break;
						}
					}
					for(int z= loc; z<size; z++) {
						int curHorse = horseMatrix[cx][cy].get(z);
						horses[curHorse].x = nx;
						horses[curHorse].y = ny;
						horseMatrix[nx][ny].add(curHorse);
					}
					
					for(int z= size-1; z>=loc; z--) {
						horseMatrix[cx][cy].remove(z);
					}

				} else if (matrix[nx][ny] == 1) { // 빨간색 만난 경우
					int loc = 0;
					
					for(int z = 0; z<size; z++) {
						if(horseMatrix[cx][cy].get(z) == i) {
							loc = z;
							break;
						}
					}
					for(int z= size -1; z>=loc; z--) {
						int curHorse = horseMatrix[cx][cy].get(z);
						horses[curHorse].x = nx;
						horses[curHorse].y = ny;
						horseMatrix[nx][ny].add(curHorse);
					}
					
					for(int z= size -1; z>=loc; z--) {
						horseMatrix[cx][cy].remove(z);
					}
					
				}
				/*
				System.out.println("전: " + cx + " " + cy +" " +  dir);
				System.out.println("현: " + nx + " " + ny +" " +  dir);
				for(int z = 0; z<horseMatrix[nx][ny].size(); z++) {
					System.out.print(horseMatrix[nx][ny].get(z) + " ");
				}
				System.out.println();
				*/
				if (horseMatrix[nx][ny].size() >= 4) {
					flag = true;
					break;
				}
				
			}
			
			if (flag || count >= 1000) {
				break;
			}
			
		}
		if (count >= 1000) {
			System.out.println(-1);
		} else {
			System.out.println(count);
		}

	}

	private static boolean isGo(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < n) {
			return true;
		}
		return false;
	}

	private static class Horse {
		int x;
		int y;
		int dir;

		public Horse(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

}
