package backjon.implement;

import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/1913
//달팽이
public class Implement13 {
	static int[][] matrix;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		matrix = new int[n][n];

		defMatrix(num);
		int resultX = 0;
		int resultY = 0;
        for(int i = 0; i<n; i++) {
        	for(int j = 0; j<n; j++) {
        		bw.append((matrix[i][j] + " ").toString());
        		
        		if(matrix[i][j] == num) {
        			resultX = i+1;
        			resultY = j+1;
        		}
        	}
        	bw.newLine();
        }
        bw.append((resultX + " " + resultY).toString());
        
        bw.flush();
        bw.close();
	}

	public static void defMatrix(int num) {
		int currentNum = n * n;
		int currentX = 0;
		int currentY = 0;
		int startSize = 0;
		int finishSize = n - 1;

		while (currentNum > 1) {
			for (int i = currentX; i < finishSize; i++) {
				matrix[i][currentY] = currentNum;
				currentNum--;
			}
			currentX = finishSize;

			for (int i = currentY; i < finishSize; i++) {
				matrix[currentX][i] = currentNum;
				currentNum--;
			}
			currentY = finishSize;

			for (int i = currentX; i > startSize; i--) {
				matrix[i][currentY] = currentNum;
				currentNum--;
			}
			currentX = startSize;

			for (int i = currentY; i > startSize; i--) {
				matrix[currentX][i] = currentNum;
				currentNum--;
			}
			startSize++;
			finishSize--;

			currentX = startSize;
			currentY = startSize;

		}
		matrix[currentX][currentY] = currentNum;
	}
}