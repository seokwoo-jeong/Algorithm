package backjon.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//https://www.acmicpc.net/problem/9095
//1, 2, 3 더하기
public class Backtracking14 {
	static int n;
	static int[] sum = {1,2,3};
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			count = 0;
			dfs(0);
			System.out.println(count);
		}
	}
	private static void dfs(int val) {
		if(val == n) {
			count++;
			return;
		}else if(val > n) {
			return;
		}
		
		for(int i = 0; i<sum.length; i++) {
			dfs(val+sum[i]);
		}
	}

}
