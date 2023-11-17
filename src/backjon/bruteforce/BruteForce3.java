package backjon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1476
//  날짜 계산

public class BruteForce3 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String readLine = in.readLine();
		int e = Integer.parseInt(readLine.split(" ")[0]);
		int s = Integer.parseInt(readLine.split(" ")[1]);
		int m = Integer.parseInt(readLine.split(" ")[2]);
		
		int answer = 1;
		
		while(true) {
			if((answer-e)%15 == 0 && (answer - s) % 28 == 0 && (answer-m) % 19 == 0) {
				break;
			}else {
				answer ++;
			}
		}
		System.out.println(answer);
	
	}

	
}
