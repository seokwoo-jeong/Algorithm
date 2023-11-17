package backjon.bfs2;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/16928
//뱀과 사다리 게임

public class BFS1 {
	static boolean[] isVisit;
	static int[] matrix; // 0이 아니면 사다리 혹은 뱀
	static int[] countMatrix;
	static int max = 101;
	static int[] dice = { 1, 2, 3, 4, 5, 6 };

	public static void main(String[] args) throws IOException {
		isVisit = new boolean[max];
		matrix = new int[max];
		countMatrix = new int[max];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def = br.readLine().split(" ");
		int n = Integer.parseInt(def[0]);
		int m = Integer.parseInt(def[1]);

		for (int i = 0; i < n + m; i++) {
			String[] def2 = br.readLine().split(" ");
			matrix[Integer.parseInt(def2[0])] = Integer.parseInt(def2[1]);
		}
		bfs();
		System.out.println(countMatrix[max - 1]);
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i = 0; i < dice.length; i++) {
				int nCurrent = current + dice[i];
				if (isVisit(nCurrent)) {
					if (matrix[nCurrent] != 0) { // 사다리나 뱀 만난경우
						nCurrent = matrix[nCurrent];
					}
					// 한번도 방문한적이 없거나, 현재 방문 시점이 전 방문 시점보다 주사위 돌린 횟수가 적은 경우
					if (!isVisit[nCurrent] || countMatrix[current] + 1 < countMatrix[nCurrent]) {
						countMatrix[nCurrent] = countMatrix[current] + 1;
						queue.add(nCurrent);
						isVisit[nCurrent] = true;
					}
				}
			}
		}
	}

	public static boolean isVisit(int nCurrent) {
		boolean flag = false;
		if (1 <= nCurrent && nCurrent <= 100) {
			flag = true;
		}
		return flag;
	}
}