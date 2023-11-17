package backjon.backtracking;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2529
// 부등호

// dfs에 start를 줘 for i = start를 사용하는 경우는 결과가 오름차순일때 사용
// visit를 사용하는 경우는 중복값을 피할경우 사용
public class Backtracking18 {
	static int k;
	static String[] array;
	static boolean[] isVisit;
	static String[] num = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	static ArrayList<String> result;
	static String[] sign;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		array = new String[k + 1];
		isVisit = new boolean[num.length];
		result = new ArrayList<>();
		sign = br.readLine().split(" ");

		dfs(0);
		Collections.sort(result);
		System.out.println(result.get(result.size()-1));
		System.out.println(result.get(0));

	}

	private static void dfs(int depth) {
		if (depth == k + 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < array.length; i++) {
				sb.append(array[i]);
			}
			result.add(sb.toString());
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (!isVisit[i]) {
				if (depth == 0 || isPossible(depth,num[i])) {
					isVisit[i] = true;
					array[depth] = num[i];
					dfs(depth + 1);
					isVisit[i] = false;
				}

			}

		}

	}

	private static boolean isPossible(int depth, String currentNum) {
		boolean flag = true;
		if (sign[depth - 1].equals("<")) {
			if (Integer.parseInt(array[depth - 1]) > Integer.parseInt(currentNum)) {
				flag = false;
			}
		} else {
			if (Integer.parseInt(array[depth - 1]) < Integer.parseInt(currentNum)) {
				flag = false;
			}

		}

		return flag;
	}

}
