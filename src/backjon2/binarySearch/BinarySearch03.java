package backjon2.binarySearch;

import java.io.*;
import java.util.*;

// https://acmicpc.net/problem/19637
// IF문 좀 대신 짜줘 (실3)

public class BinarySearch03 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		ArrayList<Info> array = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			
			array.add(new Info(Integer.parseInt(temp[1]),temp[0]));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<m; i++) {
			int no = Integer.parseInt(br.readLine());
			int left = 0;
			int right = n-1;
			
			while(left <= right) {
				int mid = (right + left)/2;
				if(array.get(mid).n < no) {
					left = mid+1;
				}else {
					right = mid-1;
				}
			}
			sb.append(array.get(left).name + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static class Info{
		int n;
		String name;
		
		public Info(int n, String name) {
			this.n = n;
			this.name = name;
		}
		
	}

}
