package backjon.bfs;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1697
//숨바꼭질 복기

public class BFS1_Review {
	static int[] matrix;
	static boolean[] isVisit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def= br.readLine().split(" ");
		int n = Integer.parseInt(def[0]);
		int k = Integer.parseInt(def[1]);
		matrix = new int[100001];
		isVisit = new boolean[100001];
		bfs(n,k);
		System.out.println(matrix[k]);
	}

	private static void bfs(int start, int finish) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			if(current == finish) {
				break;
			}
			
			for(int i = 0; i<3; i++) {
				int newCurrent = 0;
				if(i == 0) {
					newCurrent = current-1;
				}else if(i == 1) {
					newCurrent = current+1;
				}else {
					newCurrent = current*2;
				}
				if(0<= newCurrent && newCurrent <= 100000) {
					if(!isVisit[newCurrent]) {
						isVisit[newCurrent] = true;
						matrix[newCurrent] = matrix[current] + 1;
						queue.add(newCurrent);
					}
				}
			}
		}
		
	}

}
