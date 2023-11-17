package backjon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//https://www.acmicpc.net/problem/14226
//이모티콘

/*
 * 1. 클립보드에 저장
 * 2. 화면에 붙여넣기
 * 3. 화면 이모티콘 1개 삭제
 * 4. map[화면에 이모티콘 개수][클립보드 개수] = 시간
 * 5. countMap[화면에 이모티콘 개수][클립보드 개수] = 시간
 */
public class BFS3 {
	static int[][] map;
	static boolean[][] isVisited;
	static int max = 2000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(in.readLine());
		map = new int[max][max];		// 현재 화면 이모티콘 개수 1000개 + 현재 클립보드 이모티콘 개수 1000개
		isVisited = new boolean[max][max];
		bfs(1,0);
		int result = max;
		for(int i = 0; i<map[s].length; i++) {
			if(map[s][i] != 0) {
				result = Math.min(result, map[s][i]);
			}
		}
		System.out.println(result);
	}
	private static void bfs(int window, int clipboard) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {window, clipboard});
		isVisited[window][clipboard] = true;
		while(!queue.isEmpty()) {
			int[] inf = queue.poll();
			int beforeWindow = inf[0];
			int beforeClipboard = inf[1];
			
			for(int i = 0; i<3; i++) {
				if(i == 0) {	//클립보드 저장
					int currentWindow = beforeWindow;
					int currentClipboard = beforeWindow;
					if(currentWindow != 0) {	//화면에 이모티콘이 있는경우(화면에 이모티콘 없으면 복사못해서 그 경로는 끝남)
						if(isGo(beforeWindow, beforeClipboard, currentWindow, currentClipboard)) {
							queue.offer(new int[] {currentWindow, currentClipboard});
						}
				
					}
				}else if(i == 1) {//화면에 붙여넣기
					int currentWindow = beforeWindow + beforeClipboard;
					int currentClipboard = beforeClipboard;
					if(beforeClipboard != 0 && currentWindow < max) {//클립보드에 이모티콘이 있는경우(클립보드에 이모티콘 없으면 붙여넣기 불가능) + 화면 이모티콘 개수 최대 2000개
						if(isGo(beforeWindow, beforeClipboard, currentWindow, currentClipboard)) {
							queue.offer(new int[] {currentWindow, currentClipboard});
						}
					}
				}else {//화면 이모티콘 1개 삭제
					int currentWindow = beforeWindow - 1;
					int currentClipboard = beforeClipboard;
					if(beforeWindow != 0) { //화면에 이모티콘이 있는경우 (전 화면의 이모티콘이 0개인 경우 삭제 불가능)
						if(isGo(beforeWindow, beforeClipboard, currentWindow, currentClipboard)) {
							queue.offer(new int[] {currentWindow, currentClipboard});
						}
					}
				}
			}
		}
	}
	
	public static boolean isGo(int beforeWindow, int beforeClipboard, int currentWindow, int currentClipboard) {
		//한번도 오지 않은 곳이거나 || 현재 시점의 시간이 과거 방문한 시간보다 적은 경우 경로 지속
		if(!isVisited[currentWindow][currentClipboard] || map[beforeWindow][beforeClipboard] + 1 < map[currentWindow][currentClipboard]) {
			map[currentWindow][currentClipboard] = map[beforeWindow][beforeClipboard] + 1;
			isVisited[currentWindow][currentClipboard] = true;
			return true;
		}else {
			return false;
		}
	}

}
