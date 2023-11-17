package backjon.dp;
import java.io.*;

//https://www.acmicpc.net/problem/11727
//2xn 타일링 2
public class DP3 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] array = new int[n+2]; //n=1일때, n+1만큼 크기 주면 에러떠서 n+2만큼 줌
		
		array[1] = 1;	//n=1일때, 1가지 
		array[2] = 3;	//n=2일때, 3가지
		for(int i = 3; i<=n; i++) {
			array[i] = (array[i-1] + (2*array[i-2])) % 10007;
		}
		System.out.println(array[n]);

	}

}
