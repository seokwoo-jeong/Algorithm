package backjon.bfs2;
import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/14442
//벽 부수고 이동하기2
public class BFS7 {
	static int n;
	static int m;
	static int k;
	static char[][] matrix;
	static boolean[][][] isVisit;		//x, y, 부순횟수
	static int[][][] countMatrix;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def = br.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		m = Integer.parseInt(def[1]);
		k = Integer.parseInt(def[2]);
		
		matrix = new char[n][m];
		isVisit = new boolean[n][m][k+1];
		countMatrix = new int[n][m][k+1];
		
		for(int i = 0; i<n; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		bfs(0,0,0);
		int result = Integer.MAX_VALUE;
		for(int i = 0; i<=k; i++) {
			if(countMatrix[n-1][m-1][i] != 0){
				result = Math.min(result, countMatrix[n-1][m-1][i]);
			}
			
		}
		if(result == Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
		

	}
	private static void bfs(int i, int j, int l) {
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i,j,l});
		isVisit[i][j][l] = true;
		countMatrix[i][j][l] = 1;
		
		while(!queue.isEmpty()){
			int[] def = queue.poll();
			int x = def[0];
			int y = def[1];
			int count = def[2];
			
			
			for(int z = 0; z<dx.length; z++) {
				int nx = x + dx[z];
				int ny = y + dy[z];
				if(isGo(nx,ny)) {
					if(matrix[nx][ny] == '1') {
						if(count+1 <= k) {
							if(!isVisit[nx][ny][count+1] || countMatrix[x][y][count] + 1 < countMatrix[nx][ny][count+1]) {
								countMatrix[nx][ny][count+1] = countMatrix[x][y][count] + 1;
								queue.add(new int[] {nx,ny,count+1});
								isVisit[nx][ny][count+1] = true;
							}
						}
						
					}else if(matrix[nx][ny] == '0') {
						if(!isVisit[nx][ny][count] || countMatrix[x][y][count] + 1 < countMatrix[nx][ny][count]) {
							countMatrix[nx][ny][count] = countMatrix[x][y][count] + 1;
							queue.add(new int[] {nx,ny,count});
							isVisit[nx][ny][count] = true;
						}
					}
				}
				
			}
			
		}
		
		
	}
	private static boolean isGo(int x, int y) {
		if(0<= x && x<n && 0<=y && y<m) {
			return true;
		}
		return false;
	}

}
