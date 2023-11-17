package codingtest.toss220806;

import java.util.*;

public class Toss2 {
	public int solution(int[] levels) {
		int size = levels.length;
		if(size < 4) {
			return -1;
		}
		int limit = size/4;
		
		Arrays.sort(levels);
		
		int answer = levels[size-limit];
		
		//System.out.println(answer);
		
		return answer;
	}

}
