package backjon.bfs2;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1963
// 소수 경로

public class BFS12 {
	public static boolean isVisit[]; //1000~9999
	public static void main(String[] args) throws IOException{
		isVisit = new boolean[9000];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i<t; i++) {
			String[] temp = br.readLine().split(" ");
			if(temp[0].equals(temp[1])) {
				System.out.println(0);
			}else {
				if(!bfs(temp[0], temp[1])) {
					System.out.println("Impossible");
				}
			}
			isVisit = new boolean[9000];
		}
	}
	
	private static boolean bfs(String start , String finish) {
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(start,0));
		isVisit[Integer.parseInt(start)- 1000] = true;
		while(!queue.isEmpty()) {
			Info cur = queue.poll();
			for(int i = 0; i<4; i++) {	//자리수
				StringBuilder curNum = new StringBuilder(cur.num);
				for(int j = 0; j<10; j++) {	//0~9
					String newNum = curNum.replace(i, i+1, String.valueOf(j)).toString();
					int newNumInt = Integer.parseInt(newNum);
					if(!isFour(newNumInt) || !isDecimal(newNumInt)) {
						continue;
					}
					if(isVisit[newNumInt-1000]) {
						continue;
					}
					if(newNumInt == Integer.parseInt(finish)) {
						System.out.println(cur.count+1);
						return true;
					}
					isVisit[newNumInt-1000] = true;
					queue.add(new Info(newNum, cur.count+1));
				}
			}
		}
		return false;
	}
	private static class Info{
		String num;
		int count;
		public Info(String num, int count) {
			this.num = num;
			this.count = count;
		}
	}
	
	private static boolean isDecimal(int decimal) {
		for(int i = 2; i<=(int)Math.sqrt(decimal); i++) {
			if(decimal % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isFour(int decimal) {
		if(decimal >= 1000) {
			return true;
		}
		return false;
	}
}
