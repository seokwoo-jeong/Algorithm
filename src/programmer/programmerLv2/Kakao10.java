package programmer.programmerLv2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/17677
// [1차] 뉴스 클러스터링

public class Kakao10 {
	public int solution(String str1, String str2) {
		int no = 65536;
		// 2글자씩 끊어서 array에 저장(upper, 특수문자제거하고)
		LinkedList<String> array1 = makeArray(str1);
		LinkedList<String> array2 = makeArray(str2);

		Info info = getNum(array1, array2);
		int answer = 0;

		if ((info.a == 0 && info.b == 0) || info.b == 0) {
			return no;
		} else if (info.a == 0) {
			return answer;
		} else {
			float temp = (float) info.a / (float) info.b;
			temp = temp * no;
			answer = (int) temp;
		}
		return answer;
	}

	private class Info {
		int a; // 합
		int b; // 교

		public Info() {
			this.a = 0;
			this.b = 0;
		}
	}

	// str1문자가 str2에 있을때마다 str2의 문자를 제거하고 합집합++, 교집합++
	// 문자가 없으면 str2제거안하고 합집합++
	// str2 남은개수만큼 합집합+
	private Info getNum(LinkedList<String> array1, LinkedList<String> array2) {
		Info info = new Info();

		for (int i = 0; i < array1.size(); i++) {
			if (array2.contains(array1.get(i))) {
				info.a++;
				info.b++;
				array2.remove(array1.get(i));
			} else {
				info.b++;
			}
		}
		if (!array2.isEmpty()) {
			info.b += array2.size();
		}
		return info;
	}

	private LinkedList<String> makeArray(String str) {
		LinkedList<String> array = new LinkedList<>();
		char[] temp = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		int index = 0;

		while (index < temp.length) {
			if (isAlpha(temp[index])) {
				sb.append(Character.toUpperCase(temp[index]));
			} else {
				sb.delete(0, 2);
			}

			if (sb.length() == 2) {
				array.add(sb.toString());
				sb.delete(0, 2);
			} else {
				index++;
			}

		}
		return array;
	}

	private boolean isAlpha(char ch) {
		if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) {
			return true;
		}
		return false;
	}
}