package programmer.programmerLv3;
// https://school.programmers.co.kr/learn/courses/30/lessons/92344
// 파괴되지 않은 건물

/* 
 * 1000 * 1000 * 250,000 = 250,000,000,000
 * skill하나 읽고 건물 내구도 갱신하고, 이런식으로 하면 효율성 100% 탈락
 * 누적값을 이용
 */
public class Kakao7 {
	public int solution(int[][] board, int[][] skill) {
		int type = 0;
		int r1 = 0;
		int r2 = 0;
		int c1 = 0;
		int c2 = 0;
		int degree = 0;
		int answer = 0;
		int[][] degreeArray = new int[board.length + 1][board[0].length + 1];
		for (int i = 0; i < skill.length; i++) {
			type = skill[i][0];
			r1 = skill[i][1];
			c1 = skill[i][2];
			r2 = skill[i][3];
			c2 = skill[i][4];
			degree = skill[i][5];

			if (type == 1) {
				degreeArray[r1][c1] += -degree;
				degreeArray[r2 + 1][c1] += degree;
				degreeArray[r1][c2 + 1] += degree;
				degreeArray[r2 + 1][c2 + 1] += -degree;
			} else if (type == 2) {
				degreeArray[r1][c1] += degree;
				degreeArray[r2 + 1][c1] += -degree;
				degreeArray[r1][c2 + 1] += -degree;
				degreeArray[r2 + 1][c2 + 1] += degree;
			}

		}
		for (int i = 0; i < board.length + 1; i++) { // 가로
			int sum = 0;
			for (int j = 0; j < board[0].length + 1; j++) {
				sum += degreeArray[i][j];
				degreeArray[i][j] = sum;
			}
		}

		for (int i = 0; i < board[0].length; i++) { // 세로
			int sum = 0;
			for (int j = 0; j < board.length; j++) {
				sum += degreeArray[j][i];
				degreeArray[j][i] = sum;
			}
		}

		for (int i = 0; i < board.length; i++) { // count
			for (int j = 0; j < board[0].length; j++) {
				if (degreeArray[i][j] + board[i][j] > 0) {
					answer++;
				}
			}
		}

		return answer;
	}
}