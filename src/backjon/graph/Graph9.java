package backjon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//https://www.acmicpc.net/problem/7562
//나이트의 이동
//최소값을 구하는 것이기 때문에 bfs 사용 
public class Graph9 {
	static int finishX;
	static int finishY;
	static int l;
	static boolean[][] isVisited;
	static int[][] matrix;
	static int[] dx = {-1,-2,-2,-1,1,2,2,1};
	static int[] dy = {-2,-1,1,2,2,1,-1,-2};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(in.readLine());
		int count = 1;
		while(count <= testCase) {
			l = Integer.parseInt(in.readLine());
			isVisited = new boolean[l][l];
			matrix = new int[l][l];
			String[] start = in.readLine().split(" ");
			int startX = Integer.parseInt(start[0]);
			int startY = Integer.parseInt(start[1]);
			
			String[] finish = in.readLine().split(" ");
			finishX = Integer.parseInt(finish[0]);
			finishY = Integer.parseInt(finish[1]);
			bfs(startX,startY);
			
			System.out.println(matrix[finishX][finishY]);
			count++;
			
		}
	}
	private static void bfs(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {startX, startY});
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0];
			int y = poll[1];
			isVisited[x][y] = true;
			
			if(x == finishX && y == finishY) {
				break;
			}
			
			for(int i = 0; i<dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx<l && 0<=ny && ny<l) {
					if(!isVisited[nx][ny]) {
						queue.offer(new int[] {nx,ny});
						isVisited[nx][ny] = true;
						matrix[nx][ny] = matrix[x][y] +1;
					}
					
				}
			}
			
		}
	}

}
