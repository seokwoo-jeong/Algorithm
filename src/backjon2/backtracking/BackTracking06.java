package backjon2.backtracking;

// https://www.acmicpc.net/problem/15655
// N과 M (6) 실(3)
import java.io.*;
import java.util.Arrays;
public class BackTracking06 {
	
	private static int[] array;
	private static boolean[] isVisit;
	private static int[] answerArray;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		array = new int[n];
		isVisit = new boolean[n];
		answerArray = new int[m];
		temp = br.readLine().split(" ");
		
		for(int i =0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(array);
		dfs(0,0);

	}
	
	private static void dfs(int beforeIndex, int depth) {
		if(depth == answerArray.length) {
			for(int i : answerArray) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i =beforeIndex; i<array.length; i++) {
			if(isVisit[i]) {
				continue;
			}
			isVisit[i] = true;
			answerArray[depth] = array[i];
			dfs(i, depth+1);
			isVisit[i] = false;
		}
	}

}
