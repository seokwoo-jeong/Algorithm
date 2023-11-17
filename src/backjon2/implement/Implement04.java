package backjon2.implement;

import java.io.*;

// https://www.acmicpc.net/problem/14719
// 빗물 (골5)

public class Implement04 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int h = Integer.parseInt(temp[0]);
		int w = Integer.parseInt(temp[1]);
		
		temp = br.readLine().split(" ");
		
		int[] array = new int[w];
		
		for(int i = 0; i<w; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		int left = 0;
		int right = 0;
		int count = 0;
		for(int i = 1; i<w-1; i++) {
			int cur = array[i];
			left = 0;
			right = 0;
			
			for(int z = 0; z<i; z++) {
				if(array[z] > cur) {
					left = Math.max(array[z], left);
				}
			}
			
			for(int z= i+1; z<w; z++) {
				if(array[z] > cur) {
					right = Math.max(array[z], right);
				}
			}
			int value = Math.min(right, left) - cur;
			if(value > 0) {
				count += Math.min(right, left) - cur;	
			}
		}
		System.out.println(count);
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               

	}

}
