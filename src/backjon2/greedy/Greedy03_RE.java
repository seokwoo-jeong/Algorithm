package backjon2.greedy;

import java.io.*;

// https://www.acmicpc.net/problem/1541
// 읽어버린 괄호 (실2)

public class Greedy03_RE {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] array = br.readLine().split("-");
		
		int result = 0;
		for(int i = 0; i<array.length; i++) {
			if(i == 0) {
				result += sum(array[i]);
			}else {
				result -= sum(array[i]);
			}
		}
		System.out.println(result);
	}
	
	private static int sum(String op) {
		String[] temp = op.split("\\+");
		int value = 0;
		for(String t : temp) {
			value += Integer.parseInt(t);
		}
		
		return value;
	}
}
