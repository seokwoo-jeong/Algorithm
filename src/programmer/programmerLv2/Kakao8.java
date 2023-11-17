package programmer.programmerLv2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/67257
// 수식 최대화

public class Kakao8 {
	private long answer;
	private char[] expArray = { '*', '+', '-' };
	private boolean[] isVisit;
	private char[] array;
	private Info info;

	// dfs로 expression의 모든 경우의 수를 뽑고
	// 각 경우의수를 가지고 계산해서 결과와 비교
	public long solution(String expression) {
		answer = Integer.MIN_VALUE;
		array = expression.toCharArray();
		isVisit = new boolean[expArray.length];
		char[] priority = new char[expArray.length];
		info = splitExpression();
		dfs(0, priority);

		return answer;
	}

	public void dfs(int depth, char[] priority) {
		if (depth == priority.length) {
			cal(priority);
			/*
			 * for(int i = 0; i<priority.length; i++){ System.out.print(priority[i] + " ");
			 * } System.out.println();
			 */
			return;
		}
		for (int i = 0; i < expArray.length; i++) {
			if (!isVisit[i]) {
				isVisit[i] = true;
				priority[depth] = expArray[i];
				dfs(depth + 1, priority);
				isVisit[i] = false;
			}
		}
	}

	public void cal(char[] priority) {
		LinkedList<Character> tempOperation = new LinkedList<>(info.operation); // - + - *
		LinkedList<Long> tempOperand = new LinkedList<>(info.operand); // 100 200 300 500 100
		int index = 0;
		for (int i = 0; i < priority.length; i++) {
			index = 0;
			while (index < tempOperation.size()) {
				if (tempOperation.get(index) == priority[i]) {
					tempOperand.set(index, realCal(tempOperand.get(index), tempOperand.get(index + 1), priority[i]));
					tempOperand.remove(index + 1);
					tempOperation.remove(index);
				} else {
					index++;
				}
				/*
				 * for(long a : tempOperand){ System.out.print(a + " "); } System.out.println();
				 */
			}
		}
		answer = Math.max(answer, Math.abs(tempOperand.get(0)));
	}

	public long realCal(long num1, long num2, char op) {
		switch (op) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		default:
			return 0;
		}
	}

	public class Info {
		LinkedList<Character> operation; // 연산자
		LinkedList<Long> operand; // 숫자

		public Info(LinkedList<Character> operation, LinkedList<Long> operand) {
			this.operation = operation;
			this.operand = operand;
		}
	}

	public Info splitExpression() {
		char[] temp = array;
		LinkedList<Character> operation = new LinkedList<>(); // 연산자
		LinkedList<Long> operand = new LinkedList<>(); // 숫자
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == '+' || temp[i] == '-' || temp[i] == '*') {
				operation.add(temp[i]);
				operand.add(Long.valueOf(sb.toString()));
				sb.delete(0, sb.length());
			} else {
				sb.append(temp[i]);
			}
		}
		operand.add(Long.valueOf(sb.toString()));
		Info info = new Info(operation, operand);
		return info;
	}
}
