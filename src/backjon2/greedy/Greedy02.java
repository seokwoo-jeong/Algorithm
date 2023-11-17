package backjon2.greedy;

import java.io.*;

// https://www.acmicpc.net/problem/14916
// 거스름돈 (실5)

public class Greedy02 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int result = 0;
		if((n%5) % 2 == 0) {//5로나눈 나머지가 짝수인 경우
			result = n/5 + ((n%5)/2);
		}else {
			if(n/5 == 0) {
				result = -1;
			}else {
				result = n/5 -1 + ((n%5+5)/2);	
			}
		}
		
		System.out.println(result);
	}

}
