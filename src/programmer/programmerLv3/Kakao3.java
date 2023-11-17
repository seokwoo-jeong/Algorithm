package programmer.programmerLv3;

// https://school.programmers.co.kr/learn/courses/30/lessons/64062
// 징검다리 건너기

// [2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
// k = 3
public class Kakao3 {
	private int[] stones;
	private int k;
	private int result;
	public int solution(int[] stones, int k) {
		this.stones = stones;
		this.k = k;
		this.result = 0;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i<this.stones.length; i++) {
			min = Math.min(min, this.stones[i]);
			max = Math.max(max, this.stones[i]);
		}
		if(this.stones.length == 1) {
			return this.stones[0];
		}
		binarySearch(min, max);
		
		return result;
	}
	
	private void binarySearch(int start, int finish) {
		if(start >= finish) {
			return;
		}
		int mid = (start+finish)/2;
		
		if(isGo(mid)) {	//갈수 있는 경우
			binarySearch(mid+1, finish);
		}else {	//갈 수 없는 경우
			result = mid;
			binarySearch(start, mid);
		}
		
	}
	
	private boolean isGo(int value) {
		int count = 0;
		for(int i = 0; i<this.stones.length; i++) {
			if(value >= this.stones[i]) {
				count++;
			}else {
				count = 0;
			}
			
			if(count >= k ) {
				return false;
			}
		}
		
		return true;
	}
}