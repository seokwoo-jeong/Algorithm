package backjon2.bfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2206
// 벽 부수고 이동하기 (골3)

public class BFS09 {

	private static char[][] matrix;
	private static int[][] countMatrix;
	private static boolean[][][] isVisit;
	private static int n;
	private static int m;
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

		bfs(0, 0);
		if (countMatrix[n - 1][m - 1] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(countMatrix[n - 1][m - 1]);

		}
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		isVisit[x][y][0] = true;
		countMatrix[x][y] = 1;
		queue.add(new int[] { x, y, 0 }); // 0이면 한번도 안부신거 1이면 한번 부신거

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
				if (matrix[nx][ny] == '1') { // 벽인 경우
					if (curState == 0) {	//부신적 없는 경우
						isVisit[nx][ny][1] = true;
						queue.add(new int[] { nx, ny, 1 });
						countMatrix[nx][ny] = countMatrix[curX][curY] + 1;
					}
				} else { // 벽 아닌 경우
					if (curState == 0 && !isVisit[nx][ny][0]) {
						//한번도 부신적 없고, 부시지 않은채로 한번도 방문하지 않은 경우
						isVisit[nx][ny][0] = true;
						queue.add(new int[] {nx,ny,0});
						countMatrix[nx][ny] = countMatrix[curX][curY] + 1;
					}else if(curState == 1 && !isVisit[nx][ny][1]) {
						//이미 부셨고, 부신 상태로 한번도 방문하지 않은 경우
						isVisit[nx][ny][1] = true;
						queue.add(new int[] {nx,ny,1});
						countMatrix[nx][ny] = countMatrix[curX][curY] + 1;
					}
				}

				if (nx == n - 1 && ny == m - 1) {
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
