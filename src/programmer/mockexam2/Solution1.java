package programmer.mockexam2;

public class Solution1 {
	int[] array = new int[3];
	int answer = 0;
	boolean[] isVisit;

	public int solution(int[] number) {
		isVisit = new boolean[number.length];
		dfs(0, array, number, 0);
		return answer;
	}

	private void dfs(int depth, int[] array, int[] number, int curr) {
		if (depth == 3) {
			int sum = 0;
			for (int r : array) {
				sum += r;
			}
			if (sum == 0) {
				answer++;
				/*
				 * for(int r:array){ System.out.print(r + " "); } System.out.println();
				 */
			}
			return;
		}
		for (int i = curr; i < number.length; i++) {
			if (!isVisit[i]) {
				isVisit[i] = true;
				array[depth] = number[i];
				dfs(depth + 1, array, number, i);
				isVisit[i] = false;
			}
		}
	}
}
