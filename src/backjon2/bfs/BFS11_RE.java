package backjon2.bfs;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/14867
// 물통 (골2)

public class BFS11_RE {
	private static int a;
	private static int b;
	private static int c;
	private static int d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		a = Integer.parseInt(temp[0]);
		b = Integer.parseInt(temp[1]);
		c = Integer.parseInt(temp[2]);
		d = Integer.parseInt(temp[3]);


		if(!bfs(0, 0, 0)) {
			System.out.println(-1);
		}
	}

	private static boolean bfs(int x, int y, int count) {
		Queue<int[]> queue = new LinkedList<>();
		HashSet<String> hash = new HashSet<>();
		hash.add("0 0");
		queue.add(new int[] { x, y, count});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			int curC = cur[2];
			
			if(curX == c && curY == d) {
				System.out.println(curC);
				return true;
			}
			for (int i = 0; i < 6; i++) {
				int[] n = setNext(i, curX, curY);
				int nx = n[0];
				int ny = n[1];

				if (nx > a || ny > b) {
					continue;
				}
				String value = String.valueOf(nx) + " " + String.valueOf(ny);
				
				if(hash.contains(value)) {
					continue;
				}
				hash.add(value);
				queue.add(new int[] {nx,ny,curC+1});
			}
		}
		return false;
	}

	private static int[] setNext(int i, int x, int y) {
		if (i == 0) { // x에 물가득
			return new int[] { a, y };
		} else if (i == 1) { // y에 물가득
			return new int[] { x, b };
		} else if (i == 2) { // x 물 버리기
			return new int[] { 0, y };
		} else if (i == 3) { // y 물 버리기
			return new int[] { x, 0 };
		} else if (i == 4) { // x물 y에 붓기
			int temp = x - (b - y);
			if (temp < 0) {
				return new int[] { 0, y + x };
			} else {
				return new int[] { temp, b };
			}
		} else { // y물 x에 붓기
			int temp = y - (a - x);
			if (temp < 0) {
				return new int[] { x + y, 0 };
			} else {
				return new int[] { a, temp };
			}
		}
	}

}
