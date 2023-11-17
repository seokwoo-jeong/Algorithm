package backjon.recursion;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/6603
// 로또
public class Recursion1{
	private static int n;
	private static int[] array;
	private static boolean[] isVisit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] temp = br.readLine().split(" ");
			
			if(temp[0].equals("0")) {
				break;
			}
			
			n = Integer.parseInt(temp[0]);
			array = new int[n];
			isVisit = new boolean[n];
			
			for(int i = 0; i<n; i++) {
				array[i] = Integer.parseInt(temp[i+1]);
			}
			
			dfs(0,0);
			System.out.println();
		}

	}
	private static void dfs(int depth, int start) {
		if(depth == 6) {
			for(int i = 0; i<n; i++) {
				if(isVisit[i]) {
					System.out.print(array[i] + " ");
				}
			}
			System.out.println();
		}
		
		for(int i = start; i<n; i++) {
			isVisit[i] = true;
			dfs(depth+1, i+1);
			isVisit[i] = false;
		}
	}

}
