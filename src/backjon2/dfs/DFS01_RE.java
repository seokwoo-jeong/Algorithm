package backjon2.dfs;
import java.io.*;

//https://www.acmicpc.net/problem/10026
//적록색약 (골5)
public class DFS01_RE {

	private static char[][] matrix;
	private static boolean[][][] isVisit;
	private static int n;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		matrix = new char[n][n];
		isVisit = new boolean[n][n][2];	//0:x 1: o
		int[] result = new int[2];
		
		for(int i = 0; i<n; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i<n; i++) {
			for(int z = 0; z<n; z++) {
				if(!isVisit[i][z][0]) {
					isVisit[i][z][0] = true;
					dfs(i,z,0);	//적록색약x
					result[0] ++;
				}
				if(!isVisit[i][z][1]) {
					isVisit[i][z][1] = true;
					dfs(i,z,1);	//적록색약ㅇ
					result[1] ++;
				}
			}
		}
		System.out.println(result[0] + " " + result[1]);
	}
	
	private static void dfs(int x, int y, int flag) {
		int nx = 0;
		int ny = 0;
		
		for(int i = 0; i<dx.length; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(isOut(nx,ny)) {
				continue;
			}
			
			if(isVisit[nx][ny][flag]) {
				continue;
			}
			
			if(matrix[nx][ny] == matrix[x][y]) {
				isVisit[nx][ny][flag] = true;
				dfs(nx,ny,flag);
			}
			
			if(flag == 1) {
				if(matrix[x][y] != 'B' && matrix[nx][ny] != 'B') {
					isVisit[nx][ny][flag] = true;
					dfs(nx,ny,flag);
				}
			}
		}
	}
	
	private static boolean isOut(int x, int y) {
		if(0<= x && x <n && 0<=y && y<n) {
			return false;
		}
		return true;
	}

}
