package programmer.programmerLv2;
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/64065
// 튜플

public class Kakao12 {
	public int[] solution(String s) {
		s = s.substring(2, s.length() - 2); // 맨앞 {{, 맨뒤 }} 날리기
		String[] tuple = s.split("\\},\\{");

		Arrays.sort(tuple, new Comparator<String>() { // 글자수로 정렬
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		ArrayList<Integer> array = setArray(tuple);

		int[] answer = setAnswer(array);
		return answer;
	}

	public int[] setAnswer(ArrayList<Integer> array) {
		int[] answer = new int[array.size()];
		for (int i = 0; i < array.size(); i++) {
			answer[i] = array.get(i);
		}
		return answer;
	}

	public ArrayList<Integer> setArray(String[] tuple) {
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < tuple.length; i++) {
			String[] detailTuple = tuple[i].split(",");

			for (int j = 0; j < detailTuple.length; j++) {
				int temp = Integer.parseInt(detailTuple[j]);
				if (!array.contains(temp)) {
					array.add(temp);
				}
			}
		}
		return array;
	}
}