package backjon2.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// https://www.acmicpc.net/problem/15656
// N과 M (7)
public class BackTracking07 {
	private static int[] array;
	private static int[] answerArray;
	private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		array = new int[n];
		answerArray = new int[m];
		temp = br.readLine().split(" ");
		
		for(int i =0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(array);
		dfs(0);
		out.flush();
		out.close();

	}
	
	private static void dfs(int depth) throws IOException{
		if(depth == answerArray.length) {
			for(int answer : answerArray) {
				out.write(String.valueOf(answer) + " ");
			}
			out.newLine();

			return;
		}
		
		for(int i =0; i<array.length; i++) {
			answerArray[depth] = array[i];
			dfs(depth+1);
		}
	}

}