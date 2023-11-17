package backjon.twopoint;
import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/2470
// 두 용액

public class TwoPoint2 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		
		String[] temp = br.readLine().split(" ");
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(array);	//정렬
		
		int start = 0;
		int end = n-1;
		int sum = 0;
		
		int rs = start;
		int re = end;
		int beforeSum = Integer.MAX_VALUE;
		
		while(start < end) {
			sum = array[start] + array[end];
			
			if(Math.abs(sum) < beforeSum) {
				beforeSum = Math.abs(sum);
				rs = array[start];
				re = array[end];
			}
			
			if(sum > 0) {
				end--;
			}else if(sum < 0){
				start++;
			}else {
				break;
			}
			
			
		}
		System.out.println(rs + " " + re);
		
	}

}
