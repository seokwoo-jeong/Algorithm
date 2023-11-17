package codingtest.eleven202205;

public class Eleven1 {

	public int solution(int a, int b) {
		char[] A = String.valueOf(a).toCharArray();
		char[] B = String.valueOf(b).toCharArray();
		int index = -1;
		int startIndex = 0;
		int count = 0;
		boolean flag = false;
		for(int i = 0; i<B.length; i++) {
			count = 0;
			flag = false;
			if(B[i] == A[0]) {	//첫자리 같은 곳 발견
				startIndex = i+1;
				count++;
				for(int j = 1; j<A.length; j++) {	//다음자리확인
					if(startIndex >= B.length) {//다음자리확인하는데 숫자 끝나면 break
						break;
					}
					if(B[startIndex] == A[j]) {//다음자리도 같으면 index++, count++
						count++;
						startIndex++;
					}else {	//다음자리 다르면 break;
						flag = true;
						break;
					}
				}
				if(!flag && count == A.length) {	
					index = i;
					break;
				}
			}
		}
		return index;
	}

}
