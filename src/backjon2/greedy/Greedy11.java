package backjon2.greedy;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/13975
// 파일 합치기3 (골4)

public class Greedy11 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		int index = 0;
		StringBuilder sb = new StringBuilder();
		while (index < t) {
			int k = Integer.parseInt(br.readLine());
			String[] temp = br.readLine().split(" ");
			PriorityQueue<Long> queue = setQueue(temp);

			long result = getAnswer(queue);

			sb.append(result + "\n");

			index++;
		}
		System.out.println(sb.toString());

	}

	private static long getAnswer(PriorityQueue<Long> queue) {
		long result = 0;

		long no1 = 0;
		long no2 = 0;
		while (queue.size()!=1){

			no1 = queue.poll();
			no2 = queue.poll();

			result += no1 + no2;

			queue.add(no1 + no2);
		}

		return result;
	}

	private static PriorityQueue<Long> setQueue(String[] temp) {
		PriorityQueue<Long> queue = new PriorityQueue<>();
		for (int i = 0; i < temp.length; i++) {
			queue.add(Long.parseLong(temp[i]));
		}
		return queue;
	}

}
