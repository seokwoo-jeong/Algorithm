package backjon.binarysearch;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1920
// 수 찾기
public class BinarySearch1 {
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
		for(int i = 0; i<m; i++) {
			int num = Integer.parseInt(temp[i]);
			System.out.println(isExist(num));
		}
	}
	private static int isExist(int num) {
		int start = 0;
		int end = n-1;
		int result = 0;
		while(start <= end) {
			int middle = (start+end) /2;
			
			if(num < array[middle]) {
				end = middle-1;
			}else if(num > array[middle]) {
				start = middle+1;
			}else {
				result = 1;
				break;
			}
			
		}
		
		return result;
	}
}
