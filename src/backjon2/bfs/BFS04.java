package backjon2.bfs;

import java.io.*;
import java.util.*;
// https://www.acmicpc.net/problem/13549
// 숨바꼭질 3(골5)
public class BFS04 {
	
	private static boolean[] isVisit;
	private static int[] array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int size = 100001;
		isVisit = new boolean[size];
		array = new int[size]; // array[현재위치] = [값]
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);

		
		bfs(n,k);
		System.out.println(array[k]);
	}
	
	private static void bfs(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		isVisit[n] = true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			int next = 0;
			int time = 0;
			for(int i = 0; i<3; i++) {
				next = cur;
				if(i == 0) {
					next++;
					time = 1;
				}else if(i==1) {
					next--;
					time = 1;
				}else {
					next = cur*2;
					time = 0;
				}
				if(0<= next && next<=100000) {
					if(!isVisit[next] || array[next] > array[cur] + time) {
						array[next] = array[cur] + time;
						isVisit[next] = true;
						queue.add(next);
					}
				}
			
			}
			

			
		}
		
	}

}
