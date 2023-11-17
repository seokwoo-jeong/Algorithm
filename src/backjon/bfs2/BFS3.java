package backjon.bfs2;
import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/14502
//연구소

//1. 벽 3개를 세운 모든 matrix구하기 -> 백트래킹으로 벽 세우기
//2. bfs를 이용하여 각 matrix에 바이러스 전파시키기
//3. 최대값 저장
public class BFS3 {
	static int[][] matrix;
	static boolean[][] isVisitWall;
	static boolean[][] isVisitVirus;
	static int max;
	static int n;
	static int m;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def = br.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		m = Integer.parseInt(def[1]);
		max = Integer.MIN_VALUE;

		matrix = new int[n][m];
	
		isVisitWall = new boolean[n][m];
		isVisitVirus = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String[] def2 = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(def2[j]);
			}
		}
		setWall(0,0,0);
		System.out.println(max);
	}

	private static void setWall(int depth, int x, int y) {// 같은곳 또 갈 필요없고, 오름차순이고
		if (depth == 3) {
			max = Math.max(virusCount(), max);
			return;
		}
		for (int i = x; i < n; i++) {
			for (int j = 0; j < m; j++) {
                if(i==x && j<y){
                    continue;
                 }
				if (!isVisitWall[i][j]) {
					if (matrix[i][j] == 0) {
						isVisitWall[i][j] = true;
						matrix[i][j] = 1;
						setWall(depth + 1,i,j+1);
						isVisitWall[i][j] = false;
						matrix[i][j] = 0;
					}
				}
			}
		}
	}

	private static int virusCount() {
		int[][] temp = new int[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				temp[i][j]=matrix[i][j];
				isVisitVirus[i][j] = false;
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		ArrayList<int []> virusArray = findInitVirusLocation();
		for(int i = 0; i<virusArray.size(); i++) {
			queue.add(virusArray.get(i));
			isVisitVirus[virusArray.get(i)[0]][virusArray.get(i)[1]] = true;
		}
		while (!queue.isEmpty()) {
			int[] xy = queue.poll();
			int x = xy[0];
			int y = xy[1];
			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isGo(nx, ny)) {
					if (!isVisitVirus[nx][ny] && temp[nx][ny] == 0) {
						isVisitVirus[nx][ny] = true;
						temp[nx][ny] = 2;
						queue.add(new int[] { nx, ny });

					}
				}

			}
		}
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0) {
					result ++;
				}
			}
		}
		return result;

	} 

	private static boolean isGo(int nx, int ny) {
		if (0 <= nx && nx < n && 0 <= ny && ny < m) {
			return true;
		}
		return false;
	}

	private static ArrayList<int[]> findInitVirusLocation() {
		ArrayList<int[]> virusArray = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 2) {
					virusArray.add(new int[] {i,j});
				}
			}
		}
		return virusArray;
	}

}

