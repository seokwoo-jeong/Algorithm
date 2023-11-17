package backjon.bfs2;

import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/16946
//벽 부수고 이동하기 4
public class BFS6 {
	static int n;
	static int m;
	static char[][] matrix;
	static int[][] group;
	static int[] groupCountArray;
	static boolean[][] isVisit;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] def= br.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		m = Integer.parseInt(def[1]);
		matrix = new char[n][m];
		isVisit = new boolean[n][m];
		group = new int[n][m];
		groupCountArray = new int[n*m+1];
		for(int i = 0; i<n; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		int groupNo = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(matrix[i][j] == '0') {
					if(!isVisit[i][j]) {
						groupNo++;
						bfs(i,j,groupNo);
					}
				}
			}
		}
		
		setResult();
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				bw.write(matrix[i][j]);
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		
	}
	private static void setResult() {
		ArrayList<Integer> groupNoArray = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(matrix[i][j] == '1') {
					groupNoArray = new ArrayList<>();
					for(int k = 0; k<dx.length; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(isGo(nx,ny)) {
							if(!groupNoArray.contains(group[nx][ny])) {
								groupNoArray.add(group[nx][ny]);		//인접한 그룹번호들 저장
							}
							
						}
					}
					int sum = 1;
					for(int z = 0; z<groupNoArray.size(); z++) {
						sum = sum + groupCountArray[groupNoArray.get(z)];	//그룹번호에 해당하는 값들 다 더해주기
					}
					matrix[i][j] = (char)(sum%10 + '0');	//matrix에 더한 값들 set
				}

			}
		}
		
	}
	private static void bfs(int x, int y, int groupNo) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{x,y});
		isVisit[x][y] = true;
		group[x][y] = groupNo;
		int curCount = 1;
		while(!queue.isEmpty()) {
			int[] def = queue.poll();
			int curX = def[0];
			int curY = def[1];
			
			
			for(int i = 0; i<dx.length; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if(isGo(nx,ny)) {
					if(!isVisit[nx][ny]) {
						if(matrix[nx][ny] == '0') {
							isVisit[nx][ny] = true;
							queue.add(new int[] {nx,ny});
							curCount++;
							group[nx][ny] = groupNo;		// 0인곳에 그룹 번호 넣어주기
						}

					}
				}
			}
		}
		groupCountArray[groupNo]= curCount;	//그룹번호의 값 저장
	}
	private static boolean isGo(int x, int y) {
		if(0<= x && x<n && 0<=y && y<m) {
			return true;
		}
		return false;
	}

}
