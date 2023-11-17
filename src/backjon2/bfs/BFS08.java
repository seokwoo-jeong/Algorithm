package backjon2.bfs;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/16397
// 탈출 (골4)

public class BFS08 {

	private static int t;
	private static int g;
	private static HashSet<Integer> isVisit;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	private static int result;
	private static int limit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		t = Integer.parseInt(temp[1]);
		g = Integer.parseInt(temp[2]);

		isVisit = new HashSet<>();
		result = 0;
		limit = 99999;
		if(bfs(n)) {
			System.out.println(result);
		}else {
			System.out.println("ANG");
		}
	}
	
	private static boolean bfs(int n) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {n,0});		// 현재 번호, 버튼 수
		isVisit.add(n);
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int curN = cur[0];
			int curT = cur[1];
			
			if(curT > t) {
				continue;
			}
			
			if(curN == g) {
				result = curT;
				return true;
			}
			
			int nextN = curN +1;
			if(nextN <= limit) {	//1더하면 99999넘어가지는지 체크
				addQueue(queue, nextN, curT);
			}
			
			if(curN*2 <= limit && curN != 0) {
				nextN = setNext(curN);
				addQueue(queue, nextN, curT);			
			}
		}
		return false;
		
	}
	private static void addQueue(Queue<int[]> queue, int n, int time) {
		if(!isVisit.contains(n)) {
			isVisit.add(n);
			queue.add(new int[] {n, time+1});
		}
	}
	
	private static int setNext(int n) {
		int nextN = n*2;
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(nextN).toCharArray());
		
		sb.setCharAt(0, Character.forDigit(Character.digit(sb.charAt(0),10)-1,10));
		
		nextN = Integer.parseInt(sb.toString());
		
		return nextN;
	}

}
