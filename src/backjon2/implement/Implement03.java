package backjon2.implement;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/20055
// 컨베이어 벨트 위의 로봇(골5)

public class Implement03 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);	// arraysize 2n
		int k = Integer.parseInt(temp[1]);	// 0개수
		
		int[] array = new int[2*n];
		
		boolean[] toyArray = new boolean[n];
		
		temp = br.readLine().split(" ");
		
		
		for(int i = 0; i<2*n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		int count = 0;
		while(isGo(array,k)) {
			array = rotateBelt(array);
			
			toyArray = rotateToy(toyArray);
			
			moveToy(toyArray, array);
			
			count++;
		}
		System.out.println(count);

	}
	
	private static boolean isGo(int[] array, int k) {
		int count = 0;
		for(int i = 0; i<array.length; i++) {
			if(array[i] == 0) {
				count++;
			}
			
			if(count >= k ) {
				return false;
			}
		}
		return true;
	}
	
	private static void moveToy(boolean[] toyArray, int[] array) {
		for(int i = toyArray.length-1; i>0; i--) {
			if(!toyArray[i] && toyArray[i-1] && array[i] >= 1) {
				toyArray[i] = true;
				toyArray[i-1] = false;
				array[i]--;
			}
		}
		
		if(array[0] > 0) {
			toyArray[0] = true;
			array[0] --;
		}
	}
	
	
	private static int[] rotateBelt(int[] array) {
		int size = array.length;
		
		
		int first = array[size-1];
		
		int[] temp = new int[size];
		
		for(int i = 1; i<size; i++) {
			temp[i] = array[i-1];
		}
		temp[0] = first;
		
		return temp;
	}

	private static boolean[] rotateToy(boolean[] array) {
		int size = array.length;
		
		
		
		boolean[] temp = new boolean[size];
		
		for(int i = 1; i<size; i++) {
			temp[i] = array[i-1];
		}
		temp[0] = false;
		temp[size-1] = false;
		return temp;
	}
}
