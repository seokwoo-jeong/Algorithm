package backjon.implement2;

import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/16234
// 인구 이동
public class Implement1 {
	private static boolean[][] isVisit;
	private static int[][] matrix;
	private static int n;
	private static int l;
	private static int r;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };
	private static boolean open;
	private static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		l = Integer.parseInt(temp[1]);
		r = Integer.parseInt(temp[2]);
		isVisit = new boolean[n][n];
		matrix = new int[n][n];
		open = false;
		for (int i = 0; i < n; i++) { // matrix 초기값 세팅
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < line.length; j++) {
				matrix[i][j] = Integer.parseInt(line[j]);
			}
		}
		result = 0;
		while (true) {
			open = false;
			isVisit = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!isVisit[i][j]) {
						open = bfs(i, j);
					}
				}
			}
			if (open) {
				result++;
				/*
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						System.out.print(matrix[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println();
				*/
			} else {
				break;
			}
		}
		System.out.println(result);
	}

	private static boolean bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, matrix[x][y] });
		int sum = matrix[x][y];
		ArrayList<int[]> array = new ArrayList<>();
		array.add(new int[] { x, y });
		isVisit[x][y] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			int curCount = cur[2];

			for (int i = 0; i < dx.length; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (!isGo(nx, ny)) {
					continue;
				}
				if (isVisit[nx][ny]) {
					continue;
				}
				
				if (l <= Math.abs(matrix[nx][ny] - curCount) && Math.abs(matrix[nx][ny] - curCount) <= r) {
					array.add(new int[] { nx, ny });
					sum += matrix[nx][ny];
					queue.add(new int[] { nx, ny, matrix[nx][ny] });
					isVisit[nx][ny] = true;
				}
				
			}
		}
		if (array.size() != 1) {
			updateMatrix(sum, array);
			open = true;
		}

		return open;
	}

	private static void updateMatrix(int sum, ArrayList<int[]> array) {
		int value = sum / array.size();
		for (int i = 0; i < array.size(); i++) {
			matrix[array.get(i)[0]][array.get(i)[1]] = value;
		}
	}

	private static boolean isGo(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < n) {
			return true;
		}
		return false;
	}

}
