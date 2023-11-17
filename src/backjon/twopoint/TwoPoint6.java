package backjon.twopoint;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2230
// 수 고르기
public class TwoPoint6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(array);

		int start = 0;
		int end = 0;
		int diff = Integer.MAX_VALUE;
		
		while(start < n) {
			if(end <n && array[end] - array[start] >= m) {
				diff = Math.min(array[end] - array[start], diff);
				start++;
			}else {
				end++;
				if(end == n) {
					while(start<n) {
						if(array[end-1] - array[start] >= m) {
							diff = Math.min(array[end-1] - array[start], diff);
						}
						start++;
					}
					break;
				}
			}
		}
		System.out.println(diff);
	}

}
