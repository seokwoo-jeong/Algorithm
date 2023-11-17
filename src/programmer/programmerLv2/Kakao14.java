package programmer.programmerLv2;

import java.util.ArrayList;
import java.util.HashMap;
//https://school.programmers.co.kr/learn/courses/30/lessons/17684
//[3차]압축
public class Kakao14 {
	public int[] solution(String msg) {
		ArrayList<Integer> array = new ArrayList<>();
		HashMap<String, Integer> map = setMap();

		int prev = 0;
		int last = 27;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < msg.length(); i++) {
			sb.append(msg.charAt(i));

			if (map.containsKey(sb.toString())) {
				// System.out.println(sb.toString() + " " + map.get(sb.toString()));
				prev = map.get(sb.toString());
			} else {
				map.put(sb.toString(), last);
				last++;
				array.add(prev);
				prev = 0;
				sb.setLength(0);
				i--;
			}

		}
		if (prev != 0) {
			array.add(prev);
		}
		int[] answer = new int[array.size()];
		for (int i = 0; i < array.size(); i++) {
			answer[i] = array.get(i);
		}

		return answer;
	}

	public HashMap<String, Integer> setMap() {
		HashMap<String, Integer> map = new HashMap<>();
		char alpha = 'A';
		for (int i = 1; i < 27; i++) {
			map.put(alpha + "", i);
			alpha += 1;

		}
		return map;
	}
}
