package backjon2.twopoint;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2230
// 수 고르기 (골5)

public class TwoPoint05 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);	// array size
		int m = Integer.parseInt(temp[1]);	// 차이 M이상
		
		int[] array = new int[n];
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		int start = 0;
		int end = 0;
		int diff = Integer.MAX_VALUE;
		Arrays.sort(array);
		
		while(true) {
			if(start == n) {
				break;
			}
			
			if(diff == m) {
				break;
			}
			
			if(end == n) {	//end가 끝에 도달한 경우 start만 계속 줄이면 된다.
				if(array[end-1] - array[start] >= m ) {
					diff = Math.min(diff, array[end-1] - array[start]);	
				}
				start++;
			}else if(Math.abs(array[end] - array[start]) >= m) {
				// 둘의 차이가 넘으니 차이를 비교 후 start ++
				diff = Math.min(diff, array[end] - array[start]);
				start++;
			}else {
				// 둘의 차이가 넘지 않으니 더 큰 차이를 만들기 위해 end ++
				end++;
			}
			
		}
		System.out.println(diff);
		

	}

}
