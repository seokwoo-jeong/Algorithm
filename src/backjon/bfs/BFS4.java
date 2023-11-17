package backjon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BFS4 {
//https://www.acmicpc.net/problem/13549
//숨바꼭질3
/*
 * 최초에 방문 유무를 map이 0인지 아닌지 판단했는데, 이렇게 되면 *2, *2로 두번 들어간 경우도 처음 방문한 경우로 인지하기 때문에 논리적으로 맞지않아 이 부분을 인지하기 까지 시간이 오래걸렸다.
 * +1, -1, *2 각각의 경우의 수를 지정해주고, 처음방문이거나/ 현재 시간이 기존 시간보다 작은 경우 현재 시간을 map에 적용해 줌 
 * 
 * 정리
 * 1. 각 경우의 수에 대한 값이 다를 경우, 기존 값과 새로운 값을 비교
 * 2. 기존 값이 더 결과에 적합한 경우 새로운 값에 대한 경로를 종료 시킨다.
 * 3. 새로운 값이 더 결과에 적합한 경우 기존값을 새로운 값으로 바꿔준 후 경로 계속 진행
 */
	static int[] map;
	static int n;
	static int k;
	static int max = 100000;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] def = in.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		k = Integer.parseInt(def[1]);
		map = new int[max+1];
		isVisited = new boolean[max+1];
		bfs(n);
		System.out.println(map[k]);
		

	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			int x = queue.poll();
			isVisited[x] = true;
			
			if(0<= x+1 && x+1 <= max) {		// +1인 경우
				if(!isVisited[x+1] || map[x] + 1 < map[x+1]) { //처음방문이거나 현재 시간이 기존 시간보다 작은 경우
					map[x+1] = map[x] + 1;
					queue.offer(x+1);
					isVisited[x+1] = true;
				}
			}
			if(0<= x-1 && x-1 <= max) { //-1경우
				if(!isVisited[x-1] || map[x]+1 < map[x-1]) {
					map[x-1] = map[x] + 1;
					queue.offer(x-1);
					isVisited[x-1] = true;
				}
			}
			if(0<= x*2  && x*2 <= max) {	//*2경우
				if(!isVisited[x*2] || map[x] < map[x*2]) {
					map[x*2] = map[x];
					queue.offer(x*2);
					isVisited[x*2] = true;
				}
			}
			
			
		}
		
	}

}
