package programmer.programmerLv2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/72412
// 순위 검색
public class Kakao11 {
	ArrayList<String[]> userArray;

	public int[] solution(String[] info, String[] query) {
		userArray = setUserArray(info);
		int[] answer = new int[query.length];

		for (int i = 0; i < query.length; i++) {
			answer[i] = getCount(query[i]);
		}
		return answer;
	}

	public int getCount(String query) {
		int count = 0;
		String[] conditionArray = query.split(" and | ");
		boolean flag = false;
		for (int i = 0; i < userArray.size(); i++) {
			String[] currentUser = userArray.get(i);
			for (int j = 0; j < conditionArray.length; j++) {
				if (j == 4) { // 여기까지 온거면 전 조건은 모두 만족한 것
					if (Integer.parseInt(currentUser[j]) >= Integer.parseInt(conditionArray[j])) {
						count++;
						break;
					}
				}
				if (conditionArray[j].equals("-")) {
					continue;
				}
				if (!currentUser[j].equals(conditionArray[j])) {
					break;
				}

			}
		}
		return count;
	}

	public ArrayList<String[]> setUserArray(String[] info) {
		ArrayList<String[]> temp = new ArrayList<>();
		for (int i = 0; i < info.length; i++) {
			String[] temp2 = info[i].split(" ");
			temp.add(temp2);
		}
		return temp;
	}

}
