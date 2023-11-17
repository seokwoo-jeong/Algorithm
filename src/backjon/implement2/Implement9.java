package backjon.implement2;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16939
// 2×2×2 큐브

public class Implement9 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 24;
		int[] origin = new int[n];
		int[] array = new int[n];
		
		String[] temp = br.readLine().split(" ");
		
		for(int i = 0; i<n; i++) {
			origin[i] = Integer.parseInt(temp[i]);
			array[i] = origin[i];
		}
		
		
		boolean isExist = find(n, array);

		if(isExist) {
			System.out.println(1);
		}else {
			array = turnClock(n, array);
			
			isExist = find(n, array);
			
			if(isExist) {
				System.out.println(1);
			}else {
				origin = turnReverse(n, origin);
				
				isExist = find(n,origin);
				
				if(isExist) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}
		}

	}

	private static int[] turnClock(int n, int[] array) {
		int[] temp = new int[n];
		for(int i = 0; i<n; i++) {
			temp[i] = array[i];
		}
		
		return null;
	}

	private static int[] turnReverse(int n, int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean find(int n, int[] array) {
		int start = 0;
		boolean temp = false;
		while(start < n) {
			int count = 0;
			int basic = array[start];
			for(int i = start; i<start+4; i++) {
				if(basic == array[i]) {
					count++;
				}
			}
			if(count == 4) {
				temp = true;
				break;
			}
			start+=4;
		}
		return temp;
	}

}
