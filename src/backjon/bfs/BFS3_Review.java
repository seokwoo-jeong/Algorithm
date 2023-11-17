package backjon.bfs;
import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/14226
//이모티콘 복기

public class BFS3_Review {
	static boolean[][] isVisit;
	static int[][] matrix;	//화면 이모티콘
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		isVisit = new boolean[2000][2000];	//최대 화면에 2000개까지 가능 (화면:1000개 + 클립보드:1000개)
		matrix = new int[2000][2000];
		bfs(1,0);
		int result = Integer.MAX_VALUE;
		for(int i = 0; i<matrix[n].length; i++) {
			if(isVisit[n][i]) {
				result = Math.min(result, matrix[n][i]);
			}
			
		}
		System.out.println(result);
		
	}

	private static void bfs(int x, int y) {//화면이모티콘개수,클립보드개수
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] get = queue.poll();
			int curWindow = get[0];
			int curClip = get[1];
			
			for(int i = 0; i<3; i++) {

				
				int newWindow = curWindow;
				int newClip = curClip;
				if(i==0) {	//화면에 있는 이모티콘 클립보드에 복사
					if(curWindow != 0) { //화면이모티콘 하나도 없는 경우
						newClip = curWindow;
					}
					
				}else if(i==1) {//클립보드에 있는 이모티콘 화면에 붙여넣기
					if(curClip != 0) {	//클립보드에 이모티콘 하나도 없는 경우
						newWindow = curWindow + curClip;
					}
				}else {	//화면 이모티콘 하나 삭제
					if(curWindow != 0) {
						newWindow = curWindow - 1;
					}
				}
				if(newWindow >= 2000 || newClip >= 2000) {
					continue;
				}
				
				if(!isVisit[newWindow][newClip] || matrix[curWindow][curClip] + 1 < matrix[newWindow][newClip]) {
					queue.add(new int[] {newWindow, newClip});
					matrix[newWindow][newClip] = matrix[curWindow][curClip] + 1;
					isVisit[newWindow][newClip] = true;
				}
				
				
			}
		}
		
	}


}
