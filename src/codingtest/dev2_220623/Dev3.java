package codingtest.dev2_220623;

import java.util.*;

public class Dev3 {
	private int[][] matrix;
	private int[] dx = { 1, 0, -1, 0 };
	private int[] dy = { 0, 1, 0, -1 };
	private boolean[][] isVisit;
	private int row;
	private int col;
	private int count;

	public int[] solution(int rows, int columns, int[][] lands) {
		row = rows;
		col = columns;
		matrix = new int[rows][columns];
		isVisit = new boolean[rows][columns];
		for (int i = 0; i < lands.length; i++) {
			matrix[lands[i][0] - 1][lands[i][1] - 1] = 1;
		}
		int[] answer = {-1,-1};
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				if (matrix[i][j] == 0 && !isVisit[i][j]) {
					count = 0;
					if (bfs(i, j)) { // 바다가 아니면
						if(count == 0) {
							count = 1;
						}
						ans.add(count);
					}
				}
			}
		}
		if(ans.size() >= 2) {
			Collections.sort(ans);
			answer[0] = ans.get(0);
			answer[1] = ans.get(ans.size()-1);
		}else if (ans.size() == 1) {
			answer[0] = ans.get(0);
		}
		
		return answer;
	}

	private boolean bfs(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { startX, startY});
		while (!queue.isEmpty()) {
			int[] def = queue.poll();
			int x = def[0];
			int y = def[1];
			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (!isGo(nx, ny)) { // 섬 밖으로 나가는지 chk
					continue;
				}
				if (isLand(nx, ny)) { // 땅인지 chk
					continue;
				}
				if (isSea(nx, ny)) { // 바다랑 이어져 있는지 chk
					return false;
				}
				if (!isVisit[nx][ny]) { // 방문한적 없는지 chk
					count++;
					queue.add(new int[] { nx, ny});
					isVisit[nx][ny] = true;
				}

			}
		}
		return true;
	}

	private boolean isSea(int nx, int ny) {
		if (nx == 0 || ny == 0) {
			return true;
		}
		return false;
	}

	private boolean isLand(int x, int y) {
		if (matrix[x][y] == 1) {
			return true;
		}
		return false;
	}

	private boolean isGo(int x, int y) {
		if (0 <= x && x < row && 0 <= y && y < col) {
			return true;
		}
		return false;
	}
}