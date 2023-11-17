package backjon.bfs2;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/12886
//돌 그룹
public class BFS4 {
	static boolean[][] isVisit;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		max = 1501;
		isVisit = new boolean[max][max];
		String[] def = br.readLine().split(" ");
		int a = Integer.parseInt(def[0]);
		int b = Integer.parseInt(def[1]);
		int c = Integer.parseInt(def[2]);

		System.out.println(bfs(a, b, c));

	}

	private static int bfs(int fa, int fb, int fc) {
		if((fa + fb + fc) % 3 != 0) {
			return 0;
		}
		
		Queue<int[]> queue = new LinkedList<>();
		int[] f = {fa,fb,fc};
		queue.add(f);
		isVisit[fa][fb] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			Arrays.sort(cur);

			int ca = cur[0];
			int cb = cur[1];
			int cc = cur[2];
			
			if (ca == cb && cb == cc) {
				return 1;
			}
			
			if (isNotEqual(ca, cb)) {
				int na = ca + ca;
				int nb = cb - ca;
				int nc = cc;
				if (isPossible(na, nb, nc)) {
					if (!isVisit[na][nb]) {
						isVisit[na][nb] = true;
						queue.add(new int[] {na,nb,nc});
					}

				}
			}

			if (isNotEqual(cb, cc)) {
				int na = ca;
				int nb = cb + cb;
				int nc = cc - cb;
				if (isPossible(na, nb, nc)) {
					if (!isVisit[nb][nc]) {
						isVisit[nb][nc] = true;
						queue.add(new int[] {na,nb,nc});
					}
				}

			}

			if (isNotEqual(ca, cc)) {
				int na = ca + ca;
				int nb = cb;
				int nc = cc - ca;
				if (isPossible(na, nb, nc)) {
					if (!isVisit[na][nc]) {
						isVisit[na][nc] = true;
						queue.add(new int[] {na,nb,nc});
					}
				}

			}

		}
		return 0;
	}

	private static boolean isPossible(int a, int b, int c) {
		if (0 < a && a < max && 0 < b && b < max && 0 < c && c < max) {
			return true;
		}
		return false;
	}

	private static boolean isNotEqual(int small, int big) {
		if (small != big) {
			return true;
		}
		return false;
	}

}
