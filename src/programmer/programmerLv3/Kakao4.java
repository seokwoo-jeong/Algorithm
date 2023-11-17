package programmer.programmerLv3;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/67258
// 보석 쇼핑
public class Kakao4 {
	public int[] solution(String[] gems) {
		HashSet<String> hashSet = new HashSet<>();
		HashMap<String, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < gems.length; i++) {
			hashSet.add(gems[i]);
		}
		int start = 0;
		int finish = 0;
		int distance = Integer.MAX_VALUE;
		int[] answer = new int[2];
		while (true) {
			if (start == gems.length) {
				break;
			}
			if (hashSet.size() == hashMap.size()) {// 배열에 모든 보석이 있는 경우
				if (distance > finish - start) { // 거리 구해서 min값 저장하기
					distance = finish - start;
					answer[0] = start + 1;
					answer[1] = finish;
				}

				if (hashMap.get(gems[start]) > 1) { // start에 위치하는 보석이 1개 초과인 경우
					// 보석 갯수 한개 줄이고 start하나 오른쪽으로 옮기기
					hashMap.put(gems[start], hashMap.get(gems[start]) - 1);
					start++;

				} else { // start에 위치하는 보석이 1개인 경우
					// 해당 보석 map에서 제거하고 start 오른쪽으로 옮기기
					hashMap.remove(gems[start]);
					start++;
				}

			} else { // 배열에 보석이 전부 없는 경우
				if (finish < gems.length) {
					// 해당 보석의  map 개수 +1 해주고 finish 하나 오른쪽으로 옮기기
					if (!hashMap.keySet().contains(gems[finish])) {
						hashMap.put(gems[finish], 1);

					} else {
						hashMap.put(gems[finish], hashMap.get(gems[finish]) + 1);
					}
					finish++;
				} else {
					break;
				}
				
			}
		}
		return answer;
	}
}