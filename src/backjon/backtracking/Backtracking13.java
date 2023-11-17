package backjon.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// https://www.acmicpc.net/problem/9663
// N-Queen
public class Backtracking13 {
	static int[] array;	// array[행] = 열
	static int n;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		count = 0;
		n = Integer.parseInt(br.readLine());
		array = new int[n];
		
		dfs(0);
		System.out.println(count);

	}
	private static void dfs(int depth) {
		if(depth == n) {
			count++;
			return;
		}
		
		for(int i = 0; i<n; i++) {
			array[depth] = i;
			if(isPossible(depth)) {
				dfs(depth+1);
			}
		}
		
	}
	private static boolean isPossible(int depth) {
		for(int i = 0; i<depth; i++) {
			if(array[depth] == array[i]) { //이제껏 체스판 위에 둔 퀸들과 열들이 같은경우 이 경우는 못놈
				return false;
			} else if(Math.abs(i-depth) == Math.abs(array[i] - array[depth])){ // 대각선인경운
				return false;
			
			}
		}
		return true;
	}

}
