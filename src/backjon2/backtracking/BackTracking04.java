package backjon2.backtracking;
// https://www.acmicpc.net/problem/15652
// N과 M(4) 실(3)
import java.io.*;

public class BackTracking04 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		int[] array = new int[m];
		
		dfs(n, 0, 0, array);

	}
	
	private static void dfs(int n , int depth, int before, int[] array) {
		if(depth == array.length) {
			for(int answer : array) {
				System.out.print(answer+1 + " ");
			}
			System.out.println();
			return ;
		}
		
		for(int i = before; i<n; i++) {
			
			array[depth] = i;
			dfs(n, depth+1, i, array);
		}
	}

}
