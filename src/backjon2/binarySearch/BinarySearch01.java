package backjon2.binarySearch;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/7795
// 먹을 것인가 먹힐 것인가 (실3)

public class BinarySearch01 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		String[] temp;
		int n = 0;
		int m = 0;
		int[] aArray;
		int[] bArray;
		int result = 0;
		for(int i = 0; i<t; i++) {
			result = 0;
			temp = br.readLine().split(" ");

			n = Integer.parseInt(temp[0]);
			m = Integer.parseInt(temp[1]);
			
			temp = br.readLine().split(" ");
			aArray = setArray(temp);
			Arrays.sort(aArray);			// o(n)
			
			
			temp = br.readLine().split(" ");
			bArray = setArray(temp);
			Arrays.sort(bArray);			// o(n)
			
			result += binarySearch(aArray,bArray);
			System.out.println(result);
		}

	}
	private static int binarySearch(int[] aArray, int[] bArray) {
		int value = 0;
		int count = 0;
		int result = 0;
		for(int i = 0; i<aArray.length; i++) {
			value = aArray[i];
			
			
			int start = 0;
			int end = bArray.length-1;
			int middle = 0;
			while(start <= end) {
				middle = (start + end) /2;
				
				if(bArray[middle] < value) {
					start = middle+1;
					count = middle+1;
				}else {
					end = middle - 1;
				}
				
			}
			result += count;
		}
		return result;
	}
	
	private static int[] setArray(String[] temp) {
		int[] array = new int[temp.length];
		for(int z = 0; z<temp.length; z++) {
			array[z] = Integer.parseInt(temp[z]);
		}		
		return array;
	}

}
