package backjon.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
//https://www.acmicpc.net/problem/1759
//암호 만들기
public class Backtracking15 {
	static String[] array;
	static boolean[] isVisit;
	static int l;
	static String[] result;
	static String[] collection = {"a", "e", "i", "o", "u"};
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] def = br.readLine().split(" ");
		l = Integer.parseInt(def[0]);
		result = new String[l];
		int c = Integer.parseInt(def[1]);
		array = br.readLine().split(" ");
		Arrays.sort(array);
		isVisit = new boolean[array.length];
		dfs(0,0);
		
		bw.flush();
		bw.close();
		
	}
	private static void dfs(int depth, int location) throws IOException {
		if(depth == l) {
			if(isPossible(result)) {
				for(int i = 0; i<result.length; i++) {
					bw.write(result[i].toString());
				}
				bw.newLine();
			}
			return;
		}
		
		for(int i = location; i<array.length; i++) {
			if(!isVisit[i]) {
				result[depth] = array[i];
				isVisit[i] = true;
				dfs(depth+1,i+1);
				isVisit[i] = false;
			}
		}
		
	}

	private static boolean isPossible(String[] result) {
		boolean flag = false;
		int count = 0;
		for(int i = 0; i<result.length; i++) {
			if(contains(result[i])) {
				count++;	//모음개수
			}
		}
		if(count < 1) {
			flag = false;
		}else if(result.length - count >= 2) {	//전체에서 모음 뺀 개수가 2개이상이여야 true (자음개수 2개이상)
			flag = true;
		}
		return flag;
	}
	
	private static boolean contains(String result) {
		for(int i = 0; i<collection.length; i++) {
			if(collection[i].equals(result)) {
				return true;
			}
		}
		return false;
	}

}
