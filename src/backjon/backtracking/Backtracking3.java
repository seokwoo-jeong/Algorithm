package backjon.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// https://www.acmicpc.net/problem/15651
// N과 M 3

public class Backtracking3 {
	private static int[] array;
	private static int N;
	private static int M;
	private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String read = in.readLine();
		N = Integer.parseInt(read.split(" ")[0]);
		M = Integer.parseInt(read.split(" ")[1]);
		
		solution();
		
		in.close();
		out.flush();
		out.close();
	}
	public static void solution() throws IOException {
		array = new int[M];
		backtracking(0);
	}
	public static void backtracking(int k) throws IOException {
		if(k == M) {
			for(int i = 0; i<M; i++) {
				out.write(String.valueOf(array[i]) + " ");
			}
			out.newLine();
			return;
		}
		for(int i = 1; i<=N; i++) {
				array[k] = i;
				backtracking(k+1);
		}
		
	}

}
