package backjon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//https://www.acmicpc.net/problem/13913
//숨바꼭질4
//각 노드에 부모노드를 따로 저장하고, 도착지부터 거꾸로 stack에 넣어서 출력
public class BFS2 {
	static int n;
	static int k;
	static int[] map;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] def = in.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		k = Integer.parseInt(def[1]);
		map = new int[100001];
		parent = new int[100001];
		
		bfs(n);
		System.out.println(map[k]);
		
		Stack<Integer> stack = new Stack<>();
		stack.add(k);
		for(int i = 0; i<map[k]; i++) {
			int index = stack.get(i);
			stack.add(parent[index]);
		}
		int size = stack.size();
		for(int i = 0; i<size; i++) {
			System.out.print(stack.pop() + " ");
		}
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			if(x == k) {
				break;
			}
			
			for(int i = 0; i<3; i++) {
				int dx = 0;
				if(i==0) {
					dx = x-1;
				}else if(i==1) {
					dx = x+1;
				}else {
					dx = x*2;
				}
				if(0<=dx && dx<=100000 && map[dx] == 0) {
					map[dx] = map[x] + 1;
					parent[dx] = x;
					queue.offer(dx);
				}
				
			}
		}
	}

}
