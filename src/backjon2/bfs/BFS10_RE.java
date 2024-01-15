package backjon2.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/9019
// DSLR (골4)

public class BFS10_RE {

	private static boolean isVisit[];
	private static int size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		String[] temp = null;
		int index = 0;
		int a = 0;
		int b = 0;
		size = 10000;
		StringBuilder result = new StringBuilder();
		while(index < t) {
			temp = br.readLine().split(" ");
			a = Integer.parseInt(temp[0]);
			b = Integer.parseInt(temp[1]);
			isVisit = new boolean[size];
			
			result.append(bfs(a,b)+"\n");
			index ++;
		}
		System.out.println(result.toString());
	}
	
	private static String bfs(int a, int b) {
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(a,""));
		isVisit[a] = true;
		
		while(!queue.isEmpty()) {
			Info cur = queue.poll();
			
			int curNum = cur.getNum();
			String curValue = cur.getValue();
			
			if(curNum == b) {
				return curValue;
			}
			
			addD(cur,queue);
			addS(cur,queue);
			addL(cur,queue);
			addR(cur,queue);
			
		}
		return null;
		
	}
	
	private static void addR(Info info, Queue<Info> queue) {
		String temp = String.valueOf(info.getNum());
		StringBuilder sb = new StringBuilder(temp);
		
		int length = sb.length();
		for(int i = length; i<4; i++) {
			sb.insert(0, '0');
		}
		sb.insert(0, sb.charAt(sb.length()-1));
		sb.deleteCharAt(sb.length()-1);
		
		int n = Integer.parseInt(sb.toString());
		if(isVisitNum(n)) {
			return;
		}
		Info newInfo = new Info(n, info.getValue() + "R");
		addQueue(newInfo,queue);
	}

	private static void addL(Info info, Queue<Info> queue) {
		String temp = String.valueOf(info.getNum());
		StringBuilder sb = new StringBuilder(temp);
		
		int length = sb.length();
		for(int i = length; i<4; i++) {
			sb.insert(0, '0');
		}
		
		sb.append(sb.charAt(0));
		sb.deleteCharAt(0);
		
		int n = Integer.parseInt(sb.toString());
		
		if(isVisitNum(n)) {
			return;
		}
		Info newInfo = new Info(n, info.getValue() + "L");
		addQueue(newInfo,queue);
	}

	private static void addS(Info info, Queue<Info> queue) {
		int n = info.getNum() -1;
		if(n == -1) {
			n = size-1;
		}
		if(isVisitNum(n)) {
			return;
		}
		Info newInfo = new Info(n, info.getValue() + "S");
		addQueue(newInfo,queue);
		
	}

	private static void addD(Info info, Queue<Info> queue) {
		int n = info.getNum() * 2;
		if(n >= size) {
			n = n % size;
		}
		if(isVisitNum(n)) {
			return;
		}
		Info newInfo = new Info(n, info.getValue()+"D");
		addQueue(newInfo,queue);
		
	}
	
	private static boolean isVisitNum(int n) {
		if(isVisit[n]) {
			return true;
		}
		return false;
	}
	
	private static void addQueue(Info info, Queue<Info> queue) {
		isVisit[info.num] = true;
		queue.add(info);
	}

	private static class Info{
		private int num;
		private String value;
		public Info(int num, String value) {
			this.num = num;
			this.value = value;
		}
		public int getNum() {
			return num;
		}

		public String getValue() {
			return value;
		}
		
	}

}
