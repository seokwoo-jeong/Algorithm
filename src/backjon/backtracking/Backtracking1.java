package backjon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15649
// N과 M 1

public class Backtracking1 {
	private static int[] array;
	private static boolean[] isUsed;
	private static int N;
	private static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String read = in.readLine();
		N = Integer.parseInt(read.split(" ")[0]);
		M = Integer.parseInt(read.split(" ")[1]);
		
		solution(N,M);
	}
	public static void solution(int N, int M) {
		array = new int[M];
		isUsed = new boolean[N+1];
		int k = 0;
		for(int i=1; i<=N; i++) {
			isUsed[i] = false;
		}
		backtracking(k);
		
		
	}
	public static void backtracking(int k) {
		if(k == M) {
			for(int i =0; i<M; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i<=N; i++) {
			if(!isUsed[i]) { //아직 사용안 한 수이라면
				array[k] = i;
				isUsed[i] = true;
				backtracking(k+1);
				isUsed[i] = false;
			}
 		}
	}

}
