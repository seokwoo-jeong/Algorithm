package programmer.mockexam1;

public class Solution2 {
	int[] possible;

	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		int start = 0;
		int count = 0; // count가 10이면 stop
		possible = new int[want.length];
		while (start < discount.length) {
			for (int i = start; i < discount.length; i++) {
				if (count == 10) { // 10일 다 봤으면 break
					break;
				}
				count++;
				chkWant(want, discount[i]); // 할인 품목인지 확인하고 개수 올리기
			}

			start++;
			if (isGood(number)) { // 조건 맞으면 answer++
				answer++;
			}
			possible = new int[want.length]; // 초기화
			count = 0;
		}
		return answer;
	}

	private void chkWant(String[] want, String discount) {
		for (int i = 0; i < want.length; i++) {
			if (want[i].equals(discount)) {
				possible[i] = possible[i] + 1;
				break;
			}
		}
	}

	private boolean isGood(int[] number) {
		boolean flag = true;
		for (int i = 0; i < number.length; i++) {
			if (number[i] > possible[i]) {
				flag = false;
				break;
			}
		}
		return flag;
	}

}