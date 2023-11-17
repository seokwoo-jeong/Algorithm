package backjon2.implement;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/22251
// 빌런 호석(골5)

public class Implement05 {
	private static ArrayList<int[]> array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		int n = Integer.parseInt(temp[0]); // 1층 ~ n층
		int k = Integer.parseInt(temp[1]); // K자리수
		int p = Integer.parseInt(temp[2]); // 최대 p개 반전계획 중
		int x = Integer.parseInt(temp[3]); // 현재 층

		int[] zero = new int[] { 1, 1, 1, 0, 1, 1, 1 };
		int[] one = new int[] { 0, 0, 1, 0, 0, 1, 0 };
		int[] two = new int[] { 1, 0, 1, 1, 1, 0, 1 };
		int[] three = new int[] { 1, 0, 1, 1, 0, 1, 1 };
		int[] four = new int[] { 0, 1, 1, 1, 0, 1, 0 };
		int[] five = new int[] { 1, 1, 0, 1, 0, 1, 1 };
		int[] six = new int[] { 1, 1, 0, 1, 1, 1, 1 };
		int[] seven = new int[] { 1, 0, 1, 0, 0, 1, 0 };
		int[] eight = new int[] { 1, 1, 1, 1, 1, 1, 1 };
		int[] nine = new int[] { 1, 1, 1, 1, 0, 1, 1 };

		array = new ArrayList<>(Arrays.asList(zero, one, two, three, four, five, six, seven, eight, nine));

		int result = 0;
		String cur = setNo(x, k);
		for (int i = 1; i <= n; i++) {
			String no = setNo(i, k);

			if (cur.equals(no)) {
				continue;
			}

			if (isPossible(no, cur, p)) {
				result++;
			}
		}
		System.out.println(result);
	}

	private static boolean isPossible(String no, String cur, int p) {
		// 현재 층 cur이 no로 p번 안에 변할 수 있는지
		int count = 0;

		char[] noArray = no.toCharArray();
		char[] curArray = cur.toCharArray();

		for (int i = 0; i < curArray.length; i++) {
			int oneCur = Character.digit(curArray[i], 10);
			int oneNo = Character.digit(noArray[i], 10);

			for (int z = 0; z < array.get(oneCur).length; z++) {
				if (array.get(oneNo)[z] != array.get(oneCur)[z]) {
					count++;
				}
				if (count > p) {
					return false;
				}
			}
		}
		return true;
	}

	private static String setNo(int no, int k) {
		StringBuilder sb = new StringBuilder();

		int size = String.valueOf(no).length();

		int rest = k - size;

		for (int i = 0; i < rest; i++) {
			sb.append('0');
		}
		sb.append(no);

		return sb.toString();

	}

}
