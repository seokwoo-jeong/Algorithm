package backjon2.greedy;

import java.io.*;

// https://www.acmicpc.net/problem/14916
// 거스름돈 (실5)

public class Greedy02_RE {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		
		if(n == 1 || n==3) {
			System.out.println(-1);
			return;
		}
		
		int a = n / 5;			// 2   3
		int b = (n % 5) /2;		// 1   1
		
		if( (n % 5) % 2 == 0) {
			System.out.println(a+b);
		}else {
			System.out.println(a-1 + b+3);
		}
	}

}
