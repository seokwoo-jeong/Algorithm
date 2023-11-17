package backjon.bfs2;
import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/14395
// 4연산
public class BFS14 {
	static ArrayList<Long> isVisit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		isVisit = new ArrayList<>();
		String[] temp = br.readLine().split(" ");
		int s = Integer.parseInt(temp[0]);
		int t = Integer.parseInt(temp[1]);
		
		String answer = "";
		
		if(s == t) {
			System.out.println(0);
			System.exit(0);
		}
		answer = bfs(s,t);
		System.out.println(answer);


	}
	
	private static String bfs(long start, long finish) {
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(start,""));
		isVisit.add(start);
		while(!queue.isEmpty()) {
			Info cur = queue.poll();
			long newNo = 0;
			for(int i = 0; i<4; i++) {
				if(i==0) {	//*
					newNo = cur.no * cur.no;
					
					if(newNo == finish) {
						return cur.operand + "*";
					}
					
					if(!isVisit.contains(newNo)){
						queue.add(new Info(newNo, cur.operand + "*"));
						isVisit.add(newNo);
					}
				}else if(i==1) {//+
					newNo = cur.no + cur.no;
					
					if(newNo == finish) {
						return cur.operand + "+";
					}
					
					if(!isVisit.contains(newNo)) {
						queue.add(new Info(newNo, cur.operand + "+"));
						isVisit.add(newNo);
					}
				}else if(i==2) {//-
					newNo = cur.no - cur.no;
					
					if(newNo == finish) {
						return cur.operand + "-";
					}
					
					if(!isVisit.contains(newNo)) {
						queue.add(new Info(newNo, cur.operand + "-"));
						isVisit.add(newNo);
					}
				}else {// /
					if(cur.no != 0) {
						newNo = cur.no / cur.no;
						
						if(newNo == finish) {
							return cur.operand + "/";
						}
						
						if(!isVisit.contains(newNo)) {
							queue.add(new Info(newNo, cur.operand + "/"));
							isVisit.add(newNo);
						}
					}
				}
			}
			
		}
		return "-1";
	}
	
	private static class Info{
		String operand;
		long no;
		public Info(long no, String operand) {
			this.operand = operand;
			this.no = no;
		}
	}

}
