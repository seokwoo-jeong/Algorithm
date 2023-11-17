package backjon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1107
//  리모컨

public class BruteForce4 {
	public static final int Default = 100;
	static int[] breakNumList;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String readLine = in.readLine();
		int n = Integer.parseInt(readLine);
		
		int m = Integer.parseInt(in.readLine());
		if (m != 0) {		//고장난 버튼이 없는 경우, 한번 처리해주어야 함
			String breakNum = in.readLine();
			breakNumList = new int[m];
			for(int i = 0; i<breakNum.split(" ").length; i++) {
				breakNumList[i] = Integer.parseInt(breakNum.split(" ")[i]);
			}
		}else {
			breakNumList = new int[0];
		}

		
		solution(n,m);
	}

	private static void solution(int n, int m) {
		int min = Math.abs(Default - n); //숫자 이용안하고 이동한 경우
		int count = 0;
		for(int i = 0; i<=999999; i++) {		// 0번 눌렀을 경우부터 999999눌렀을 경우까지 모두 확인
			if(!isExist(String.valueOf(i))) {
				count = String.valueOf(i).length() + Math.abs(n-i);
				min = Math.min(count, min);
			}
			
		}
		System.out.println(min);
		
	}

	private static boolean isExist(String num) {
		boolean flag = false;
		char[] numList = num.toCharArray();
		for(int breakNum: breakNumList) {
			for(char nums : numList) {
				if(breakNum == Character.getNumericValue(nums)) {
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		return flag;
	}

	
}
