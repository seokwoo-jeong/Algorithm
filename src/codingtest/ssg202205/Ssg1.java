package codingtest.ssg202205;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Ssg1 {
	public int solution(int[] v, int a, int b) {
		ArrayList<Integer> array = (ArrayList<Integer>) Arrays.stream(v).boxed().collect(Collectors.toList());
		Collections.sort(array, Collections.reverseOrder());
		int size = array.size();
		int bigIndex = 0;
		int result = 0;
		while(true) {
			bigIndex = findBigIndex(array,size);;
			if(findNotMove(array,size,a, b,bigIndex)) {
				break;
			}
			
			array = minusV(array, size, bigIndex,a,b);
			
			result++;
			
		}
		
		
		return result;
		
		
	}

	private ArrayList<Integer> minusV(ArrayList<Integer> array,int size, int bigIndex,int a,int b) {
		ArrayList<Integer> tempArray = array;
		for(int i = 0; i<size; i++) {
			if(i == bigIndex) {
				tempArray.set(i, array.get(i)-a); 
			}else {
				tempArray.set(i, array.get(i)-b); 
			}
		}
		
		return tempArray;
	}

	private boolean findNotMove(ArrayList<Integer> array, int size,int a, int b, int bigIndex) {
		boolean flag = false;
		for(int i = 0; i<size; i++) {
			if(i == bigIndex) {
				if(array.get(bigIndex) < a) {
					flag = true;
					break;
				}
			}else {
				if(array.get(i) < b) {
					flag = true;
					break;
				}
			}
		}

		return flag;
		
	}

	private int findBigIndex(ArrayList<Integer> array, int size) {
		int bigIndex = 0;
		
		for(int i = 1; i<size; i++) {
			if(array.get(bigIndex) < array.get(i)) {
				bigIndex = i;
			}
		}
		return bigIndex;
		
	}
}
