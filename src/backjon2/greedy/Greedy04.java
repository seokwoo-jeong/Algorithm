package backjon2.greedy;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/11000
// 강의실 배정 (골5)

public class Greedy04 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] temp = null;
		int start = 0;
		int finish = 0;

		Info[] array = new Info[n];
		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			start = Integer.parseInt(temp[0]);
			finish = Integer.parseInt(temp[1]);

			Info info = new Info(start, finish);
			array[i] = info;
		}
		Arrays.sort(array);

		PriorityQueue<Integer> roomArray = new PriorityQueue<>();

		for (Info info : array) {
			if (roomArray.isEmpty()) {
				roomArray.add(info.finish);
			} else {
				if (info.start >= roomArray.peek()) {
					roomArray.poll();
				}
				roomArray.add(info.finish);
			}
		}
		System.out.println(roomArray.size());
	}

	private static class Info implements Comparable<Info> {
		int start;
		int finish;

		public Info(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}

		@Override
		public int compareTo(Info o) {
			return this.start - o.start;
		}
	}

}
