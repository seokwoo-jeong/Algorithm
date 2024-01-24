package backjon2.bruteforce;

import java.io.*;
import java.util.HashSet;

// https://www.acmicpc.net/problem/12919
// A와 B2 (골5)

public class BruteForce01_RE {
	
	private static boolean flag = false;
	private static HashSet<String> hash;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();
		
		hash = new HashSet<>();
		sb = new StringBuilder();
		hash.add(t);
		dfs(t,s);
		
		if(flag) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	
	private static void dfs(String cur, String end) {
		if(cur.length() < end.length()) {
			return;
		}
		
		if(flag) {
			return;
		}
		
		if(cur.length() == end.length()) {
			if(cur.equals(end)) {
				flag = true;
			}
			return;
		}
		
		if(cur.charAt(0) == 'B') {
			String next = sb.replace(0, sb.length(), cur).deleteCharAt(0).reverse().toString();
			if(!hash.contains(next)) {
				hash.add(next);
				dfs(next,end);
			}
		}
		
		if(cur.charAt(cur.length()-1)== 'A') {
			String next = sb.replace(0, sb.length(), cur).deleteCharAt(sb.length()-1).toString();
			if(!hash.contains(next)) {
				hash.add(next);
				dfs(next,end);
			}
		}
	}
}
