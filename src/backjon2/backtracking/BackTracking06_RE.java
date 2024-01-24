package backjon2.backtracking;

// https://www.acmicpc.net/problem/15655
// N과 M (6) 실(3)
import java.io.*;
import java.util.Arrays;
public class BackTracking06_RE {
	
	private static int[] array;
	private static boolean[] isVisit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		temp = br.readLine().split(" ");
		
		array = new int[n];
		isVisit = new boolean[n];
		
		for(int i = 0; i<n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(array);
		
		int[] answerArray = new int[m];
		
		dfs(0,0,answerArray);
	}
	
	private static void dfs(int depth, int start,int[] answerArray) {
		if(depth == answerArray.length) {
			for(int result : answerArray) {
				System.out.print(result + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i<array.length; i++) {
			if(!isVisit[i]) {
				isVisit[i] = true;
				answerArray[depth] = array[i];
				dfs(depth+1,i, answerArray);
				isVisit[i] = false;
			}
		}
	}

}
