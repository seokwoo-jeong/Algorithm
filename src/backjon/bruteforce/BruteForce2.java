package backjon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/3085
//  사탕게임

public class BruteForce2 {
	public static char[][] map;
	public static int n;
	public static int[][] direction = { { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		char[] charArray = new char[n];
		map = new char[n][n];

		for (int i = 0; i < n; i++) {
			charArray = in.readLine().toCharArray();
			for (int z = 0; z < charArray.length; z++) {
				map[i][z] = charArray[z];
			}
		}

		System.out.println(solution());
	}

	public static int solution() {
		int dx = 0;
		int dy = 0;
		int count = 0;
		int max = 0;
		boolean flag = false;
		for (int x = 0; x < n; x++) {
			if (flag) {
				break;
			}
			for (int y = 0; y < n; y++) {
				if (flag) {
					break;
				}
				for (int i = 0; i < direction.length; i++) {
					dx = x + direction[i][0];
					dy = y + direction[i][1];

					if ((0 <= dx && dx < n) && (0 <= dy && dy < n)) {
						swap(x, y, dx, dy);

						count = count();
						swap(x, y, dx, dy);
					}
					if (max < count) {
						max = count;
					}

					if (max == n) {
						flag = true;
						break;
					}

				}
			}
		}
		return max;
	}

	public static void swap(int x, int y, int dx, int dy) {
		if (map[x][y] != map[dx][dy]) {
			char temp = map[dx][dy];

			map[dx][dy] = map[x][y];
			map[x][y] = temp;
		}
	}

	public static int count() {
		int count = 0;
		int max = 0;
		for (int x = 0; x < n; x++) { // 媛�濡쒕갑�뼢
			count = 1;
			for (int y = 0; y < n - 1; y++) {
				if (map[x][y] == map[x][y + 1]) {
					count++;
				} else {
					count = 1;
				}
				if (max < count) {
					max = count;
				}
			}
		}

		for (int y = 0; y < n; y++) { // �꽭濡쒕갑�뼢
			count = 1;
			for (int x = 0; x < n - 1; x++) {
				if (map[x][y] == map[x + 1][y]) {
					count++;
				} else {
					count = 1;
				}
				if (max < count) {
					max = count;
				}
			}
		}
		return max;
	}
}
