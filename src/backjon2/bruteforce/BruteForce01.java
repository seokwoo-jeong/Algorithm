package backjon2.bruteforce;

import java.io.*;

// https://www.acmicpc.net/problem/12919
// A와 B2 (골5)

public class BruteForce01 {

	private static String sb1;
	private static String sb2;
	private static boolean isSame;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb1 = br.readLine();
		sb2 = br.readLine();
		isSame = false;

		dfs(sb2);
		
		if(isSame) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	
	private static void dfs(String str) {
		if(str.length() < sb1.length()) {
			return;
		}
		
		if(str.equals(sb1.toString())) {
			isSame = true;
			return;
		}
		if(isSame) {
			return;
		}
		
		if(str.charAt(0) == 'B') {
			StringBuilder sb = new StringBuilder();
			sb.append(str.substring(1,str.length()));
			sb.reverse();
			dfs(sb.toString());
		}

		if(str.charAt(str.length()-1) == 'A') {
			dfs(str.substring(0,str.length()-1));
		}
	}

}
