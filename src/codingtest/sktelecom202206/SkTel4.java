package codingtest.sktelecom202206;

import java.util.*;

public class SkTel4 {
	int[] dx = { 1, 0, -1, 0 };
	int[] dy = { 0, 1, 0, -1 };
	char[][] matrix;
	boolean[][][] isVisit;
	int n;
	int m;
	int max = 50 * 50; // matrix최대 칸 개수까지 야경 가능
	
	// 평지 도착할 때마다 야경 하고, 안하고
	public int solution(String[] grid, int k) {
		n = grid.length;
		m = grid[0].toCharArray().length;
		matrix = new char[n][m];
		isVisit = new boolean[n][m][max];
		setMatrix(grid);

		bfs(0, 0, k, 0);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < isVisit[n - 1][m - 1].length; i++) {
			if (isVisit[n - 1][m - 1][i]) {
				min = Math.min(min, i);
			}
		}

		int answer = min;
		return answer;
	}

	public void bfs(int a, int b, int k, int t) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { a, b, k, t });

		while (!queue.isEmpty()) {
			int[] def = queue.poll();
			int beforeX = def[0];
			int beforeY = def[1];
			int move = def[2];
			int tent = def[3];
			for (int i = 0; i < dx.length; i++) {
				int nx = beforeX + dx[i];
				int ny = beforeY + dy[i];

				if (isGo(nx, ny)) {
					if (move > 0) {
						if (!isVisit[nx][ny][tent]) {
							if (matrix[nx][ny] == 'F') {
								continue;
							}
							queue.add(new int[] { nx, ny, move - 1, tent }); // 수경 안하는경우
							isVisit[nx][ny][tent] = true;
							if (matrix[nx][ny] == '.') {
								if (tent < max - 1) {
									queue.add(new int[] { nx, ny, k, tent + 1 }); // 수경 하는경우
									isVisit[nx][ny][tent + 1] = true;
								}

							}
						}

					}
				}
			}
		}
	}

	public boolean isGo(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < m) {
			return true;
		}
		return false;
	}

	public void setMatrix(String[] grid) {
		for (int i = 0; i < n; i++) {
			matrix[i] = grid[i].toCharArray();
		}
	}
}