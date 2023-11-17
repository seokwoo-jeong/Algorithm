package backjon.bfs2;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16954
// 움직이는 미로 탈출
public class BFS9 {
	static int size = 8;
	static char[][] matrix;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 ,0};
	static Queue<int[]> queue = new LinkedList<>();
	static boolean[][] isVisit;
	public static void main(String[] args) throws IOException {
		matrix = new char[size][size];
		isVisit = new boolean[size][size];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < size; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		if(bfs()) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}

	}

	private static boolean bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {size-1,0});
		isVisit[size-1][0] = true;
		int time = 0;
		while(!queue.isEmpty()) {
			if(time == 9) {	//8초 지나가면 벽은 사라지므로 갈 수 있음
				return true;
			}
			int curSize = queue.size();
			for(int i = 0; i< curSize; i++) {
				int[] cur = queue.poll();
				int curX = cur[0];
				int curY = cur[1];
				
				if(curX == 0 && curY == size -1) {	// 도착 지점
					return true;
				}
				
				for(int j = 0; j<dx.length; j++) {
					int nx = curX + dx[j];
					int ny = curY + dy[j];
					if(!isGo(nx,ny)) {	//움직인 곳이 메트릭스에서 나간 경우
						continue;
					}
					if(matrix[nx][ny] == '#') {	// 움직인 곳이 벽인 경우
						continue;
					}
					if(nx != 0 && matrix[nx-1][ny] == '#') { // 움직인 곳 위에 벽이 있는 경우
						continue;
					}
					isVisit[nx][ny] = true;
					queue.add(new int[] {nx,ny});
				}
			}
			moveWall();
			time++;
		}
		return false;
	}
	private static boolean isGo(int x, int y) {
		if(0 <= x && x < size && 0 <= y && y < size) {
			return true;
		}
		return false;
	}

	private static void moveWall() {
		for (int i = size - 1; i >= 0; i--) {
			for (int j = 0; j < size; j++) {
				if (matrix[i][j] == '#') {
					matrix[i][j] = '.';
					if (i != size - 1) { // 맨 밑이 아닌경우
						matrix[i + 1][j] = '#';
					}
				}
			}
		}
	}

}
