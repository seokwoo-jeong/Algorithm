package backjon2.bfs;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1697
// 숨바꼭질

public class BFS01_RE {

	private static int n;
	private static int k;
	private static boolean[] isVisit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		isVisit = new boolean[100001];
		
		int result = bfs();
		System.out.println(result);
	}
	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {0,n});	//0초,현재위치
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int curTime = cur[0];
			int curLoc = cur[1];
			
			if(curLoc == k) {
				return curTime;
			}
			int nextLoc = 0;
			for(int i = 0; i<3; i++) {
				if(i==0) {
					nextLoc = curLoc - 1;
				}else if(i==1) {
					nextLoc = curLoc + 1;
				}else {
					nextLoc = curLoc * 2;
				}
				if(!isGo(nextLoc)) {
					continue;
				}
				
				if(isVisit[nextLoc]) {
					continue;
				}
				isVisit[nextLoc] = true;
				queue.add(new int[] {curTime+1, nextLoc});
			}
					
		}
		return 0;
	}
	
	private static boolean isGo(int loc) {
		if(0<= loc && loc <=100000) {
			return true;
		}
		return false;
	}
}
