package backjon2.bfs;

import java.io.*;
import java.util.*;
// https://www.acmicpc.net/problem/13549
// 숨바꼭질 3(골5)
public class BFS04_RE {
	private static int[] array;
	private static boolean[] isVisit;
	private static int result;
	private static int size;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		size = 100001;
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		result = Integer.MAX_VALUE;
		array = new int[size];
		isVisit = new boolean[size];
		
		
		bfs(n,k);
		
		System.out.println(result);
	}
	
	private static void bfs(int n, int k) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {n,0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int curL = cur[0];
			int curT = cur[1];
			
			if(curL == k) {
				result = Math.min(curT, result);
			}
			
			int newL = 0;
			int newT = 0;
			for(int i = 0; i<3; i++) {
				if(i==0) {
					newL = curL-1;
					newT = curT+1;
				}else if(i==1) {
					newL = curL+1;
					newT = curT+1;
					
				}else {
					newL = curL*2;
					newT = curT;
					
				}
				
				if(newL >= size || newL <0) {
					continue;
				}
				
				if(isVisit[newL] && array[newL] < array[curL] + 1) {
					continue;
				}
				
				isVisit[newL] = true;
				array[newL] = newT;
				queue.add(new int[] {newL,newT});
			}
		}
	}
	


}
