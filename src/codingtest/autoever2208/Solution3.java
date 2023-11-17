package codingtest.autoever2208;

import java.util.*;
import java.io.*;

// array 중앙값 return
// 중복 값 존재
// 중앙값의 index return??

/* k번째 숫자 찾기(array.length/2)
 * 임의의 숫자 x를 하나 고른다.
 * x보다 작거나 같은수 less에 add
 * x보다 큰 수 bigger에 add
 *  
 * @author seokwooJeong
 *
 */
public class Solution3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		ArrayList<Integer> array = new ArrayList<>(temp.length);
		for(String a : temp) {
			array.add(Integer.parseInt(a));
		}
		
		int k = array.size()/2+1;
		System.out.println(quicksort(array,k));
	}
	
	private static int quicksort(ArrayList<Integer> array, int k) {
		int pivot = array.get(0);
		ArrayList<Integer> less = new ArrayList<>();
		ArrayList<Integer> bigger = new ArrayList<>();
		for(int i = 1; i<array.size(); i++) {
			if(array.get(i) <= pivot) {
				less.add(array.get(i));
			}else {
				bigger.add(array.get(i));
			}
		}
		
		if( k <=less.size()) {
			return quicksort(less,k);
		}else if(k == less.size() + 1) {
			return pivot;
		}else {
			return quicksort(bigger, k - (less.size()+1));
		}
	}
}
