package codingtest.sktelecom202206;

public class SkTel1 {
	public int[] solution(int[] p) {
		int n = p.length;
		int[] answer = new int[n];
		int i = 0;
		int j = 0;
		int min = 0;
		while (i < n) {
			min = Integer.MAX_VALUE;
			for (int k = i; k < n; k++) {
				if (p[k] < min) {
					min = p[k];
					j = k;
				}
			}
			if (i != j) {
				int temp = p[i];
				p[i] = p[j];
				p[j] = temp;

				answer[i] += 1;
				answer[j] += 1;
			}
			i++;
		}

		return answer;
	}
}