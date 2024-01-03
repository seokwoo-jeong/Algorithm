package backjon2.bfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/13913
// 숨바꼭질4
public class BFS02_RE {

	private static int n;
	private static int k;
	private static boolean[] isVisit;
	private static int max = 100001;
	private static int[] before; // int[cur] = before

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);

		isVisit = new boolean[max];
		before = new int[max];

		int time = bfs();
		
		System.out.println(time);
		dfs(k,n);
	}
	private static void dfs(int value, int end) {
		if(value == end) {
			System.out.print(value + " ");
			return;
		}
		
		dfs(before[value],end);
		System.out.print(value + " ");
	}

	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { 0, n }); // time,loc

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			int curTime = cur[0];
			int curLoc = cur[1];

			if (curLoc == k) {
				return curTime;
			}

			int nextLoc = 0;
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					nextLoc = curLoc - 1;
				} else if (i == 1) {
					nextLoc = curLoc + 1;
				} else {
					nextLoc = curLoc * 2;
				}

				if (!isGo(nextLoc)) {
					continue;
				}

				if (isVisit[nextLoc]) {
					continue;
				}

				isVisit[nextLoc] = true;
				before[nextLoc] = curLoc;
				queue.add(new int[] { curTime + 1, nextLoc });
			}
		}
		return 0;
	}

	private static boolean isGo(int loc) {
		if (0 <= loc && loc < max) {
			return true;
		}
		return false;
	}

}
