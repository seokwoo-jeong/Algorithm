package backjon2.greedy;

import java.io.*;

// https://www.acmicpc.net/problem/1541
// 읽어버린 괄호 (실2)

public class Greedy03 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] array = br.readLine().split("-");
		
		int index = 0;
		int result = 0;
		
		if(array.length == 1) {
			result = cal(array[0]);
			System.out.println(result);
			return;
		}
		
		for(String pick : array) {
			if(index == 0) {
				if(pick.contains("+")) {
					result += cal(pick);
				}else if(!pick.equals("")) {
					result += Integer.parseInt(pick);
				}
				index++;
				continue;
			}
			result -= cal(pick);
		}
		
		System.out.println(result);
	}

	private static int cal(String formula) {
		int sum = 0;
		String[] temp = formula.split("\\+");
		
		for(String value : temp) {
			sum += Integer.parseInt(value);
		}
		return sum;
	}
}
