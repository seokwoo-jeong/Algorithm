package backjon2.greedy;

import java.io.*;

// https://www.acmicpc.net/problem/1343
// 폴리오미노 (실5)

public class Greedy01 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] array = br.readLine().toCharArray();
		
		
		StringBuilder sb = new StringBuilder();
		
		int count = 0;
		boolean flag = true;
		for(char word :  array) {
			if(word == 'X') {
				count++;
			}
			
			if(count == 4) {
				sb.append("AAAA");
				count = 0;
			}
			
			if(word == '.') {
				if(count == 2) {
					sb.append("BB");
					count = 0;
					
				}
				if(count != 0) {
					flag = false;
					break;
				}
				
				sb.append('.');
			}
		}
		
		if(count == 4) {
			sb.append("AAAA");
		}else if(count == 2) {
			sb.append("BB");
		}else if(count != 0) {
			flag = false;
		}
		
		if(flag) {
			System.out.println(sb.toString());
		}else {
			System.out.println(-1);
		}
		

	}

}
