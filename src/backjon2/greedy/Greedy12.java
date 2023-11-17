package backjon2.greedy;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2812
// 크게 만들기 (골3)

public class Greedy12 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);	// 글자 개수
		int k = Integer.parseInt(temp[1]);	// 제외 개수
		
		String temp2 = br.readLine();
		char[] array = temp2.toCharArray();
		Stack<Character> stack = new Stack<>();
		
		int count = k;
		for(int i = 0; i<n; i++) {
			if(stack.isEmpty()) {
				stack.add(array[i]);
				continue;
			}
			
			while(!stack.isEmpty() &&Character.digit(stack.peek(),10) < Character.digit(array[i],10)) {
				if(count == 0) {
					break;
				}
				stack.pop();
				count--;
			}
			stack.add(array[i]);
			
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.reverse().substring(0,n-k));
	}
	

}
