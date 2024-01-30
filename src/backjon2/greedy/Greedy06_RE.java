package backjon2.greedy;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/19598
// 최소 회의실 개수 (골5)

public class Greedy06_RE {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Info[] array = new Info[n];
		String[] temp = null;
		
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			
			Info info = new Info(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
			array[i] = info;
		}
		
		Arrays.sort(array);

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		int result = 0;
		for(Info info : array) {
			if(queue.isEmpty()) {
				queue.add(info.finish);
				result++;
				continue;
			}
			
			if(info.start < queue.peek()) {
				result++;
			}else {
				queue.poll();
			}
			queue.add(info.finish);
		}
		
		System.out.println(result);
		
	}
	
	private static class Info implements Comparable<Info>{
		private int start;
		private int finish;
		
		public Info(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}
		
		public int compareTo(Info o) {
			return this.start - o.start;
		}
	}

}
