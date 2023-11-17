package programmer.programmerLv1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
// https://programmers.co.kr/learn/courses/30/lessons/77484
// 로또의 최고 순위와 최저 순위
public class Kakao1 {

	public int[] solution(int[] lottos, int[] win_nums) {
		int worstCount = 0;
		int bestCount = 0;
		List<Integer> winList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

		for (int a : lottos) {
			if (winList.contains(a)) {
				worstCount++;
			}
			if (a == 0) {
				bestCount++;
			}

		}
		worstCount = 7 - worstCount;
		bestCount = worstCount - bestCount;
		if (worstCount == 7) {
			worstCount = 6;
		}
		if (bestCount == 7) {
			bestCount = 6;
		}

		int[] answer = { bestCount, worstCount };
		return answer;
	}

}
