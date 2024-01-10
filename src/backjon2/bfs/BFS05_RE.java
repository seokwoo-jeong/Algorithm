package backjon2.bfs;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1261
// 알고스팟 (골4)
public class BFS05_RE {

	private static int n;
	private static int m;
	private static int[][] matrix;
	private static int[][] breakMatrix;
	private static boolean[][] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		n = Integer.parseInt(temp[1]);
		m = Integer.parseInt(temp[0]);
		matrix = new int[n][m];
		breakMatrix = new int[n][m];
		isVisit = new boolean[n][m];

		char[] temp2 = null;
		for (int i = 0; i < n; i++) {
			temp2 = br.readLine().toCharArray();
			for (int z = 0; z < m; z++) {
				matrix[i][z] = Character.digit(temp2[z], 10);
			}
		}

		bfs(0, 0);
		System.out.println(breakMatrix[n - 1][m - 1]);
	}

	private static void bfs(int x, int y) {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		isVisit[0][0] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			int curX = cur[0];
			int curY = cur[1];

			int nx = 0;
			int ny = 0;
			for (int i = 0; i < dx.length; i++) {
				nx = curX + dx[i];
				ny = curY + dy[i];

				if (isOut(nx, ny)) {
					continue;
				}
				
				if (isVisit[nx][ny] && breakMatrix[nx][ny] <= setValue(matrix[nx][ny], breakMatrix[curX][curY])) {
					continue;
				}
						
				isVisit[nx][ny] = true;
				breakMatrix[nx][ny] = setValue(matrix[nx][ny], breakMatrix[curX][curY]);
				queue.add(new int[] { nx, ny });
			}
		}
	}

	private static int setValue(int status, int beforeValue) {
		int curValue = beforeValue;
		if (status == 1) {
			curValue = beforeValue + 1;
		}
		return curValue;
	}

	private static boolean isOut(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < m) {
			return false;
		}
		return true;
	}
}
