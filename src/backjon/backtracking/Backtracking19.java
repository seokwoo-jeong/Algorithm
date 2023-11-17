package backjon.backtracking;

import java.io.*;

// https://www.acmicpc.net/problem/1248
// Guess

// 경우의수 전부 구하고 조건 만족하는지 확인하면 시간초과 뜸
// 경우의수 하나 뽑을 때마다 조건 확인해야 함
public class Backtracking19 {
	static char[][] matrix;
	static int[] result;
	static int n;
	static int[] num = { -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new char[n][n];
		char[] operation = br.readLine().toCharArray();
		result = new int[n];

		int x = 0;
		int y = 0;
		for (int i = 0; i < operation.length; i++) {
			if (y == n) {
				x++;
				y = x;
			}
			matrix[x][y] = operation[i];
			y++;
		}
		dfs(0);

	}

	private static void dfs(int depth) {
		if (depth == n) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.exit(0);
		}

		for (int i = 0; i < num.length; i++) {
			result[depth] = num[i];

			if (isPossible(depth)) {
				dfs(depth + 1);
			}
		}

	}

	private static boolean isPossible(int depth) {
		boolean flag = true;
		int sum = 0;

		for (int i = 0; i <= depth; i++) {
			sum = 0;
			for (int j = i; j <= depth; j++) {
				sum += result[j];

				flag = find(sum, i, j);
				if (!flag) {
					break;
				}
			}
			if (!flag) {
				break;
			}

		}

		return flag;

	}

	private static boolean find(int sum, int x, int y) {
		boolean flag = true;
		if (matrix[x][y] == '+') {
			if (sum <= 0) {
				flag = false;
			}
		} else if (matrix[x][y] == '-') {
			if (sum >= 0) {
				flag = false;
			}
		} else if (matrix[x][y] == '0') {
			if (sum != 0) {
				flag = false;
			}
		}

		return flag;
	}

}
