package backjon.bfs2;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/12906
// 새로운 하노이 탑

// 검색 용도 사용시 hashSet을 이용
// hashset은 해시 알고리즘을 사용하기 때문에 검색속도가 매우 빨라 O(1)의 속도를 가지고 있다.
// 특징1. Set에 들어오는 값(key)의 중복을 허용하지 않는다.
// 특징2. 저장 순서를 유지하지 않는다.
public class BFS20 {

	private static int a, b, c;
	private static HashSet<String> isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String aa = "";
		String bb = "";
		String cc = "";
		isVisit = new HashSet<>();

		String[] temp = br.readLine().split(" ");
		a = Integer.parseInt(temp[0]);
		if (a != 0) {
			aa = temp[1];
		}

		temp = br.readLine().split(" ");
		b = Integer.parseInt(temp[0]);
		if (b != 0) {
			bb = temp[1];
		}

		temp = br.readLine().split(" ");
		c = Integer.parseInt(temp[0]);
		if (c != 0) {
			cc = temp[1];
		}

		isVisit.add(aa + "/" + bb + "/" + cc);

		System.out.println(bfs(aa, bb, cc));
	}

	private static class Info {
		String a;
		String b;
		String c;
		int count;

		public Info(String a, String b, String c, int count) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.count = count;
		}
	}

	private static boolean isGood(String aa, String bb, String cc) {
		for (char t : aa.toCharArray()) {
			if (t != 'A') {
				return false;
			}
		}

		for (char t : bb.toCharArray()) {
			if (t != 'B') {
				return false;
			}
		}

		for (char t : cc.toCharArray()) {
			if (t != 'C') {
				return false;
			}
		}
		return true;
	}

	private static int bfs(String startA, String startB, String startC) {
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(startA, startB, startC, 0));
		
		if (isGood(startA, startB, startC)) {
			return 0;
		}
		while (!queue.isEmpty()) {
			Info cur = queue.poll();

			String aa = cur.a;
			String bb = cur.b;
			String cc = cur.c;
			int curCount = cur.count;

			if (!aa.isEmpty()) {
				char pick = aa.charAt(aa.length() - 1);
				String na = aa.substring(0, aa.length() - 1);
				String nb = bb + pick;

				String status = na + "/" + nb + "/" + cc;
				if (!isVisit(status)) {
					if (isGood(na, nb, cc)) {
						return curCount + 1;
					}
					queue.add(new Info(na, nb, cc.toString(), curCount + 1));
					isVisit.add(status);
				}
				
				String nc = cc + pick;
				status = na + "/" + bb + "/" + nc;
				if (!isVisit(status)) {
					if (isGood(na, bb, nc)) {
						return curCount + 1;
					}
					queue.add(new Info(na, bb.toString(), nc, curCount + 1));
					isVisit.add(status);
				}
			}
			if (!bb.isEmpty()) {
				char pick = bb.charAt(bb.length() - 1);
				String nb = bb.substring(0, bb.length() - 1);
				String na = aa + pick;

				String status = na + "/" + nb + "/" + cc;

				if (!isVisit(status)) {
					if (isGood(na, nb, cc)) {
						return curCount + 1;
					}
					queue.add(new Info(na, nb, cc.toString(), curCount + 1));
					isVisit.add(status);
				}

				String nc = cc + pick;
				status = aa + "/" + nb + "/" + nc;
				if (!isVisit(status)) {
					if (isGood(aa, nb, nc)) {
						return curCount + 1;
					}
					queue.add(new Info(aa, nb.toString(), nc, curCount + 1));
					isVisit.add(status);
				}
			}

			if (!cc.isEmpty()) {
				char pick = cc.charAt(cc.length() - 1);
				String nc = cc.substring(0, cc.length() - 1);
				String na = aa + pick;

				String status = na + "/" + bb + "/" + nc;

				if (!isVisit(status)) {
					if (isGood(na, bb, nc)) {
						return curCount + 1;
					}
					queue.add(new Info(na, bb, nc.toString(), curCount + 1));
					isVisit.add(status);
				}

				String nb = bb + pick;
				status = aa + "/" + nb + "/" + nc;
				if (!isVisit(status)) {
					if (isGood(aa, nb, nc)) {
						return curCount + 1;
					}
					queue.add(new Info(aa, nb.toString(), nc, curCount + 1));
					isVisit.add(status);
				}
			}
		}
		return -1;
	}

	private static boolean isVisit(String status) {
		if (isVisit.contains(status)) {
			return true;
		}
		return false;
	}

}
