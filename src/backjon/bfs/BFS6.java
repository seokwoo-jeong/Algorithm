package backjon.bfs;

import java.util.*;
import java.io.*;

public class BFS6 {
//https://www.acmicpc.net/problem/16197
//두 동전
	static boolean[][][][] isVisit; // 동전1x, 동전1y, 동전2x, 동전2y
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n;
	static int m;
	static char[][] matrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def = br.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		m = Integer.parseInt(def[1]);
		matrix = new char[n][m];
		isVisit = new boolean[n][m][n][m];

		boolean findOne = false;
		int x1 = 0;
		int x2 = 0;
		int y1 = 0;
		int y2 = 0;
		for (int i = 0; i < n; i++) {
			matrix[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 'o') {
					if (!findOne) {
						x1 = i;
						y1 = j;
						findOne = true;
					} else {
						x2 = i;
						y2 = j;
						break;
					}
				}
			}
		}
		Info info = new Info(x1, y1, x2, y2, 0);
		System.out.println(bfs(info));

	}

	private static int bfs(Info firstInfo) {
		Queue<Info> queue = new LinkedList<>();
		queue.add(firstInfo);
		isVisit[firstInfo.x1][firstInfo.y1][firstInfo.x2][firstInfo.y2] = true;

		while (!queue.isEmpty()) {
			Info info = queue.poll();
			if (info.count >= 10) {	//count 10넘는 경우 -1 return
				break;
			}

			for (int i = 0; i < dx.length; i++) {
				int nx1 = info.x1 + dx[i];
				int ny1 = info.y1 + dy[i];
				int nx2 = info.x2 + dx[i];
				int ny2 = info.y2 + dy[i];
				int drop = 0; // 떨어진 동전 갯수
				if (isGo(nx1, ny1)) {
					if (matrix[nx1][ny1] == '#') {	//벽만나면 못감
						nx1 = info.x1;
						ny1 = info.y1;
					}
				}else {	//떨어진 동전 ++
					drop++;
				}

				if (isGo(nx2, ny2)) {	//벽만나면 못감
					if (matrix[nx2][ny2] == '#') {
						nx2 = info.x2;
						ny2 = info.y2;
					}
				}else {	//떨어진 동전++
					drop++;
				}

				if (drop == 1) {	//떨어진 동전 1개이면 이게 최소값(queue에 count를 add하므로 count 1인거 쭉 찾고, count 2 쭉 찾고.. 이과정을 반복하니 가장 먼저 나오는 return 값이 count 최소값)
					return info.count + 1;
				} else if (drop == 0) {//떨어진 동전 하나도 없으면
					if (!isVisit[nx1][ny1][nx2][ny2]) {
						isVisit[nx1][ny1][nx2][ny2] = true;
						queue.add(new Info(nx1, ny1, nx2, ny2, info.count + 1));
					}
				}

			}
		}
		return -1;

	}

	private static boolean isGo(int nx, int ny) {
		if (0 <= nx && nx < n && 0 <= ny && ny < m) {
			return true;
		}
		return false;
	}

	static private class Info {
		int x1;
		int y1;
		int x2;
		int y2;
		int count;

		public Info(int x1, int y1, int x2, int y2, int count) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.count = count;

		}
	}

}
