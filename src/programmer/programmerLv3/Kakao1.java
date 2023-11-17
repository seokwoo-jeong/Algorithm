package programmer.programmerLv3;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/67259
// [카카오 인턴]경주로 건설
public class Kakao1 {
	int[] dx = { 1, -1, 0, 0 };
	int[] dy = { 0, 0, 1, -1 };
	int[][][] isVisit;
	int n;
	int answer = Integer.MAX_VALUE;

	public int solution(int[][] board) {
		n = board.length;
		isVisit = new int[n][n][4];
		bfs(0, 0, board);
		/*
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(isVisit[i][j] + " ");
			}
			System.out.println("");
		}
		*/
		return answer;
	}

	private void bfs(int startX, int startY, int[][] board) {
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(startX, startY, -1, 0)); // x,y,방향,금액
		isVisit[startX][startY][0] = 100;
		isVisit[startX][startY][1] = 100;
		isVisit[startX][startY][2] = 100;
		isVisit[startX][startY][3] = 100;

		while (!queue.isEmpty()) {
			Info cur = queue.poll();

			for (int i = 0; i < dx.length; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int ndir = i;
				int npay = cur.pay;

				if (!isGo(nx, ny) || board[nx][ny] == 1) {
					continue;
				}

				if (cur.dir != -1 && ndir != cur.dir) { // 방향이 바뀌는 경우
					npay += 500;
				}
				npay += 100;

				if (nx == n - 1 && ny == n - 1) {
					answer = Math.min(npay, answer);
					continue;
				}

				if (isVisit[nx][ny][ndir] == 0) {
					isVisit[nx][ny][ndir] = npay;
					queue.add(new Info(nx, ny, ndir, npay)); // x,y,방향,금액
				} else if (isVisit[nx][ny][ndir] >= npay) {
					isVisit[nx][ny][ndir] = npay;
					queue.add(new Info(nx, ny, ndir, npay)); // x,y,방향,금액
				}
			}
		}
	}

	private class Info {
		int x;
		int y;
		int dir;
		int pay;

		public Info(int x, int y, int dir, int pay) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.pay = pay;
		}
	}

	private boolean isGo(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < n) {
			return true;
		}
		return false;
	}

}
