package backjon2.bfs;

// https://www.acmicpc.net/problem/14226
// 이모티콘(골4)

import java.util.*;
import java.io.*;

public class BFS03 {

	static int[][] matrix; // [화면개수][클립보드 개수] = 시간
	static boolean[][] isVisit;
	static int s;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = Integer.parseInt(br.readLine());
		
		matrix = new int[2000][2000];
		isVisit = new boolean[2000][2000];
		
		bfs(1,0);
		
		int result = Integer.MAX_VALUE;
		for(int i = 0; i<2000; i++) {
			if(matrix[s][i] == 0) {
				continue;
			}
			result = Math.min(result, matrix[s][i]);
		}
		System.out.println(result);
	}

	private static void bfs(int b, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {b,c});
		isVisit[b][c] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int cb = cur[0];
			int cc = cur[1];
			
			
			int nb = 0;
			int nc = 0;
			for(int i = 0; i<3; i++) {
				if(i == 0) {	//화면 이모티콘 클립보드에 저장
					nb = cb;
					nc = cb;
				}else if (i == 1){	// 클립보드 이모티콘 화면에 붙여넣기
					if(cc == 0) {
						continue;
					}
					nb = cb+cc;
					nc = cc;
				}else {	//화면 이모티콘 하나 삭제
					if(cur[0] == 1) {
						continue;
					}
					nb = cb-1;
					nc = cc;
				}
				
				if(nb >= 2000 || nc >= 2000) {
					continue;
				}
				
				if(!isVisit[nb][nc] || matrix[cb][cc] +1 < matrix[nb][nc]) {
					matrix[nb][nc] = matrix[cb][cc] +1;
					isVisit[nb][nc] = true;
					queue.add(new int[] {nb,nc});
				}
			}
			
		}
		
	}
}
