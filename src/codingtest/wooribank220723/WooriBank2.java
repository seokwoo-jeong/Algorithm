package codingtest.wooribank220723;

import java.util.*;

/* 예시1)
 * . . . . . . # # # # 
 * . . . # . . . # # # 
 * . . # . # # . . # # 
 * . . # . . . # . . # 
 * . . . # . # . . . . 
 * . . . . # . . . . .
 * 공간이 모두 막혀있는 경우 내부 '.'까지 갯수 더하기
 * answer: '#' : 19개 / '.' : 5개
 * = 24개  
 * 
 * 예시2)
 * . . . # . . . . . . 
 * . . # . # # . . . . 
 * . . # . . . # . . . 
 * . . . # . # . . . . 
 * 공간이 뚤려 있는 경우 내부 '.'은 더하지 못한다.
 * answer: '#' : 8개 / '.' : 0개
 * = 8개 
 */

public class WooriBank2 {
	char[][] matrix;
	int m;
	int n;
	boolean[][] isVisit;
	int[][] isConnect;
	int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	int answer = 0;

	public int solution(String[] grid) {
		matrix = setMatrix(grid);
		m = matrix.length;
		n = matrix[0].length;
		isVisit = new boolean[m][n];
		isConnect = new int[m][n];
		// 출력
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		//
		getAnswer();
		System.out.println(answer);
		return answer;
	}

	private void getAnswer() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!isVisit[i][j] && matrix[i][j] == '#') {
					bfs(i, j);
					if (isConnect()) {
						answer += getSpot();
					}
					isVisit = new boolean[m][n];
					isConnect = new int[m][n];
				}
			}
		}
	}

	private boolean isConnect() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(isConnect[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	private int getSpot() {
		boolean flag = false;
		int spot = 0;
		int tempCount = 0;
		for (int i = 0; i < m; i++) {
			flag = false;
			tempCount = 0;
			for (int j = 0; j < n; j++) {
				if (isVisit[i][j] && !flag) {
					flag = true;
				} else if (!isVisit[i][j] && flag) {
					tempCount++;
				} else if (flag && isVisit[i][j]) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				spot += tempCount;
			}

		}
		return spot;

	}

	private void bfs(int sx, int sy) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { sx, sy });
		isVisit[sx][sy] = true;
		matrix[sx][sy] = '.';
		answer++;
		while (!queue.isEmpty()) {
			int[] xy = queue.poll();
			int cx = xy[0];
			int cy = xy[1];
			for (int i = 0; i < dx.length; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (!isGo(nx, ny)) {
					continue;
				}
				if (isVisit[nx][ny]) {
					isConnect[nx][ny]++;
					continue;
				}
				if (matrix[nx][ny] == '#') {
					isVisit[nx][ny] = true;
					matrix[nx][ny] = '.';
					queue.add(new int[] { nx, ny });
					answer++;
					isConnect[nx][ny]++;
				}

			}
		}

	}

	private boolean isGo(int x, int y) {
		if (0 <= x && x < m && 0 <= y && y < n) {
			return true;
		}
		return false;
	}

	private char[][] setMatrix(String[] grid) {
		char[][] temp = new char[grid.length][grid[0].length()];
		for (int i = 0; i < grid.length; i++) {
			temp[i] = grid[i].toCharArray();
		}
		return temp;
	}

}
