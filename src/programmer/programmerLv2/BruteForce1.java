package programmer.programmerLv2;
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42839
// 소수 찾기
public class BruteForce1 {
	boolean[] isVisit;
	ArrayList<Integer> duplArray;
	int answer;

	public int solution(String numbers) {
		answer = 0;
		duplArray = new ArrayList<>();
		char[] array = numbers.toCharArray();
		isVisit = new boolean[array.length];
		String val = "";
		dfs(0, array, val);

		return answer;
	}

	private void dfs(int depth, char[] array, String value) {
		if (depth == array.length) {
			return;
		}
		for (int i = 0; i < array.length; i++) {
			if (!isVisit[i]) {
				isVisit[i] = true;
				chk(value + array[i]);
				dfs(depth + 1, array, value + array[i]);
				isVisit[i] = false;
			}
		}
	}

	private void chk(String value) {
		int val = Integer.parseInt(value);

		if (isDecimal(val)) {
			if (duplArray.isEmpty() || !duplArray.contains(val)) {
				duplArray.add(val);
				//System.out.println(val);
				answer++;
			}
		}
	}
	//소수 인지 판단
	private boolean isDecimal(int value) {
		if (value < 2) {
			return false;
		}
		for (int i = 2; i < value / 2 + 1; i++) {
			if (value % i == 0) {

				return false;
			}
		}
		return true;
	}
	
}