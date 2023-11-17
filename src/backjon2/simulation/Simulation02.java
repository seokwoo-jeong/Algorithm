package backjon2.simulation;
// https://www.acmicpc.net/problem/16926
// 배열 돌리기1 (실1)

import java.util.*;
import java.io.*;
public class Simulation02 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int r = Integer.parseInt(temp[2]);
		
		int[][] matrix = new int[n][m];
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			for(int j = 0; j<m; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i = 0; i<r; i++) {
			matrix = round(matrix);
		}
		
		for(int i = 0; i<matrix.length; i++) {
			for(int j = 0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static int[][] round(int[][] matrix){
		int n = matrix.length;
		int m = matrix[0].length;
		
		int[][] temp = new int[n][m];
		
		
		for(int frame = 0 ; frame<Math.min(n, m)/2; frame++) {	//껍대기 반복
			int nMax = n - frame -1;
			int mMax = m - frame - 1;
			for(int i = frame; frame <m-frame-1; i++) {
				
			}
		
		}
		

		return temp;
	}
}
