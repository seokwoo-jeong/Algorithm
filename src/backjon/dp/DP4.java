package backjon.dp;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/9095
//1, 2, 3 더하기
public class DP4 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] array = new int[11];
		array[1] = 1;
		array[2] = 2;
		array[3] = 4;
		for(int i = 4; i<11; i++) {
			array[i] = array[i-1] + array[i-2] + array[i-3];
		}
		for(int i = 0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(array[n]);
		}

	}

}
