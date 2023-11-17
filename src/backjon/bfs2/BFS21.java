package backjon.bfs2;
import java.io.*;
import java.util.*;
// https://www.acmicpc.net/problem/17141
// 연구소 2

// bruteforce로 모든 바이러스위치 경우의 수 뽑고 
// bfs돌려서 최소 시간 찾기
public class BFS21 {
	private static int n;
	private static int m;
	private static int[][] matrix;
	private static boolean[][] isVisit;
	private static boolean[] isPick;
 	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	private static ArrayList<Info> virusTotalArray;
	private static int emptyRoom;
	private static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		matrix = new int[n][n];
		isVisit = new boolean[n][n];
		virusTotalArray = new ArrayList<>();
		Info[] virusArray = new Info[m];
		emptyRoom = 0;
		result = Integer.MAX_VALUE;
		for(int i = 0; i<n; i++) {	//matrix 세팅
			String[] line = br.readLine().split(" ");
			for(int j = 0; j<line.length; j++) {
				matrix[i][j] = Integer.parseInt(line[j]);
				
				if(line[j].equals("2")) {	// 0:빈칸 1: 벽 2: 바이러스
					virusTotalArray.add(new Info(i,j,0));
					emptyRoom++;
				}else if(line[j].equals("0")) {
					emptyRoom++;
				}
			}
		}
		isPick = new boolean[virusTotalArray.size()];
		pickVirus(0,0,virusArray);
		System.out.println(result);

	}
	private static void pickVirus(int depth, int before,Info[] virusArray) {
		if(depth == m) {		
			isVisit = new boolean[n][n];
			int temp = bfs(virusArray);
			if(temp == -1) {
				if(result == Integer.MAX_VALUE) {
					result = -1;
				}
			}else {
				if(result == -1) {
					result = temp;
				}else {
					result = Math.min(temp, result);
				}
			}
			return;
		}
		for(int i = before; i<virusTotalArray.size(); i++) {
			if(!isPick[i]) {
				isPick[i] = true;
				virusArray[depth] = virusTotalArray.get(i);
				pickVirus(depth+1, i, virusArray);
				isPick[i] = false;
			}
		}
		
	}
	
	private static int bfs(Info[] initVirus) {
		Queue<Info> queue = new LinkedList<>();
		int virusCount = m;
		for(int i = 0; i<m; i++) {
			queue.add(initVirus[i]);
			isVisit[initVirus[i].x][initVirus[i].y] = true;
		}
		if(virusCount == emptyRoom) {
			return 0;
		}
		while(!queue.isEmpty()) {
			Info cur = queue.poll();

			for(int i = 0; i<dx.length; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(!isGo(nx,ny) || isVisit[nx][ny] || matrix[nx][ny] == 1) {
					continue;
				}
				
				isVisit[nx][ny] = true;
				queue.add(new Info(nx,ny,cur.time+1));
				virusCount++;
				
				if(emptyRoom == virusCount) {
					return cur.time+1;
				}
			}
		}
		return -1;
	}
	
	private static boolean isGo(int x, int y) {
		if(0<= x && x <n && 0<= y && y < n) {
			return true;
		}
		return false;
	}
	
	private static class Info{
		int x;
		int y;
		int time;
		public Info(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

}
