package backjon2.bfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/13913
// 숨바꼭질4

public class BFS02 {

	static int[] matrix;
	static boolean[] isVisit;
	static int max = 100001;
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		matrix = new int[max];
		isVisit = new boolean[max];
		parent = new int[max];
		
		bfs(n,k);
		
		System.out.println(matrix[k]);
		dfs(k, n);
		
	}
	private static void dfs(int value, int n) {
		if(value == n) {
			System.out.print(n + " ");
			return;
		}
		dfs(parent[value],n);
		System.out.print(value + " ");
	}
	
	
	private static void bfs(int start, int finish) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		isVisit[start] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if(cur == finish) {
				break;
			}
			int next = 0;
			for(int i = 0; i<3; i++) {
				if(i == 0) {
					next = cur-1;
				}else if(i == 1) {
					next = cur+1;
				}else {
					next = cur*2;
				}
				
				if(!isGo(next) || isVisit[next]) {
					continue;
				}
				
				isVisit[next] = true;
				matrix[next] = matrix[cur] + 1;
				parent[next] = cur;
				queue.add(next);
			}
			
		}
		
	}
	private static boolean isGo(int cur) {
		if(0<= cur && cur < max) {
			return true;
		}
		return false;
	}
	
}
