package programmer.programmerLv2;

// https://school.programmers.co.kr/learn/courses/30/lessons/17679
// [1차] 프렌즈4블록
public class Kakao9 {
	private boolean[][] isVisit;
	private int answer;

	public int solution(int m, int n, String[] board) {
		char[][] matrix = new char[m][n];
		isVisit = new boolean[m][n];
		answer = 0;
		matrix = makeMatrix(m, n, board);

		while (true) {
			if (!isBomb(m, n, matrix)) {
				break;
			}

			matrix = bombMatrix(m, n, matrix);
			matrix = sortMatrix(m, n, matrix);
			isVisit = new boolean[m][n];
			
			/*
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			*/
		}
		return answer;
	}

	private char[][] sortMatrix(int m, int n, char[][] matrix) {		//터진 후 내리기
		char[][] temp = matrix;
		for (int i = m - 1; i >= 1; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (temp[i][j] == '0') {
					int x = i;
					while (true) {
						x--;
						if (isOut(x, j, m, n)) {
							break;
						}
						if (temp[x][j] != '0') {
							temp[i][j] = temp[x][j];
							temp[x][j] = '0';
							break;
						}
					}
				}
			}
		}
		return temp;
	}

	private boolean isOut(int x, int y, int m, int n) {
		if (0 <= x && x < m && 0 <= y && y < n) {
			return false;
		}
		return true;
	}

	private boolean isBomb(int m, int n, char[][] matrix) {
		boolean flag = false;
		int[] dx = { 0, 0, 1, 1 };
		int[] dy = { 0, 1, 0, 1 };
		int count = 0; // 4개 되면 2*2 충족된것임
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				count = 0;
				for (int z = 0; z < dx.length; z++) {
					int nx = dx[z] + i;
					int ny = dy[z] + j;
					if (isOut(nx, ny, m, n)) {
						break;
					}
					if (matrix[nx][ny] == '0') {
						break;
					}
					if (matrix[i][j] == matrix[nx][ny]) {
						count++;

					} else {
						break;
					}
				}
				if (count == 4) {
					flag = true;
					for (int z = 0; z < dx.length; z++) {
						isVisit[i + dx[z]][j + dy[z]] = true;
					}
				}
			}
		}
		return flag;
	}

	private char[][] bombMatrix(int m, int n, char[][] matrix) {
		char[][] temp = matrix;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (isVisit[i][j]) {
					temp[i][j] = '0';
					answer++;
				}
			}
		}
		return temp;
	}

	private char[][] makeMatrix(int m, int n, String[] board) {
		char[][] matrix = new char[m][n];
		for (int i = 0; i < m; i++) {
			char[] temp = board[i].toCharArray();
			for (int j = 0; j < n; j++) {
				matrix[i][j] = temp[j];
			}
		}
		return matrix;
	}
}