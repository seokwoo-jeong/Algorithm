package backjon.backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

// https://www.acmicpc.net/problem/15664
// N과 M 10

public class Backtracking10 {
	static int n;
	static int m;
	static int[] array;
	static int[] numArray;
	static boolean[] isVisited;
	static LinkedHashSet<String> set;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		array = new int[m];
		numArray = new int[n];
		isVisited = new boolean[n];
		 set = new LinkedHashSet<>();
		for(int i = 0; i<n; i++) {
			numArray[i] = scanner.nextInt();
			isVisited[i] = false;
		}
		Arrays.sort(numArray);
		backtracking(0);
		set.forEach(System.out::println);
	}

	public static void backtracking(int k) throws IOException {
		if(k==m) {
			StringBuilder stringBuilder = new StringBuilder();
			for(int i = 0; i<m; i++) {
				stringBuilder.append(array[i]).append(" ");
			}
			set.add(stringBuilder.toString());
			return;
		}
		
		for(int i = 0; i<n; i++) {
			if(!isVisited[i]) {
				if(k == 0 || array[k-1] <= numArray[i]) {
					array[k] = numArray[i];
					isVisited[i] = true;
					backtracking(k+1);
					isVisited[i] = false; 
				}

			}
			
			
		}
	}

}
