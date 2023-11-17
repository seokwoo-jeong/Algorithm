package backjon2.implement;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/17144
// 미세먼지 안녕! (골4)

public class Implement10 {
	private static int n;
	private static int m;
	private static ArrayList<int[]> cleaner;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		int t = Integer.parseInt(temp[2]);

		int[][] matrix = new int[n][m];
		cleaner = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int z = 0; z < m; z++) {
				matrix[i][z] = Integer.parseInt(temp[z]);
			}
		}

		for (int i = 0; i < t; i++) {
			matrix = moveDust(matrix);
			matrix = topClean(matrix);
			matrix = bottomClean(matrix);

		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int z = 0; z < m; z++) {
				if (matrix[i][z] != -1) {
					result += matrix[i][z];
				}
			}

		}
		System.out.println(result);

	}

	private static int[][] topClean(int[][] matrix) {
		int x = cleaner.get(0)[0];
		int y = cleaner.get(0)[1];
		// 위 -> 아래
		for (int i = x; i >= 1; i--) {
			matrix[i][0] = matrix[i - 1][0];
		}

		// 오 -> 왼
		for (int i = 0; i<m-1; i++) {
			matrix[0][i] = matrix[0][i+1]; 
		}
		
		
		// 아래 -> 위
		for(int i = 0; i<x; i++) {
			matrix[i][m-1] = matrix[i+1][m-1];
		}

		// 왼 -> 오
		for (int i = m - 1; i >= 1; i--) {
			matrix[x][i] = matrix[x][i - 1];
		}

		matrix[x][1] = 0;
		matrix[x][y] = -1;
		return matrix;
	}

	private static int[][] bottomClean(int[][] matrix) {
		int x = cleaner.get(1)[0];
		int y = cleaner.get(1)[1];
		// 아래 -> 위
		for (int i = x; i < n - 1; i++) {
			matrix[i][0] = matrix[i + 1][0];
		}
		
		// 오 -> 왼
		for(int i = 0; i<m-1;i++) {
			matrix[n-1][i] = matrix[n-1][i+1];
		}
		
		// 위 -> 아래
		for(int i = n-1; i>x; i--) {
			matrix[i][m-1] = matrix[i-1][m-1];
		}
		

		// 왼 -> 오
		for (int i = m - 1; i >= 1; i--) {
			matrix[x][i] = matrix[x][i - 1];
		}

		matrix[x][y] = -1;
		matrix[x][1] = 0;
		return matrix;
	}

	private static int[][] moveDust(int[][] matrix) {
		int[][] temp = new int[n][m];
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		int nextX = 0;
		int nextY = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int z = 0; z < m; z++) {
				count = 0;

				if (matrix[i][z] == -1) {
					temp[i][z] = -1;
					cleaner.add(new int[] { i, z });
					continue;
				}

				if (matrix[i][z] != 0) {
					for (int k = 0; k < dx.length; k++) {
						nextX = i + dx[k];
						nextY = z + dy[k];

						if (isOut(nextX, nextY)) {
							continue;
						}

						if (matrix[nextX][nextY] != -1) {
							temp[nextX][nextY] += matrix[i][z] / 5;
							count++;
						}
					}
					temp[i][z] += matrix[i][z] - (matrix[i][z] / 5) * count;
				}
			}
		}
		return temp;
	}

	private static boolean isOut(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < m) {
			return false;
		}
		return true;
	}

}
