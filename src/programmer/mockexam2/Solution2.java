package programmer.mockexam2;
import java.util.*;

public class Solution2 {
	public int solution(int[] topping) {
		int answer = 0;
		// 1. 반으로 자르기
		// 2. 왼쪽 갯수 구하기
		// 3. 오른쪽 갯수 구하기
		// 4. 둘이 같은지 확인
		// 4-1. 같으면 answer++;
		int left = 0;
		int right = 0;
		for (int i = 0; i < topping.length; i++) {
			left = getCount(0, i, topping);
			right = getCount(i + 1, topping.length - 1, topping);

			if (left == right) {
				answer++;
			}
		}
		return answer;
	}

	private int getCount(int start, int finish, int[] topping) {
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = start; i <= finish; i++) {
			if (!temp.contains(topping[i])) {
				temp.add(topping[i]);
			}
		}
		return temp.size();
	}
}
