package backjon2.greedy;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/1343
//폴리오미노 (실5)

public class Greedy01_RE {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] array = br.readLine().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		int index = 0;
		int count = 0;
		boolean flag = true;
		while(index < array.length) {
			if(array[index] == 'X') {
				count++;
			}else {
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
			if(count == 4) {
				sb.append("AAAA");
				count = 0;
			}
			index++;
		}
		
		if(count == 4) {
			sb.append("AAAA");
		}else if(count==2){
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
