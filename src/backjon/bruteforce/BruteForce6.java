package backjon.bruteforce;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2503
// 숫자 야구
public class BruteForce6 {

	private static char[] array = {'1','2','3','4','5','6','7','8','9'};
	private static boolean[] isVisit;
	private static HashMap<String,Info> hash;
	private static int result;
	private static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		isVisit = new boolean[9];
		hash = new HashMap<>();
		result = 0;
		
		for(int i = 0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			String key = temp[0];
			Info info = new Info(Integer.parseInt(temp[1]),Integer.parseInt(temp[2]));
			hash.put(key, info);
		}
		
		dfs(0, new char[3]);
		System.out.println(result);
	}
	
	private static void dfs(int depth, char[] temp) {
		if(depth == 3) {
			int strike = 0;
			int ball = 0;
			int count = 0;
			for(String a : hash.keySet()){
				char[] temp2 = a.toCharArray();
				strike = 0;
				ball = 0;
				for(int i = 0; i<3; i++) {
					for(int j = 0; j<3; j++) {
						if(temp[i] == temp2[j]) {
							if(i == j) {
								strike++;
							}else {
								ball++;
							}
						}
					}
				}
				//System.out.println(a+ " " + temp[0] + temp[1] + temp[2] + " " + strike + " " + ball +" " + count);
				if(hash.get(a).strike == strike && hash.get(a).ball == ball) {
					count++;
				}
			}
			
			if(n == count) {
				//System.out.println(temp[0] + "" + temp[1] + "" + temp[2]);
				result++;
			}
			return;
		}
		
		for(int i = 0; i<9; i++) {
			if(!isVisit[i]) {
				isVisit[i] = true;
				temp[depth] = array[i];
				dfs(depth+1, temp);
				isVisit[i] = false;
			}
		}
		
	}

	private static class Info{
		int strike;
		int ball;
		
		public Info(int strike, int ball) {
			this.strike = strike;
			this.ball = ball;
		}
	}

}
