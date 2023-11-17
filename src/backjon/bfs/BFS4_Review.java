package backjon.bfs;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/13549
//숨바꼭질 3 복기

public class BFS4_Review {
	static int[] array;
	static boolean[] isVisit;
	static int max = 100001;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def = br.readLine().split(" ");

		array = new int[max];
		isVisit = new boolean[max];

		int n = Integer.parseInt(def[0]);
		int k = Integer.parseInt(def[1]);

		bfs(n);
		System.out.println(array[k]);

	}

	private static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		isVisit[n] = true;
		while (!queue.isEmpty()) {
			int curLoc = queue.poll();

			for (int i = 0; i < 3; i++) {
				int newLoc = curLoc;
				if (i == 0) {
					newLoc = curLoc-1;
					if (0 <= newLoc && newLoc < max) {
						if (!isVisit[newLoc] || array[curLoc] + 1 < array[newLoc]) {
							array[newLoc] = array[curLoc] + 1;
							queue.add(newLoc);
							isVisit[newLoc] = true;
						}
					}
				} else if (i == 1) {
					newLoc = curLoc + 1;
					if (0 <= newLoc && newLoc < max) {
						if (!isVisit[newLoc] || array[curLoc] + 1 < array[newLoc]) {
							array[newLoc] = array[curLoc] + 1;
							queue.add(newLoc);
							isVisit[newLoc] = true;
						}
					}
				} else {
					newLoc = curLoc * 2;
					if (0 <= newLoc && newLoc < max) {
						if (!isVisit[newLoc] || array[curLoc] < array[newLoc]) {
							array[newLoc] = array[curLoc];
							queue.add(newLoc);
							isVisit[newLoc] = true;
						}
					}
				}

			}
		}

	}

}
