package backjon2.bfs;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/5427
// 불(골4)

public class BFS06 {

	private static int n;
	private static int m;
	private static char[][] matrix;
	private static boolean[][] isVisit;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	private static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		String[] temp = null;
		for(int i = 0; i<t; i++) {
			temp = br.readLine().split(" ");
			n = Integer.parseInt(temp[1]);
			m = Integer.parseInt(temp[0]);
			
			matrix = new char[n][m];
			isVisit = new boolean[n][m];
			result = 0;
			int x = 0;
			int y = 0;
			ArrayList<int[]> fireArray = new ArrayList();
			for(int z = 0; z<n; z++) {
				matrix[z] = br.readLine().toCharArray();
				
				for(int k = 0; k<m; k++) {
					if(matrix[z][k] == '@') {
						x = z;
						y = k;
					}else if(matrix[z][k] == '*') {
						fireArray.add(new int[] {z,k,0});
					}
				}
			}
			//StringBuilder로 교체
			if(start(x,y,fireArray)) {
				System.out.println(result);
			}else {
				System.out.println("IMPOSSIBLE");
			}
			
		}

	}
	
	private static boolean start(int x, int y, ArrayList<int[]> fireArray) {
		Queue<int[]> queue = new LinkedList<>();
		Queue<int[]> queue2 = new LinkedList<>();
		
		for(int[] fire : fireArray) {
			queue2.add(fire);
		}
		queue.add(new int[] {x,y,0});
		isVisit[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int curX = cur[0];
			int curY = cur[1];
			int curT = cur[2];
			
			while(!queue2.isEmpty() && queue2.peek()[2] == curT) {	//현재 시간 초가 같으면 불이 번져야 한다.
					fireMove(queue2);
			}
			
			//불 번졌으면 이동 시키기 - 함수로 교체
			for(int i = 0; i<dx.length; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(isOut(nx,ny)) {
					result = curT + 1;
					return true;
				}
				
				if(matrix[nx][ny] == '.' && !isVisit[nx][ny]) {
					queue.add(new int[] {nx,ny, curT+1});
					isVisit[nx][ny] = true;
				}
			}
			
		}
		return false;
	}
	
	private static void fireMove(Queue<int[]> queue) {
		int[] curFire = queue.poll();
		
		int curFireX = curFire[0];
		int curFireY = curFire[1];
		int curFireT = curFire[2];
		
		for(int i = 0; i<dx.length; i++) {
			int nx = curFireX + dx[i];
			int ny = curFireY + dy[i];
			
			if(isOut(nx,ny)) {
				continue;
			}
			
			if(matrix[nx][ny] == '.') {
				matrix[nx][ny] = '*';
				queue.add(new int[] {nx,ny,curFireT+1});
			}
		}		
	}
	
	
	private static boolean isOut(int x, int y) {
		if(0<= x && x< n && 0<= y && y<m) {
			return false;
		}
		return true;
	}

}
