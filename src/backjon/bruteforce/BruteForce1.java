package backjon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// https://www.acmicpc.net/problem/2309  
// 일곱난쟁이

public class BruteForce1 {
	public static void main(String[] args) {
		solution();
	}
	public static void solution() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arrayList = new ArrayList<>();
		int totalWeight = 0;
		boolean flag = false;
		for(int i = 0; i<9; i++) {
			try {
				arrayList.add(Integer.parseInt(in.readLine()));
				totalWeight += arrayList.get(i);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for(int i = 0; i<9; i++) {
			if(flag) {
				break;
			}
			for(int z = i+1; z<9; z++) {
				if(totalWeight-(arrayList.get(i) + arrayList.get(z)) == 100) {
					arrayList.remove(z);
					arrayList.remove(i);
					flag = true;
					break;
				}
			}
		}
		Collections.sort(arrayList);
		for(int result: arrayList) {
			System.out.println(result);
		}
	}

}
