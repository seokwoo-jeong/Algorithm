package backjon2.bfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2206
// 벽 부수고 이동하기 (골3)

public class BFS09_RE {

	private static int n;
	private static int m;
	private static char[][] matrix;
	private static int[][] countMatrix;
	private static boolean[][][] isVisit;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);

		matrix = new char[n][m];
		countMatrix = new int[n][m];
		isVisit = new boolean[n][m][2];

		for (int i = 0; i < n; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		bfs();
		if(countMatrix[n-1][m-1] == 0) {
			countMatrix[n-1][m-1] = -1;
		}
		System.out.println(countMatrix[n-1][m-1]);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 0 });
		isVisit[0][0][0] = true;
		countMatrix[0][0] = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			int curX = cur[0];
			int curY = cur[1];
			int curState = cur[2];

			for (int i = 0; i < dx.length; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (isOut(nx, ny)) {
					continue;
				}

				if (matrix[nx][ny] == '0') { // 벽이 아닐 때
					if(!isVisit[nx][ny][curState]) {
						isVisit[nx][ny][curState] = true;
						countMatrix[nx][ny] = countMatrix[curX][curY] + 1;
						queue.add(new int[] { nx, ny, curState });						
					}
				} else { // 벽을 만났을 때
					if(curState == 0) {
						isVisit[nx][ny][1] = true;
						countMatrix[nx][ny] = countMatrix[curX][curY] + 1;
						queue.add(new int[] {nx,ny, 1});
					}

				}
				
				if(nx == n-1 && ny == m-1) {
					return;
				}
			}
		}
	}

	private static boolean isOut(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < m) {
			return false;
		}
		return true;
	}
}
