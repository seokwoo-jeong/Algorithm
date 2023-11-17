package backjon2.bfs;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/14867
// 물통 (골2)

public class BFS11 {
	
	private static int a;
	private static int b;
	private static int c;
	private static int d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		a = Integer.parseInt(temp[0]);
		b = Integer.parseInt(temp[1]);
		c = Integer.parseInt(temp[2]);
		d = Integer.parseInt(temp[3]);
		boolean flag = bfs();
		if(!flag) {
			System.out.println(-1);
		}
	}
	
	private static boolean bfs() {
		Queue<int[]> queue = new LinkedList<>();
		HashSet<String> hash = new HashSet<>();
		hash.add("0 0");
		
		queue.add(new int[] {0,0,0});	//현재x, 현재y, count
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int curX = cur[0];
			int curY = cur[1];
			int curCount = cur[2];
			
			if(curX == c && curY == d) {
				System.out.println(curCount);
				return true;
			}
			
			int newX = 0;
			int newY = 0;
			int[] move = null;
			
			newX = a;
			addQueue(newX, curY, curCount, queue, hash);	// a 물통 채우기
			
			newY = b;
			addQueue(curX, newY, curCount, queue, hash);	// b 물통 채우기
			
			newX = 0;
			addQueue(newX, curY, curCount, queue, hash);	// a 물통 비우기
			
			newY = 0;
			addQueue(curX, newY, curCount, queue, hash);	// b 물통 비우기
			
			move = move(curX,curY,a,b);						// a -> b 물통 붓기
			newX = move[0];
			newY = move[1];
			addQueue(newX, newY, curCount, queue, hash);
			
			move = move(curY,curX,b,a);						// b -> a 물통 붓기
			newY = move[0];
			newX = move[1];
			addQueue(newX, newY, curCount, queue, hash);
		}
		return false;
	}

	private static int[] move(int x, int y, int maxX, int maxY) {
		int poll = maxY - y;
		int newX = x;
		int newY = y;
		
		if(newX >= poll) {
			newX -= poll;
			newY = maxY;
		}else {
			newY += newX;
			newX = 0;
		}
		return new int[] {newX,newY};
	}

	private static void addQueue(int x, int y, int curCount, Queue<int[]> queue, HashSet<String> hash) {
		String value = String.valueOf(x) + " " + String.valueOf(y);
		
		if(hash.contains(value)) {
			return;
		}
		hash.add(value);
		queue.add(new int[] {x,y,curCount+1});
	}

}
