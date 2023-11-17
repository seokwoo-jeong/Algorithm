package backjon.bfs2;

import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/10026
// 적록색약

public class BFS13 {
	static boolean[][] isVisit;
	static char[][] matrix;
	static int n;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new char[n][n];
		isVisit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		int[] answer = new int[2];
		int count = 0;
		for (int k = 0; k < answer.length; k++) { // 0:적록색약 아닌 사람 1: 적록색약인 사람
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!isVisit[i][j]) {
						bfs(i, j, k);
						count++;
					}
				}
			}
			answer[k] = count;
			isVisit = new boolean[n][n];
			count = 0;
		}
		System.out.print(answer[0] + " " + answer[1]);

	}

	private static void bfs(int startX, int startY, int distinct) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { startX, startY });
		isVisit[startX][startY] = true;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curx = cur[0];
			int cury = cur[1];
			for (int i = 0; i < dx.length; i++) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];

				if (!isGo(nx, ny)) {
					continue;
				}
				if (isVisit[nx][ny]) {
					continue;
				}

				if (matrix[curx][cury] == matrix[nx][ny]) {
					queue.add(new int[] { nx, ny });
					isVisit[nx][ny] = true;
					continue;
				}
				if (distinct == 1) {// 적록색약인 사람 R == G
					if(matrix[curx][cury] == 'R' && matrix[nx][ny] == 'G') {
						queue.add(new int[] { nx, ny });
						isVisit[nx][ny] = true;						
					}else if(matrix[curx][cury] == 'G' && matrix[nx][ny] == 'R') {
						queue.add(new int[] { nx, ny });
						isVisit[nx][ny] = true;							
					}
				}

			}

		}
	}

	private static boolean isGo(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < n) {
			return true;
		}
		return false;
	}

}
