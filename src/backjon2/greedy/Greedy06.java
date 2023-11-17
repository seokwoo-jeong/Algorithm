package backjon2.greedy;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/19598
// 최소 회의실 개수 (골5)

public class Greedy06 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Info[] array = new Info[n];
		String[] temp = null;
		int start = 0;
		int finish = 0;
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			start = Integer.parseInt(temp[0]);
			finish = Integer.parseInt(temp[1]);
			
			Info info = new Info(start, finish);
			array[i] = info;
		}
		
		Arrays.sort(array);

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(Info info : array) {
			if(queue.isEmpty()) {
				queue.add(info.finish);
				continue;
			}
			if(info.start >= queue.peek()) {
				queue.poll();
			}
			queue.add(info.finish);
		}
		
		System.out.println(queue.size());
	}
	
	private static class Info implements Comparable<Info>{
		
		public int start;
		public int finish;
		
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
