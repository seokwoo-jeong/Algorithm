package backjon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
// https://www.acmicpc.net/problem/2667
// 단지번호붙이기
public class Graph5 {
	static char[][] matrix;
	static boolean[][] isVisited;
	static int n;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		matrix = new char[n][n];
		isVisited = new boolean[n][n];
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			matrix[i] = in.readLine().toCharArray();
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(!isVisited[i][j] && matrix[i][j] == '1') {
					count = 0;
					result.add(dfs(i,j));
				}
			}
		}
		System.out.println(result.size());
		Collections.sort(result);
		for(int i = 0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	private static int dfs(int x, int y) {
		count++;
		isVisited[x][y] = true;
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if((0<=nx && nx<n) && (0<=ny && ny<n)) {
				if(!isVisited[nx][ny] && matrix[nx][ny] == '1') {
					dfs(nx,ny);
				}
			}
		}
		return count;
	}

}
