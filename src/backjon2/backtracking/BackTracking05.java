package backjon2.backtracking;

// https://www.acmicpc.net/problem/15654
// N과 M(5) 실(3)

import java.io.*;
import java.util.Arrays;

public class BackTracking05 {
	private static boolean[] isVisit;
	private static int[] array;
	private static int[] answerArray;
	private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		temp = br.readLine().split(" ");
		isVisit = new boolean[n];
		array = new int[n];
		answerArray = new int[m];
		
		for(int i = 0; i<temp.length; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(array);
		
		dfs(0);
		out.flush();
		out.close();
	}
	
	private static void dfs(int depth) throws IOException {
		if(depth == answerArray.length) {
			for(int answer : answerArray) {
				out.write(String.valueOf(answer) + " ");
			}
			out.newLine();
			return;
		}
		
		for(int i = 0; i<array.length; i++) {
			if(isVisit[i]) {
				continue;
			}
			isVisit[i] = true;
			answerArray[depth] = array[i];
			dfs(depth+1);
			isVisit[i] = false;
		}
		
	}

}
