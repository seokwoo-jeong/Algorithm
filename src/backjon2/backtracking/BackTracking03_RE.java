package backjon2.backtracking;
import java.io.*;

// https://www.acmicpc.net/problem/15651
// N과 M (3) 실버3
public class BackTracking03_RE {

	private static int n;
	private static int m;
	private static int[] array;
	private static BufferedWriter out;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] temp = br.readLine().split(" ");

		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		array = new int[m];
		
		dfs(0);
		
		br.close();
		out.flush();
		out.close();
		
	}
	private static void dfs(int depth) throws IOException {
		if(depth == m) {
			for(int answer : array) {
				out.write(String.valueOf(answer+1) + " ");
			}
			out.newLine();
			return;
		}
		
		for(int i = 0; i<n; i++) {
			array[depth] = i;
			dfs(depth+1);
		}
	}

}
