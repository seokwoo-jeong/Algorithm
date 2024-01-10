package backjon2.bfs;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/5427
// 불(골4)

public class BFS06_RE {

	private static int n;
	private static int m;
	private static char[][] matrix;
	private static boolean[][] isVisit;
	private static int[] dx = new int[] {1,-1,0,0};
	private static int[] dy = new int[] {0,0,1,-1};
	private static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		int index = 0;
		String[] temp = null;
		n = 0;
		m = 0;
		int[] cur = new int[3];
		StringBuilder sb = new StringBuilder();
		while(index < t) {
			index++;
			temp = br.readLine().split(" ");
			n = Integer.parseInt(temp[1]);
			m = Integer.parseInt(temp[0]);
			matrix = new char[n][m];
			isVisit = new boolean[n][m];
			HashSet<int[]> hash = new HashSet<>();
			result = -1;
			for(int i = 0; i<n; i++) {
				matrix[i] = br.readLine().toCharArray();
				
				for(int z = 0; z<m; z++) {
					if(matrix[i][z] == '@') {
						matrix[i][z] = '.';
						cur[0] = i;
						cur[1] = z;
					}
					
					if(matrix[i][z] == '*') {
						hash.add(new int[] {i,z});
					}
				}
			}
			bfs(cur,hash);
			
			if(result == -1) {
				sb.append("IMPOSSIBLE");
			}else {
				sb.append(result);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void bfs(int[] curL, HashSet<int[]> hash) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(curL);
		isVisit[curL[0]][curL[1]] = true;
		boolean flag= false;
		int time = -1;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			int curT = cur[2];
			
			if(time != curT) {
				hash = burn(hash);
				time = curT;
			}
			
			for(int i = 0; i<dx.length; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(isOut(nx,ny)) {
					result = curT + 1;
					flag = true;
					break;
				}
				
				if(isVisit[nx][ny] || matrix[nx][ny] != '.') {
					continue;
				}
				queue.add(new int[] {nx,ny, curT+1});
				isVisit[nx][ny] = true;
			}
			if(flag) {
				break;
			}
		}
	
		
	}
	
	private static HashSet<int[]> burn(HashSet<int[]> hash){
		HashSet<int[]> newBurn = new HashSet<>();
		
		List<int[]> array = new ArrayList<>(hash);
		
		for(int[] loc : array) {
			int x = loc[0];
			int y = loc[1];
			for(int i = 0; i<dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(isOut(nx,ny)) {
					continue;
				}
				if(matrix[nx][ny] == '.') {
					matrix[nx][ny] = '*';
					newBurn.add(new int[] {nx,ny});
				}
			}
		}
		return newBurn;
	}
	
	private static boolean isOut(int x, int y) {
		if(0<= x && x <n && 0<=y && y < m) {
			return false;
		}
		return true;
	}

}
