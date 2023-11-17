package backjon2.bfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1697
// 숨바꼭질 (실버1)
public class BFS01 {

	static int max = 100001;
	static int[] matrix;
	static boolean[] isVisit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		matrix = new int[max];		//matrix[좌표] = 시간
		isVisit = new boolean[max];
		
		bfs(n,k);
		System.out.println(matrix[k]);
	}
	
	private static void bfs(int start, int finish) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		isVisit[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			if(current == finish) {
				break;
			}
			
			for(int i = 0; i<3; i++) {
				int next = 0;
				if(i == 0) {
					next = current -1;
				}else if(i==1) {
					next = current +1;
				}else {
					next = current * 2;
				}
				
				if(!isGo(next)) {
					continue;
				}
				
				if(isVisit[next]) {
					continue;
				}
				
				matrix[next] = matrix[current] + 1;
				isVisit[next] = true;
				queue.add(next);
				
			}
		}
		
		
		
	}
	
	private static boolean isGo(int current) {
		if(0 <= current && current < max) {
			return true;
		}
		return false;
	}

}
