package backjon.bfs2;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2234
// 성곽
public class BFS19 {
	private static String[][] matrix;
	private static int[][] isVisit;
	private static Map<Integer, ArrayList<Integer>> isCheck; // ex) 1,2번방 사이의 벽 부셨는지 확인
	private static int roomCount;
	private static ArrayList<Integer> roomCountArray;
	private static int bigRoomArea1;
	private static int bigRoomArea2;
	private static int[] dx = { 0, -1, 0, 1 }; // 서 북 동 남
	private static int[] dy = { -1, 0, 1, 0 };
	private static int n;
	private static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);

		matrix = new String[m][n];
		isVisit = new int[m][n];
		isCheck = new HashMap<>();
		roomCountArray = new ArrayList<>();
		roomCount = 0;
		bigRoomArea1 = Integer.MIN_VALUE;
		bigRoomArea2 = Integer.MIN_VALUE;

		for (int i = 0; i < m; i++) {
			String[] temp2 = br.readLine().split(" ");
			matrix[i] = temp2;

			for (int j = 0; j < n; j++) {
				isVisit[i][j] = -1;
			}
		}
		int roomNo = 0;
		for (int i = 0; i < m; i++) { // 방 개수, 가장 넓은 방 구하기
			for (int j = 0; j < n; j++) {
				if (isVisit[i][j] == -1) {
					bfs(i, j, roomNo);
					roomNo++;
				}
			}
		}

		for (int i = 0; i < roomCountArray.size(); i++) {
			isCheck.put(i, new ArrayList<>());
		}

		roomCount = roomNo; // 방 갯수
		int[] dx2 = { 0, 1 };
		int[] dy2 = { 1, 0 };
		for (int i = 0; i < m; i++) { // 하나 벽 제거해 가장 넓은 방 크기 구하기
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < dx2.length; k++) {
					int nx = i + dx2[k];
					int ny = j + dy2[k];
					if (!isGo(nx, ny)) {// 못가는 경우
						continue;
					}
					if (isVisit[i][j] == isVisit[nx][ny]) { // 방 번호가 같은경우
						continue;
					}
					if (isCheck.get(isVisit[i][j]).contains(isVisit[nx][ny])) {// 이미 확인한 경우
						continue;
					}
					bigRoomArea2 = Math.max(bigRoomArea2,
							roomCountArray.get(isVisit[i][j]) + roomCountArray.get(isVisit[nx][ny]));
					isCheck.get(isVisit[i][j]).add(isVisit[nx][ny]);
					isCheck.get(isVisit[nx][ny]).add(isVisit[i][j]);
				}

			}
		}
		System.out.println(roomCount);
		System.out.println(bigRoomArea1);
		System.out.println(bigRoomArea2);

	}

	private static void bfs(int startX, int startY, int roomNo) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { startX, startY });
		isVisit[startX][startY] = roomNo;
		int tempRoomCount = 1;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];

			for (int i = 0; i < dx.length; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if (!isGo(nx, ny) || isVisit[nx][ny] != -1) {
					// matrix밖으로 나가거나, 이미 방문한 경우
					continue;
				}
				if ((Integer.parseInt(matrix[curX][curY]) & (1 << i)) == 0) {// 벽 없는 경우
					isVisit[nx][ny] = roomNo;
					tempRoomCount++;
					queue.add(new int[] { nx, ny });
				}

			}
		}
		roomCountArray.add(tempRoomCount);
		bigRoomArea1 = Math.max(bigRoomArea1, tempRoomCount);
	}

	private static boolean isGo(int x, int y) {
		if (0 <= x && x < m && 0 <= y && y < n) {
			return true;
		}
		return false;
	}

}
