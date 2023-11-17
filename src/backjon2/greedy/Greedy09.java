package backjon2.greedy;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1863
// 스카이라인 쉬운거 (골5)
public class Greedy09 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] array = new int[n];
		
		String[] temp = null;
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			array[i] = Integer.parseInt(temp[1]);
		}
		
		
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		for(int y : array) {
			if(y == 0) {
				result += stack.size();
				stack.clear();
				continue;
			}
			
			if(stack.isEmpty()) {
				stack.add(y);
			}else {
				if(stack.peek() < y) {
					stack.push(y);
				}else {
					while(!stack.isEmpty() && stack.peek() > y) {
						stack.pop();
						result++;
					}
					
					if(stack.isEmpty()) {
						stack.add(y);
						continue;
					}
					if(stack.peek() < y) {
						stack.add(y);
					}
				}
			}
		}
		result += stack.size();
		System.out.println(result);
	}
	

}
