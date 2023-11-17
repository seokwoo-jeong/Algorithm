package codingtest.sktelecom202206;

public class SkTel1_Re {
	public int[] solution(int[] p) {

		int min = Integer.MAX_VALUE;
		int round = 0;
		int minround = 0;
		int[] result = new int[p.length];
		while (round < p.length) {
			for (int i = round; i < p.length; i++) {
				if (min > p[i]) {
					min = p[i];
					minround = i;
				}
			}
			if(p[minround] == p[round]) {
				round++;
				min = Integer.MAX_VALUE;
				continue;
			}
			
			p[minround] = p[round];
			p[round] = min;
			
			result[minround]++;
			result[round] ++;
			round++;
			min = Integer.MAX_VALUE;

		}
		
		
		return result;
	}
}
