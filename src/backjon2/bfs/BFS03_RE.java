package backjon2.bfs;

// https://www.acmicpc.net/problem/14226
// 이모티콘(골4)

import java.util.*;
import java.io.*;

public class BFS03_RE {
	private static int[][] matrix; //[화면][클립보드]= 시간
	private static boolean[][] isVisit;
	private static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int s = Integer.parseInt(br.readLine());
		
		matrix = new int[2000][2000];
		isVisit = new boolean[2000][2000];
		
		
		bfs(s);
		System.out.println(result);
	}
	
	private static void bfs(int s) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {1,0,0});
		isVisit[1][0] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curW = cur[0];
			int curC = cur[1];
			int curT = cur[2];
			
			if(curW == s) {
				result = curT;
				break;
			}

			for(int i = 0; i<3; i++) {
				int newW = 0;
				int newC = 0;
				
				if(i == 0) {	
					newW = curW;
					newC = curW;
					
				}else if(i == 1) {
					if(curC == 0 || curW+curC >1000) {
						continue;
					}
					newW = curW + curC;
					newC = curC;
					
				}else {
					if(curW <=0) {
						continue;
					}
					newW = curW -1;
					newC = curC;
			
				}
				if(!isVisit[newW][newC]) {
					queue.add(new int[] {newW,newC,curT+1});
					isVisit[newW][newC] = true;
				}
			}
		}
	}
}
