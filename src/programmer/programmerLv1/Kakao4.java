package programmer.programmerLv1;

import java.util.Stack;

// ũ���� �����̱� ����(Lv1)
// https://programmers.co.kr/learn/courses/30/lessons/64061

/*
 * board = {0,0,0,0,0}
 *		   {0,0,1,0,3}
 *		   {0,2,5,0,1}
 *		   {4,2,4,4,2}
 *		   {3,5,1,3,1}
 *
 * moves = {1,5,3,5,1,2,1,4};
 */
public class Kakao4 {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		int moveIndex = 0;
		Stack<Integer> stack = new Stack<>();
		boolean flag = false;

		for (int move : moves) {
			moveIndex = move - 1; // �ε����� ��ȯ
			for (int i = 0; i < board.length; i++) {
				flag = false;
				if (board[i][moveIndex] != 0) { // moves���� ���� �ڸ����� 0�̾ƴ� ���� ������ ��ȣ �̱�
					stack.add(board[i][moveIndex]); // ������ ��� �迭�� ������ �־��ֱ�
					board[i][moveIndex] = 0; // �̾����ϱ� 0 ���� �ٲ��ֱ�
					flag = true;
					break;
				}
			}
			
			if (flag && stack.size() > 1) { // �迭�� ����, �迭 ����� 1�ʰ��� ��� ���� ����� �������� Ȯ���ϰ�
				if (stack.get(stack.size() - 1) == stack.get(stack.size() - 2)) { // ���� ����� ������ ��� pop
					stack.pop();
					stack.pop();
					answer = answer + 2;
				}
			}
		}
		return answer;
	}
}
