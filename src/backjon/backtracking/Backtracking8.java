package backjon.backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/15657
// N과 M 8

public class Backtracking8 {
	static int n;
	static int m;
	static int[] array;
	static int[] numArray;
	private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		array = new int[m];
		numArray = new int[n];
		for(int i = 0; i<n; i++) {
			numArray[i] = scanner.nextInt();
		}
		Arrays.sort(numArray);
		backtracking(0);
		out.flush();
		out.close();
	}

	public static void backtracking(int k) throws IOException {
		if(k==m) {
			for(int i = 0; i<m; i++) {
				out.write(String.valueOf(array[i]) + " ");
			}
			out.newLine();
			return;
		}
		
		for(int i = 0; i<n; i++) {
			if(k == 0 || array[k-1] <= numArray[i]) {
				array[k] = numArray[i];
				backtracking(k+1);
			}
			
			
		}
	}

}
