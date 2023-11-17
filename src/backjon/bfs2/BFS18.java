package backjon.bfs2;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/4991
// 로봇 청소기

// bfs를 이용해 청소기->먼지 and 먼지 -> 먼지 경로의 거리를 모두 구한다.
// dfs를 이용해 경로를 조합해 최소값을 구한다.
public class BFS18 {
	static int w;
	static int h;
	static char[][] matrix;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		w = 0;
		h = 0;
		while (true) {
			String[] temp = br.readLine().split(" ");
			w = Integer.parseInt(temp[0]);
			h = Integer.parseInt(temp[1]);
			result = Integer.MAX_VALUE;
			if (isOver(w, h)) {
				break;
			}
			matrix = new char[h][w];
			Node[] list = new Node[11];
			int dustCnt = 1;
			for (int i = 0; i < h; i++) { // matrix세팅
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < line.length; j++) {
					if (line[j] == 'o') { // 로봇청소기 최초위치
						list[0] = new Node(i, j);
						line[j] = '.'; // 빈공간으로 만들기
					} else if (line[j] == '*') {
						list[dustCnt] = new Node(i, j);
						dustCnt++;
					}
					matrix[i][j] = line[j];
				}
			}
			int[][] distMatrix = new int[dustCnt][dustCnt];
			boolean flag = false; // 먼지로 못가는 경우

			// bfs를 이용해 청소기->먼지 and 먼지 -> 먼지 경로의 거리를 모두 구한다.
			for (int i = 0; i < dustCnt - 1; i++) {
				for (int j = i + 1; j < dustCnt; j++) {
					int distance = bfs(list[i], list[j]);
					if (distance == -1) { // 먼지로 못가는 경우
						System.out.println(-1);
						flag = true;
						break;
					}
					distMatrix[i][j] = distance;
					distMatrix[j][i] = distance;
				}
				if (flag) {
					break;
				}

			}
			if (!flag) {
				boolean[] visit = new boolean[dustCnt];
				visit[0] = true;
				dfs(0, dustCnt, 0, visit, distMatrix, 0);
				System.out.println(result);
			}
		}
	}

	private static void dfs(int depth, int end, int sum, boolean[] visit, int[][] distMatrix, int before) {
		if (depth == end - 1) {
			result = Math.min(sum, result);
			return;
		}
		for (int i = 1; i < end; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(depth + 1, end, sum + distMatrix[before][i], visit, distMatrix, i);
				visit[i] = false;
			}
		}

	}

	private static int bfs(Node startNode, Node endNode) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] isVisit = new boolean[h][w];
		queue.add(new int[] { startNode.x, startNode.y, 0 });
		isVisit[startNode.x][startNode.y] = true;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			int curDis = cur[2];
			for (int i = 0; i < dx.length; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if (!isGo(nx, ny) || isVisit[nx][ny] || matrix[nx][ny] == 'x') {
					continue;
				}
				if (nx == endNode.x && ny == endNode.y) {
					return curDis + 1;
				}
				isVisit[nx][ny] = true;
				queue.add(new int[] { nx, ny, curDis + 1 });
			}
		}

		return -1;
	}

	private static boolean isGo(int x, int y) {
		if (0 <= x && x < h && 0 <= y && y < w) {
			return true;
		}
		return false;
	}

	private static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// 0,0 나오면 종료
	private static boolean isOver(int w, int h) {
		if (w == 0 && h == 0) {
			return true;
		}
		return false;
	}

}
