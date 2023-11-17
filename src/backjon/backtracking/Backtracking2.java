package backjon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15650
// N과 M 2

public class Backtracking2 {
	private static int[] array;
	private static boolean[] isUsed;
	private static int N;
	private static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String read = in.readLine();
		N = Integer.parseInt(read.split(" ")[0]);
		M = Integer.parseInt(read.split(" ")[1]);
		
		solution();
	}
	public static void solution() {
		array = new int[M];
		isUsed = new boolean[N+1];
		for(int i = 1; i<=N; i++) {
			isUsed[i] = false;
		}
		backtracking(0);
		
	}
	public static void backtracking(int k) {
		if(k == M) {
			for(int i = 0; i<M; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 1; i<=N; i++) {
			if(!isUsed[i]) {
				if(k == 0 || array[k-1] < i) {	//전수가 현재수보다 작은경우
					array[k] = i;
					isUsed[i] = true;
					backtracking(k+1);
					isUsed[i] = false;
				}
			}
		}
	}

}
