package backjon.bfs2;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2206
// 벽 부수고 이동하기

public class BFS5 {
	static int[][] matrix;
	static int[][] countMatrix;
	static boolean[][][] isVisit;
	static int n;
	static int m;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def = br.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		m = Integer.parseInt(def[1]);
		matrix = new int[n][m];
		countMatrix = new int[n][m];
		isVisit = new boolean[n][m][2];
		for (int i = 0; i < n; i++) {
			char[] def2 = br.readLine().toCharArray();
			for (int j = 0; j < def2.length; j++) {
				matrix[i][j] = def2[j] - '0';
			}
		}
		
		if (n - 1 == 0 && m - 1 == 0) {
			System.out.print(1);
			System.exit(0);
		}
		
		bfs(0, 0, 0);
		if (countMatrix[n - 1][m - 1] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(countMatrix[n - 1][m - 1] + 1);
		}

	}

	private static void bfs(int initX, int initY, int broke) {// broke : 0-안부심 1-부심
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { initX, initY, broke });
		boolean flag = false;
		while (!queue.isEmpty()) {
			int[] xy = queue.poll();
			int x = xy[0];
			int y = xy[1];
			int isBreak = xy[2];

			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (isGo(nx, ny)) {
					if (matrix[nx][ny] == 0) { // 벽이 아닌경우
						if (!isVisit[nx][ny][isBreak]) {// 방문하지 않은경우
							isVisit[nx][ny][isBreak] = true;
							countMatrix[nx][ny] = countMatrix[x][y] + 1;
							queue.add(new int[] { nx, ny, isBreak });
						}

					} else { // 벽인경우
						if (isBreak == 0 && !isVisit[nx][ny][isBreak]) {// 벽 부순적 없고 방문하지 않은 경우
							isVisit[nx][ny][isBreak] = true;
							countMatrix[nx][ny] = countMatrix[x][y] + 1;
							queue.add(new int[] { nx, ny, 1 });
						}
					}
				}

				if (nx == n - 1 && ny == m - 1) {
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
	}

	private static boolean isGo(int nx, int ny) {
		if (0 <= nx && nx < n && 0 <= ny && ny < m) {
			return true;
		}
		return false;
	}

}
