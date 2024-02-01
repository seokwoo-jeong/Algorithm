package codingtest.ssg202205;

import java.util.Arrays;

public class Ssg1_RE {

	private int answer;
	public int solution(int[] v, int a, int b) {
		answer = 0;
		
		Arrays.sort(v);
		int bigIndex = v.length-1;
		boolean flag = true;
		while(true) {
			flag = move(v,a,b,bigIndex);
			
			if(!flag) {
				break;
			}
			bigIndex = findBigIndex(v, bigIndex);
		}
		return answer;
	}
	
	public int findBigIndex(int[] v, int index) {
		int max = v[index];
		int bigIndex = 0;
		for(int i =0; i<v.length; i++) {
			if(max < v[i]) {
				max = v[i];
				bigIndex = i;
			}
		}
		return bigIndex;
	}
	
	
	public boolean move(int[] v, int a, int b, int index) {
		for(int i = v.length-1; i>=0; i--) {
			if(i == index) {
				v[i] -= a;
			}else {
				v[i] -= b;
			}
			
			if(v[i] < 0) {
				return false;
			}
		}
		answer++;
		return true;
	}
}
