package backjon.dp;
import java.util.*;

//https://www.acmicpc.net/problem/11726
//2×n 타일링
public class DP2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n+2]; //n=1인경우때문에 n+2해줘야 함
		
		array[1] = 1;	//n=1인 경우, 1개
		array[2] = 2;	//n=2인 경우, 2개
		for(int i = 3; i<=n; i++) {
			array[i] = (array[i-1] + array[i-2])%10007;	 //n=k 인경우, k-1 + k-2
		}
		System.out.println(array[n]);
		
		

	}

}
