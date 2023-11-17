package codingtest.dev2_220623;

// array 주고, 오름차순으로 바꿔줘라
// 최소값만큼만 바꿔줘야 하며, 바꾼 값들을 다 더해 return
// ex) {1,3,2} -> {1,2,2}  result: 1
// ex) {4,3,2} -> {2,2,2}  result: 3
// ex) {5,2,1,1,5,3,4} -> {1,1,1,1,3,3,4} result: 7
// 값을 감소하는 것만 가능

public class Dev1 {
	public int solution(int[] array) {
		int answer = 0;
		boolean flag = true;
		while(flag) {
			flag = false;
			for(int i = 0; i<array.length-1; i++) {
				if(array[i] > array[i+1]) {
					answer += array[i] - array[i+1];
					array[i] = array[i+1];
					flag = true;
				}
			}
			
		}

		//System.out.println(answer);
		return answer;
	}
}
