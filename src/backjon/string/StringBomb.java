package backjon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// ���ڿ� ����(gold4)
// https://www.acmicpc.net/problem/9935
// ������ �̿��� ����Ǯ��
public class StringBomb {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String bomb = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < origin.length(); i++) {
			stack.add(origin.charAt(i));
			
			if(bomb.length() <= stack.size()) {
				boolean flag = true;
				
				for(int z = 0; z<bomb.length(); z++) {
					if(stack.get(stack.size()-bomb.length()+z) != bomb.charAt(z)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int k = 0; k<bomb.length(); k++) {
						stack.pop();
					}
					
				}
			}
		}
		
		for(char cha : stack) {
			result.append(cha);
		}
		System.out.println(result.length() > 0 ? result:"FRULA");


	}

}
