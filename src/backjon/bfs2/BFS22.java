package backjon.bfs2;
import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/17142
// 연구소3
public class BFS22 {
	private static int n;
	private static int m;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	private static int[][] matrix;
	private static boolean[][] isVisit;
	private static ArrayList<Info> virusArray;
	private static boolean[] isPick;
	private static Info[] virusPickArray;
	private static int stop;
	private static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		matrix = new int[n][n];
		isVisit = new boolean[n][n];
		virusArray = new ArrayList<>();
		virusPickArray = new Info[m];
		stop = 0;
		result = Integer.MAX_VALUE;
		for(int i = 0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j<line.length; j++) {
				matrix[i][j] = Integer.parseInt(line[j]);
				if(line[j].equals("2")) {
					virusArray.add(new Info(i,j,0));
					
				}else if(line[j].equals("0")) {
					stop++;
				}
			}
		}
		if(stop == 0) {
			System.out.println(stop);
			System.exit(0);
		}
		isPick = new boolean[virusArray.size()];
		pickVirus(0,0);
		System.out.println(result);
	}
	private static int bfs() {
		int count = 0;
		Queue<Info> queue = new LinkedList<>();
		for(int i = 0; i<m; i++) {
			queue.add(virusPickArray[i]);
			isVisit[virusPickArray[i].x][virusPickArray[i].y] = true;
		}
		while(!queue.isEmpty()) {
			Info cur = queue.poll();
			
			for(int i = 0; i<dx.length; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(!isGo(nx,ny) || isVisit[nx][ny]) {	//못가거나 이미 방문한 경우
					continue;
				}
				if(matrix[nx][ny] == 1) {	//벽을 만난경우
					continue;
				}else if(matrix[nx][ny] == 0) {
					count++;
				}
				if(count == stop) {
					return cur.count+1;
				}
				queue.add(new Info(nx,ny,cur.count+1));
				isVisit[nx][ny] = true;
			}
		}
		
		return -1;
	}
	private static boolean isGo(int x, int y) {
		if(0<= x && x<n && 0<=y && y<n) {
			return true;
		}
		return false;
	}
	
	private static void pickVirus(int depth, int before) {
		if(depth == m) {
			isVisit = new boolean[n][n];
			int temp = bfs();
			if(temp != -1) {
				if(result == -1) {
					result = temp;
				}else {
					result = Math.min(result, temp);
				}
			}else {
				if(result == Integer.MAX_VALUE) {
					result = temp;
				}
			}
			return;
		}
		for(int i = before; i<virusArray.size(); i++) {
			if(!isPick[i]) {
				isPick[i] = true;
				virusPickArray[depth] = virusArray.get(i);
				pickVirus(depth+1,i);
				isPick[i] = false;
			}
		}
		
	}
	private static class Info{
		int x;
		int y;
		int count;
		public Info(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

}
