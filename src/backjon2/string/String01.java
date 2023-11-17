package backjon2.string;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

// https://www.acmicpc.net/problem/2870
// 수학숙제(실4)
public class String01 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<BigDecimal> result = new ArrayList<>();
		
		char[] array = null;
		StringBuilder buffer = new StringBuilder();
		for(int i = 0; i<n; i++) {
			array = br.readLine().toCharArray();
			
			buffer.delete(0, buffer.length());
			for(char temp : array) {
				if(Character.isDigit(temp)) {
					buffer.append(temp);
					continue;
				}
				addResult(buffer, result);
			}
			addResult(buffer, result);
		}
		
		Collections.sort(result);
		
		for(BigDecimal temp : result) {
			System.out.println(temp);
		}
	}
	
	private static void addResult(StringBuilder sb, ArrayList<BigDecimal> result) {
		if(sb.length() != 0) {
			BigDecimal bigDecimal = new BigDecimal(sb.toString());
			result.add(bigDecimal);
			sb.delete(0, sb.length());
		}
		
	}
	


}
