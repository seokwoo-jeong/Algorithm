package backjon2.greedy;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2141
// 우체국 (골4)

public class Greedy10 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		
		long x = 0;
		long y = 0;
		String[] temp = null;
		Info[] array = new Info[n];
		long totalPeople = 0;
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			x = Integer.parseInt(temp[0]);
			y = Integer.parseInt(temp[1]);
			
			Info info = new Info(x, y);
			array[i] = info;
			totalPeople += y;
		}
		
		Arrays.sort(array);
		
		long curPeople = 0;
		long result = 0;
		for(Info info : array) {
			curPeople += info.y;
			
			if(curPeople >= (totalPeople+1)/2) {	// 49 : 50 일때, 더 큰 쪽에 설치하려면 +1 을 해줘야 함
				result = info.x;
				break;
			}
		}
		
		System.out.println(result);

	}
	
	private static class Info implements Comparable<Info>{
		long x;
		long y;
		public Info(long x, long y) {
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Info o) {
			return (int) (this.x - o.x);
		}
	}

}
