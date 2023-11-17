package backjon.twopoint;
import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1806
// 부분합
public class TwoPoint3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);	//array size
		int s = Integer.parseInt(temp[1]);  //sum
		
		int[] array = new int[n];
		temp = br.readLine().split(" ");
		
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int result = Integer.MAX_VALUE;
		//index의 마지막은 n-1이니깐 start가 이걸 넘어가면 종료
		while(left < n) {
			
			if(sum < s && right < n) {
				sum += array[right];
				right++;
			}else {
				if(sum >= s) {
					result = Math.min(result, right-left);
				}
				sum -= array[left];
				left++;
			}
			//System.out.println(left + " " + right + " " + result);
		}
		
		if(result == 0) {
			System.out.println(1);
		}else if(result == Integer.MAX_VALUE){
			System.out.println(0);
		}else {
			System.out.println(result);
		}
	}

}
