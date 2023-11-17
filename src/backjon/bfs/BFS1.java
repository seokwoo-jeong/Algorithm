package backjon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//https://www.acmicpc.net/problem/1697
//숨바꼭질
//최소값을 구하는 것이므로 bfs이용
public class BFS1 {
	static int[] matrix;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		matrix = new int[100001];
		String[] def = in.readLine().split(" ");
		
		int n = Integer.parseInt(def[0]);
		k = Integer.parseInt(def[1]);
		
		bfs(n);
		System.out.println(matrix[k]);

	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			if(x == k) {
				break;
			}
			
			for(int i =0; i<3; i++) {
				int nx = 0;
				if(i == 0) {
					nx = x-1;
				}else if(i==1) {
					nx = x+1;
				}else {
					nx = x*2;
				}
				if(0<=nx && nx<=100000) {
					if(matrix[nx] == 0) {
						queue.offer(nx);
						matrix[nx] = matrix[x] + 1;
					}
				}
			}
		}
		
	}

}
