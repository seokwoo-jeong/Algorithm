package backjon.implement2;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/17144
// 미세먼지 안녕!
public class Implement3 {
	private static int n;
	private static int m;
	private static int[][] matrix;
	private static ArrayList<Info> cleaner;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		int t = Integer.parseInt(temp[2]);

		matrix = new int[n][m];
		cleaner = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
				if (matrix[i][j] == -1) {
					cleaner.add(new Info(i, j));
				}
			}
		}

		for (int i = 0; i < t; i++) {
			spreadDust();
			startCleaner();
		}

		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == -1) {
					continue;
				}
				result += matrix[i][j];
			}
		}
		System.out.println(result);
	}

	private static void startCleaner() {
		turnReaverse(cleaner.get(0));
		turnClock(cleaner.get(1));

	}

	private static void turnClock(Info info) {
		int x = info.x;

		// 왼쪽
		for (int i = x + 1; i < n - 1; i++) {
			matrix[i][0] = matrix[i + 1][0];
		}

		// 아래
		for (int i = 0; i < m - 1; i++) {
			matrix[n - 1][i] = matrix[n - 1][i + 1];
		}

		// 오른쪽
		for (int i = n - 1; i > x; i--) {
			matrix[i][m - 1] = matrix[i - 1][m - 1];
		}

		// 위쪽
		for (int i = m - 1; i > 1; i--) {
			matrix[x][i] = matrix[x][i - 1];
		}
		matrix[x][1] = 0;
	}

	private static void turnReaverse(Info info) {
		int x = info.x;

		// 아래로(왼쪽)
		for (int i = x - 1; i > 0; i--) {
			matrix[i][0] = matrix[i - 1][0];
		}

		// 왼쪽으로(위)
		for (int i = 0; i < m - 1; i++) {
			matrix[0][i] = matrix[0][i + 1];
		}
		// 위로(오른쪽)
		for (int i = 0; i < x; i++) {
			matrix[i][m - 1] = matrix[i + 1][m - 1];
		}

		// 오른쪽(아래)
		for (int i = m - 1; i > 1; i--) {
			matrix[x][i] = matrix[x][i - 1];
		}
		matrix[x][1] = 0;
	}

	private static void spreadDust() {
		int[][] temp = new int[n][m]; // 임시 저장용
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int i = 0; i < n; i++) {
			int count = 0;
			int dust = 0;
			for (int j = 0; j < m; j++) {
				count = 0;
				dust = matrix[i][j];
				if (dust == 0 || dust == -1) {
					continue;
				}
				for (int k = 0; k < dx.length; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (!isGo(nx, ny) || matrix[nx][ny] == -1) {
						continue;
					}
					count++;
					temp[nx][ny] += dust / 5;
				}
				temp[i][j] += matrix[i][j] - (dust / 5) * count;
			}

		}
		matrix = temp;

		for (Info info : cleaner) { // 청소기 set
			matrix[info.x][info.y] = -1;
		}
	}

	private static boolean isGo(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < m) {
			return true;
		}
		return false;
	}

	private static class Info {
		int x;
		int y;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
