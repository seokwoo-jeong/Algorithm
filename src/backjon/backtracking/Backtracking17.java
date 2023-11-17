package backjon.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/15661
//링크와 스타트
public class Backtracking17 {
	static int[][] matrix;
	static boolean[] isPick;
	static int n;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		isPick = new boolean[n];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			String[] def = br.readLine().split(" ");
			for (int j = 0; j < def.length; j++) {
				matrix[i][j] = Integer.parseInt(def[j]);
			}
		}

		dfs(0, 0);
		System.out.println(min);

	}

	private static void dfs(int depth, int start) {
		if (depth != n) {
			Score score = getScore();
			int startTeam = score.startTeam;
			int linkTeam = score.linkTeam;
			min = Math.min(min, Math.abs(startTeam - linkTeam));
			
			if(min == 0) {
				System.out.println(min);
				System.exit(0);
			}
		}else {
			return;
		}
		for (int i = start; i < n; i++) {
			if(!isPick[i]) {
				isPick[i] = true;
				dfs(depth + 1, i + 1);
				isPick[i] = false;
			}

		}
	}

	private static Score getScore() {
		Score score = new Score();
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (isPick[i] && isPick[j]) {
					score.startTeam += matrix[i][j];
					score.startTeam += matrix[j][i];
				} else if (!isPick[i] && !isPick[j]) {
					score.linkTeam += matrix[i][j];
					score.linkTeam += matrix[j][i];
				}
			}

		}

		return score;
	}

	public static class Score {
		int startTeam;
		int linkTeam;

		public Score() {
			this.startTeam = 0;
			this.linkTeam = 0;
		}
	}

}
