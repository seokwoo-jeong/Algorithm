package backjon.twopoint;
import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/1644
// 소수의 연속합
public class TwoPoint5 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> array = new LinkedList<>();
		
		int cur = 2;	//현재 값
		int sum = 0;
		int result = 0;
		while(cur <= n) {
			if(!isPrime(cur)) {	//소수가 아닌 경우
				cur++;
				continue;
			}
			/*
			for(int a : array) {
				System.out.print(a + " ");
			}
			System.out.print(sum);
			System.out.println();
			*/
			if(sum < n) {
				if(cur == n) {
					array.add(cur);
					sum -= array.getFirst();
					array.removeFirst();
					sum+= cur;
					result++;
					break;
				}
				array.add(cur);
				sum += cur;
				cur++;
			}else if(sum>n) {
				sum -= array.getFirst();
				array.removeFirst();
			}else {
				result++;

				sum -= array.getFirst();
				array.removeFirst();
			}
		}
		System.out.println(result);
	}
	
	private static boolean isPrime(int num) {
		if(num == 2 || num == 3) {
			return true;
		}
		
		boolean temp = false;
		int end = (int)Math.sqrt(num);
		
		for(int i =2; i<=end; i++) {
			if(num%i==0) {
				temp = false;
				break;
			}else {
				temp = true;
			}
		}
		return temp;
	}

}
