package codingtest.Nhn202205;

import java.util.Arrays;

public class Nhn1 {
	
	//1. 카드팩1번과 카드팩2번 동일한 인덱스 팩중 중복 카드 있는 경우 문제라운드임
	//2. 동일한 인덱스에서 두 카드팩 다르면 각 카드팩 직전 카드팩과 비교해서 2개이상 중복되면 문제라운드
	public int solution(int[][] cards1, int[][] cards2) {
		int size = cards1.length;
		int result = 0;
		for(int i = 0; i< size; i++) {
			if(isDuplicate(cards1[i],cards2[i])) {
				result++;
			}else {
				if(i>0 && isBeforeDuplicate(cards1[i-1],cards1[i])) {
					result++;
				}else if(i > 0 && isBeforeDuplicate(cards2[i-1],cards2[i])) {
					result++;
				}
			}
		}
		
		System.out.println(result);
		return result;
	}
	private boolean isDuplicate(int[] pack1, int[] pack2) {
		boolean flag = false;
		
		for(int i = 0; i<pack1.length; i++) {
			if(contains(pack2,pack1[i]) || contains(pack1,pack1[i],i) || contains(pack2,pack2[i],i)) {
				flag = true;
				break;
			}
			
		}
		return flag;
	}
	private boolean contains(int[] pack, int val, int index) {
		boolean flag = false;
		for(int i = 0; i<pack.length; i++) {
			if(index == i) {
				continue;
			}
			if(pack[i] == val) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	private boolean isBeforeDuplicate(int[] beforePack, int[] currentPack) {
		boolean flag = false;
		int count = 0;
		for(int i = 0; i<beforePack.length; i++) {
			if(contains(beforePack,currentPack[i])) {
				count++;
			}
		}
		if(count >= 2) {
			flag = true;
		}
		return flag;
	}

    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }
    

	
}
