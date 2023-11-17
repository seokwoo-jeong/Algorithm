package backjon.backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/15655
// N과 M 6

public class Backtracking6 {
	private static int[] array;
	private static int N;
	private static int M;
	private static boolean[] visited;
	private static int[] numArray;
	private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		array = new int[M];
		visited = new boolean[N];
		numArray = new int[N];
		for(int i =0; i<N; i++) {
			numArray[i] = scanner.nextInt();
			visited[i] = false;
		}
		Arrays.sort(numArray);
		backtracking(0);
		
		out.flush();
		out.close();
	}

	public static void backtracking(int k) throws IOException {
		if(k == M) {
			for(int i = 0; i<M; i++) {
				out.write(String.valueOf(array[i]) + " ");
			}
			out.newLine();
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(!visited[i]) {
				if(k == 0 || array[k-1] < numArray[i]) {
					array[k] = numArray[i];
					visited[i] = true;
					backtracking(k+1);
					visited[i] = false;
				}

			}
		}
		
	}

}
