package backjon2.implement;

import java.io.*;

//https://www.acmicpc.net/problem/7490
//0 만들기 (골5)
public class Implement06 {
	private static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		n = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());

			for (int z = 1; z <= n; z++) {
				sb.append(z);
				sb.append(" ");
			}

			dfs(1, sb);
			System.out.println();
			sb.delete(0, sb.length());
		}

	}

	private static void dfs(int depth, StringBuilder sb) {
		if (depth == n * 2 - 1) {
			if (cal(sb) == 0) {
				System.out.println(sb.toString());
			}
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (i == 0) { // +
				sb.setCharAt(depth, ' ');
			} else if (i == 1) { // -
				sb.setCharAt(depth, '+');
			} else { // " "
				sb.setCharAt(depth, '-');
			}

			dfs(depth + 2, sb);
		}
	}

	private static int cal(StringBuilder sb) {
		int result = 0;

		StringBuilder cur = new StringBuilder();
		for (int i = sb.length() - 1; i >= 0; i--) {
			if (Character.isDigit(sb.charAt(i))) {
				cur.append(sb.charAt(i));
			} else {
				if (sb.charAt(i) == '+') {
					result += Integer.parseInt(cur.reverse().toString());
					cur.delete(0, cur.length());
				} else if (sb.charAt(i) == '-') {
					result -= Integer.parseInt(cur.reverse().toString());
					cur.delete(0, cur.length());
				} else {
					cur.append(sb.charAt(i - 1));
					i--;
				}
			}
		}
		result += Integer.parseInt(cur.reverse().toString());

		return result;
	}

}
