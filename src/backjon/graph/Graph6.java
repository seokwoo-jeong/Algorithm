package backjon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// https://www.acmicpc.net/problem/4963
// 섬의 개수
public class Graph6 {
	static int w;
	static int h;
	static int[][] matrix;
	static boolean[][] isVisited;
	static int[] dx = {1,-1,0,0,1,1,-1,-1};
	static int[] dy = {0,0,1,-1,1,-1,1,-1};
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] def = in.readLine().split(" ");
			w = Integer.parseInt(def[0]);
			h = Integer.parseInt(def[1]);
			
			if(w == 0 && h == 0) {
				break;
			}
			count = 0;
			matrix = new int[h][w];
			isVisited = new boolean[h][w];
			
			for(int i = 0; i<h; i++) {
				matrix[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			for(int i= 0; i < h;i++) {
				for(int j = 0; j<w; j++) {
					
					if(!isVisited[i][j] && matrix[i][j] == 1) {
						dfs(i,j);
						count++;
					}
				}
			}
			
			System.out.println(count);
			
		}

	}
	private static void dfs(int x, int y) {
		isVisited[x][y] = true;
		
		for(int i = 0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(( 0<=nx && nx<h ) && ( 0<=ny && ny<w )) {
				if(!isVisited[nx][ny] && matrix[nx][ny] == 1) {
					dfs(nx,ny);
					
				}
			}
		}
		
	}

}
