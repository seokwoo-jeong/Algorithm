package backjon.bfs2;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/5014
// 스타트링크

public class BFS15 {
	static int f;
	static int s;
	static int g;
	static int u;
	static int d;
	static boolean[] isVisit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		String[] temp = br.readLine().split(" ");
		f = Integer.parseInt(temp[0]);
		s = Integer.parseInt(temp[1]);
		g = Integer.parseInt(temp[2]);
		u = Integer.parseInt(temp[3]);
		d = Integer.parseInt(temp[4]);
		int[] ud = {u,d};
		isVisit = new boolean[f+1];
		
		if(s==g) {
			System.out.println(0);
			System.exit(0);
		}
		answer = bfs(ud);
		
		if(answer == -1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(answer);
		}
		
	}
	private static int bfs(int[] ud) {
		Queue<int[]> queue = new LinkedList<>();	//현재층, count
		queue.add(new int[] {s,0});
		isVisit[s] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curStair = cur[0];
			
			for(int i =0; i<ud.length; i++) {
				int newStair = 0;
				if(i==0) {
					newStair = curStair + ud[i];
				}else {
					newStair = curStair - ud[i];
				}
				
				if(newStair > f || newStair < 1) {	//이동한 층이 건물 층을 넘어간 경우 
					continue;
				}
				
				if(isVisit[newStair]) {	//이미 방문한 적이 있는 경우
					continue;
				}
				
				if(newStair == g) {	//도착한 경우
					return cur[1] + 1;
				}
				
				queue.add(new int[] {newStair, cur[1]+1});
				isVisit[newStair] = true;
			}
		}
		
		
		return -1;
	}

}
