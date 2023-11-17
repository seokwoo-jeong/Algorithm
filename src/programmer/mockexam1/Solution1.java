package programmer.mockexam1;

import java.util.*;

public class Solution1 {
	public String solution(String X, String Y) {
		PriorityQueue<Character> partnerArray = new PriorityQueue<>(Collections.reverseOrder());

		char[] xArray = X.toCharArray();
		char[] yArray = Y.toCharArray();

		for (int i = 0; i < xArray.length; i++) {
			for (int j = 0; j < yArray.length; j++) {
				if (xArray[i] == yArray[j]) {
					partnerArray.add(xArray[i]);
					yArray[j] = '*';
					break;
				}
			}
		}
		if (partnerArray.isEmpty()) { // 동일한거 하나도 없는 경우
			return "-1";
		}

		if (partnerArray.peek() == '0') { // 가장 큰 값이 0인 경우
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		while (!partnerArray.isEmpty()) {
			sb.append(partnerArray.poll());
		}

		return sb.toString();
	}

}