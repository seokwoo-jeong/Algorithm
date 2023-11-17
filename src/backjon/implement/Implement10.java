package backjon.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/16931
//겉넓이 구하기

public class Implement10 {
	static int[][] matrix;
	static int n;
	static int m;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def = br.readLine().split(" ");
		n = Integer.parseInt(def[0]); // 세로
		m = Integer.parseInt(def[1]); // 가로
		matrix = new int[n][m];
		String[] def2 = new String[m];
		for (int i = 0; i < n; i++) {
			def2 = br.readLine().split(" ");
			for (int j = 0; j < def2.length; j++) {
				matrix[i][j] = Integer.parseInt(def2[j]);
			}
		}
		result = (m * n) * 2; // 빈 칸 존재 x(1부터시작하므로) - 윗변,아랫변
		getWidthLeft();		//왼쪽변
		getWidthRight();	//오른쪽변
		getHeightLeft();	//안쪽변
		getHeightRight();	//바깥쪽변
		System.out.println(result);
	}

	private static void getHeightLeft() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					result += matrix[j][i];
				} else {
					if (matrix[j][i] > matrix[j-1][i]) {
						result += matrix[j][i] - matrix[j-1][i];
					}
				}
			}
		}

	}

	private static void getHeightRight() {
		for (int i = 0; i < m; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (j == n - 1) {
					result += matrix[j][i];
				} else {
					if (matrix[j][i] > matrix[j+1][i]) {
						result += matrix[j][i] - matrix[j+1][i];
					}
				}
			}
		}

	}

	private static void getWidthRight() {
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				if (j == m - 1) {
					result += matrix[i][j];
				} else {
					if (matrix[i][j] > matrix[i][j + 1]) {
						result += matrix[i][j] - matrix[i][j + 1];
					}
				}
			}
		}

	}

	private static void getWidthLeft() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j == 0) {
					result += matrix[i][j];
				} else {
					if (matrix[i][j] > matrix[i][j - 1]) {
						result += matrix[i][j] - matrix[i][j - 1];
					}
				}
			}
		}

	}

}
