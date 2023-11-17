package backjon.bfs;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/13913
//숨바꼭질4 복기

public class BFS2_Review {
	static int[] matrix;
	static int[] parent;
	static boolean[] isVisit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def= br.readLine().split(" ");
		int n = Integer.parseInt(def[0]);
		int k = Integer.parseInt(def[1]);
		matrix = new int[100001];
		parent = new int[100001];		//parent[자식] = 부모
		isVisit = new boolean[100001];
		bfs(n,k);
		System.out.println(matrix[k]);
		
		int child = k;
		int index = matrix[k]-1;
		int[] result = new int[matrix[k]];
		for(int i = 0; i<matrix[k]; i++) {
			
			int par = parent[child];
			result[index] = par;
			index--;
			child = par;
		}
		for(int i = 0; i<result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.print(k);
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
						parent[newCurrent] = current;
						queue.add(newCurrent);
					}
				}
			}
		}
		
	}

}
