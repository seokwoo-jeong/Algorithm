package backjon2.bruteforce;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1027
// 고층건물 (골4)
public class BruteForce02 {
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		int[] array = new int[n];

		String[] temp = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}

		int result = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int left = getLeft(i, array);
			int right = getRight(i, array);
			result = Math.max(result, left + right);
		}

		System.out.println(result);
	}

	private static int getLeft(int index, int[] array) {
		int count = 0;
		double temp = 0;
		for (int i = index - 1; i >= 0; i--) {
			double a = (double) (array[index] - array[i]) / (index - i);
			
			if(i == index -1 || temp > a) {

				count++;
				temp = a;
			}
		}
		return count;
	}

	private static int getRight(int index, int[] array) {
		int count = 0;
		double temp = 0;
		for(int i = index+1; i<n; i++) {
			double a = (double) (array[index] - array[i]) / (index - i);
			
			if(i==index+1 || temp < a) {
				count++;
				temp = a;
			}
		}
		return count;
	}
}
