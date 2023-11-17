package backjon.binarysearch;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10816
// 숫자 카드2
public class BinarySearch2 {
	private static int n;
	private static int[] array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		array = new int[n];
		
		String[] temp = br.readLine().split(" ");
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(array);
		
		int m = Integer.parseInt(br.readLine());
		
		temp = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<m; i++) {
			int num = Integer.parseInt(temp[i]);
			
			sb.append((upperBound(num) - lowerBound(num)));
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
	
	private static int upperBound(int num) {
		int start = 0;
		int end = n;
		while(start < end) {
			int middle = (start+end) / 2;
			
			if(num < array[middle]) {
				end  = middle;
			}else {
				start = middle+1;
			}			
			
		}
		return start;
	}
	
	private static int lowerBound(int num) {
		int start = 0;
		int end = n;
		while(start < end) {
			int middle = (start+end) / 2;
			
			if(num <= array[middle]) {
				end  = middle;
			}else {
				start = middle+1;
			}
		}
		return start;
	}

}
