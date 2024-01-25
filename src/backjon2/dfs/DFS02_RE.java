package backjon2.dfs;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2668
// 숫자고르기 (골5)

public class DFS02_RE {

	private static boolean[] isVisit;
	private static HashSet<Integer> hash;
	private static List<Integer> array;
	private static int[][] matrix;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		matrix = new int[2][n];
		isVisit = new boolean[n];
		hash = new HashSet<>();
		array = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			matrix[0][i] = i;
			matrix[1][i] = Integer.parseInt(br.readLine()) - 1;
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			dfs(i);

			if (!isSame()) {
				revoke();
			} else {
				result.addAll(result.size(), array);
			}
			hash.clear();
			array.clear();
		}
		Collections.sort(result);

		System.out.println(result.size());
		for (int r : result) {
			System.out.println(r + 1);
		}

	}

	private static void revoke() {
		for (int a : array) {
			isVisit[a] = false;
		}
	}

	private static boolean isSame() {
		for (int r : array) {
			if (!hash.contains(r)) {
				return false;
			}
		}
		return true;
	}

	private static void dfs(int start) {
		if (isVisit[start]) {
			return;
		}

		int nextValue = matrix[1][start];
		array.add(start);
		hash.add(nextValue);
		isVisit[start] = true;

		dfs(nextValue);
	}

}
