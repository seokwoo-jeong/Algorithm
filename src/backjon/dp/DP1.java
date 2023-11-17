package backjon.dp;

import java.util.*;

//https://www.acmicpc.net/problem/1463
//1로 만들기

public class DP1 {
	static boolean[] isVisit;
	static int max;
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		max = 1000001;
		isVisit = new boolean[max];
		int n = scanner.nextInt();
		
		
		System.out.println(bfs(n,0));
	}
	private static int bfs(int start, int startCount) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {start,startCount});
		isVisit[start] = true;
		while(!queue.isEmpty()) {
			int[] def = queue.poll();
			int n = def[0];
			int count = def[1];
			
			if(n == 1) {
				return count;
			}
			
			if(n%3 == 0) {
				int newN = n/3;
				if(!isVisit[newN]) {
					queue.add(new int[] {newN, count+1});
					isVisit[newN] = true;
				}
			}
			
			if(n%2 == 0) {
				int newN = n/2;
				if(!isVisit[newN]) {
					queue.add(new int[] {newN, count+1});
					isVisit[newN] = true;
				}
				
			}
			if(n-1 >=0) {
				int newN = n-1;
				if(!isVisit[newN]) {
					queue.add(new int[] {newN, count+1});
					isVisit[newN] = true;
				}
			}
		}
		return -1;
	}

}
