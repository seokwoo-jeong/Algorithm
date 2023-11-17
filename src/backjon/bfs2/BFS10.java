package backjon.bfs2;

// https://www.acmicpc.net/problem/16236
// 아기 상어

import java.io.*;
import java.util.*;

/*
 * 1. 현재 상어가 먹을 수 있는 물고기들을 찾는다.
 * 2. 물고기중 가장 가까운 물고기를 찾는다.
 * 3. 만약 가장 가까운 물고기가 여러마리인 경우, 가장 왼쪽에 있는 물고기를 먹는다.
 * 
 */
public class BFS10 {
	static int[][] matrix;
	static boolean[][] checkMatrix; // 먹이 list에 넣었는지 안넣었는지 chk
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n;
	static PriorityQueue<Feed> feedArray = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		checkMatrix = new boolean[n][n];
		int startX = 0;
		int startY = 0;
		for (int i = 0; i < n; i++) {
			String[] def = br.readLine().split(" ");
			for (int j = 0; j < def.length; j++) {
				matrix[i][j] = Integer.parseInt(def[j]);
				if (matrix[i][j] == 9) {
					startX = i;
					startY = j;
					matrix[i][j] = 0;
				}
			}
		}
		int currentSize = 2;
		int result = 0;
		int count = 0;
		while (true) {
			findFeeds(startX, startY, 0, currentSize); // 현재 먹을수 있는 먹이들 찾기
			
			if(!feedArray.isEmpty()) {
				// 우선순위 높은 먹이를 잡아먹고 그 위치로 이동
				Feed feed = feedArray.poll();
				count++;
				//System.out.println("x: " + feed.x + " y:" + feed.y + " dis:" + feed.distance + " size:" + currentSize);
				matrix[feed.x][feed.y] = 0;	//잡아먹은 물고기 위치 빈칸으로 바꾸기
				startX = feed.x;	//상어 위치 변경
				startY = feed.y;	//상어 위치 변경
				if(count == currentSize) {
					currentSize++;
					count= 0;
				}
				result += feed.distance;
				feedArray.clear();
			}else {
				break;
			}
		}
		System.out.println(result);
	}

	private static void findFeeds(int startX, int startY, int startDistance, int startSize) {
		boolean[][] isVisit = new boolean[n][n]; // 방문여부 초기화
		boolean[][] checkMatrix = new boolean[n][n];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { startX, startY, startDistance, startSize });
		while (!queue.isEmpty()) {
			int[] def = queue.poll();
			int x = def[0];
			int y = def[1];
			int dis = def[2];

			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (!isGo(nx, ny)) { // matrix에서 넘어가면 continue
					continue;
				}
				if (matrix[nx][ny] > startSize) { // 상어 사이즈가 더 작은 경우 못감
					continue;
				}

				if (!isVisit[nx][ny]) { // 방문한적 없는경우
					if (startSize > matrix[nx][ny] && matrix[nx][ny] != 0) { // 현재 상어 크기보다 더 작은 물고기인 경우
						if (!checkMatrix[nx][ny]) { // feedArray에 없는 물고기인 경우
							
							feedArray.add(new Feed(nx, ny, dis + 1)); // 먹이 array에 해당 물고기 추가
							checkMatrix[nx][ny] = true; // 해당 물고기 먹이 array에 넣었다고 표시
						}

					}
					queue.add(new int[] { nx, ny, dis + 1 });
					isVisit[nx][ny] = true;
				}
			}
		}
	}

	private static boolean isGo(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < n) {
			return true;
		}
		return false;
	}

	private static class Feed implements Comparable<Feed> {
		int x;
		int y;
		int distance;

		public Feed(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public int compareTo(Feed o) { //거리 가장 가깝고, 가장 위, 가장 왼쪽
            if(o.distance == this.distance) {
                if(o.x == this.x) {
                	return this.y - o.y;
                }else {
                	return this.x - o.x;
                }
            }
            return this.distance - o.distance;
		}
	}
}
