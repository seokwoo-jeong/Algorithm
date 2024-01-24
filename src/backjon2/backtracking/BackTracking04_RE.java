package backjon2.backtracking;

// https://www.acmicpc.net/problem/15652
// N과 M(4) 실(3)
import java.io.*;

public class BackTracking04_RE {

	private static boolean[] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);

		isVisit = new boolean[n];
		int[] array = new int[m];
		dfs(0, array, n, 1);
	}

	private static void dfs(int depth, int[] array, int n, int start) {
		if (depth == array.length) {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= n; i++) {
			array[depth] = i;
			dfs(depth + 1, array, n, i);
		}
	}

}
