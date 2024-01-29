package backjon2.greedy;

import java.io.*;
import java.util.*;


// https://www.acmicpc.net/problem/11000
// 강의실 배정 (골5)

public class Greedy04_RE {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		
		Info[] array= new Info[n];
		int[][] arrays = new int[n][2];
		
		
		String[] temp = null;
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			arrays[i][0] = Integer.parseInt(temp[0]);
			arrays[i][1] = Integer.parseInt(temp[1]);
			
			Info info = new Info(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
			array[i] = info;
		}
		
		Arrays.sort(array);
		
	
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (Info info : array) {
			if (queue.isEmpty()) {
				queue.add(info.finish);
			} else {
				if (info.start >= queue.peek()) {
					queue.poll();
				}
				queue.add(info.finish);
			}
		}
		System.out.println(queue.size());
		
	}
	
	private static class Info implements Comparable<Info>{
		private int start;
		private int finish;
		
		public Info(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}
		
		@Override
		public int compareTo(Info o) {
			if(this.start == o.start) {
				return this.finish - o.finish;
			}
			return this.start - o.start;
		}
	}

}
