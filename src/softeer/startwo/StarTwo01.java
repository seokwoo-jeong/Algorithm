package softeer.startwo;

import java.io.*;
import java.util.Arrays;

// https://softeer.ai/practice/6288
// 금고털이

public class StarTwo01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		int w = Integer.parseInt(temp[0]); // 배낭무게 (1<=w<=10000)
		int n = Integer.parseInt(temp[1]); // 귀금속종류 (1000000)

		Info[] array = new Info[n];

		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			Info info = new Info(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));

			array[i] = info;
		}

		Arrays.sort(array);
		int result = 0;
		for (Info info : array) {
			if (w >= info.m) { // 가방의 무게가 더 큰 경우
				w -= info.m;
				result += info.m * info.p;
			} else { // 가방의 무게가 더 작은 경우
				result += w * info.p;
				w = 0;
			}

			if (w == 0) {
				break;
			}
		}
		System.out.println(result);
	}

	private static class Info implements Comparable<Info> {
		int m; // 금속 무게
		int p; // 무게 가격

		public Info(int m, int p) {
			this.m = m;
			this.p = p;
		}

		@Override
		public int compareTo(Info o) {
			return o.p - this.p;
		}
	}

}
