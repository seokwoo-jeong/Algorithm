package backjon2.bfs;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/16397
// 탈출 (골4)

public class BFS08_RE {
	private static int[] array;
	private static boolean[] isVisit;
	private static int limit;
	private static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int t = Integer.parseInt(temp[1]);
		int g = Integer.parseInt(temp[2]);
		limit = 100000;
		
		array = new int[limit];
		isVisit = new boolean[limit];
		
		if(bfs(n,t,g)) {
			System.out.println(result);
		}else {
			System.out.println("ANG");
		}
	}
	
	private static boolean bfs(int n, int t, int g) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {n,0});
		isVisit[n] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curN = cur[0];
			int curT = cur[1];
			
			if(curT > t) {
				return false;
			}
			if(curN == g) {
				result = curT;
				return true;
			}
			
			caseA(cur, queue);
			caseB(cur, queue);
			
		}
		return false;
	}
	
	private static void caseA(int[] cur, Queue<int[]> queue) {
		int newN = cur[0] + 1;
		
		if(newN >= limit || isVisit[newN]) {
			return;
		}
		
		isVisit[newN] = true;
		queue.add(new int[] {newN, cur[1] + 1});
	}
	
	private static void caseB(int[] cur, Queue<int[]> queue) {
		if(cur[0] * 2 >=limit || cur[0] == 0) {
			return;
		}
		
		int newN = calB(cur[0]);
		
		if(newN >= limit || isVisit[newN]) {
			return;
		}
		
		isVisit[newN] = true;
		queue.add(new int[] {newN,cur[1] + 1});
		
	}
	
	
	private static int calB(int n) {
		int nextN = n*2;
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(nextN).toCharArray());
		
		sb.setCharAt(0, Character.forDigit(Character.digit(sb.charAt(0),10)-1,10));
		
		nextN = Integer.parseInt(sb.toString());
		
		return nextN;
	}
	


}
