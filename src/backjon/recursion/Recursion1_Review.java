package backjon.recursion;

import java.util.*;
import java.io.*;
public class Recursion1_Review {
	private static int[] array;
	private static boolean[] isVisit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] temp = br.readLine().split(" ");
			int k = Integer.parseInt(temp[0]);
			
			if(k == 0) break;
			int size = temp.length;
			
			array = new int[size-1];
			isVisit = new boolean[size-1];
			
			for(int i = 1; i<size; i++) {
				array[i-1] = Integer.parseInt(temp[i]);
			}
			
			dfs(0, new int[6],0);
			System.out.println();
		}

	}
	
	private static void dfs(int depth, int[] answer, int start) {
		if(depth == 6) {
			for(int i: answer){
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i<array.length; i++) {
			if(!isVisit[i]) {
				isVisit[i] = true;
				answer[depth] = array[i];
				dfs(depth+1, answer, i+1);
				isVisit[i] = false;
			}
		}
	}

}
