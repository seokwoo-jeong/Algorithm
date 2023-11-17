package backjon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Implement12 {
// https://www.acmicpc.net/problem/20327
// 배열 돌리기6
	static int maxSize;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def = br.readLine().split(" ");
		int n = Integer.parseInt(def[0]); // 2의n승
		int r = Integer.parseInt(def[1]); // 연산수

		maxSize = defSize(n);
		int[][] matrix = defMatrix(br);

		matrix = calculation(br, r, matrix);

		print(matrix);

	}

	private static int[][] calculation(BufferedReader br, int r, int[][] matrix) throws Exception {
		int[][] tempMatrix = matrix;
		int k;
		int l;
		for (int i = 0; i < r; i++) {
			String[] def = br.readLine().split(" ");
			k = Integer.parseInt(def[0]);
			l = Integer.parseInt(def[1]);
			tempMatrix = cal(tempMatrix, k, l);
		}

		return tempMatrix;

	}

	private static int[][] cal(int[][] tempMatrix, int k, int l) {
		int[][] matrix = tempMatrix;
		switch (k) {
		case 1:
			matrix = oneCal(matrix, l);
			break;
		case 2:
			matrix = twoCal(matrix, l);
			break;
		case 3:
			matrix = threeCal(matrix, l);
			break;
		case 4:
			matrix = fourCal(matrix, l);
			break;
		case 5:
			matrix = fiveCal(matrix, l);
			break;
		case 6:
			matrix = sixCal(matrix, l);
			break;
		case 7:
			matrix = sevenCal(matrix, l);
			break;
		case 8:
			matrix = eightCal(matrix, l);
			break;
		}
		return matrix;
	}

	private static int[][] oneCal(int[][] matrix, int l) {
		int[][] tempMatrix = matrix;
		int size = defSize(l);
		int startX;
		int startY;
		for(int i =0; i<=maxSize; i+= size) {
			startX = i;
			for(int j = 0; j<=maxSize-size; j+= size) {
				startY = j;
				tempMatrix = oneCalDetail(startX,startY,size,tempMatrix);
			}
		}
		return tempMatrix;
	}

	private static int[][] oneCalDetail(int startX, int startY, int size, int[][] matrix) {
		int[][] tempMatrix = matrix;
		for(int i = startX; i<(startX+size)/2; i++) {
			for(int j = startY; j<startY+size; j++) {
				System.out.println(i + " " + j);
				tempMatrix[i][j] = matrix[size-i-1][j];
				tempMatrix[size-i-1][j] = matrix[i][j];
				System.out.println(tempMatrix[size-i-1][j] + " d");
			}
		}
		System.out.println("--------");
		return tempMatrix;
	}

	private static int[][] twoCal(int[][] matrix, int l) {
		int[][] tempMatrix = matrix;
		int size = defSize(l);
	
		return tempMatrix;
	}

	private static int[][] threeCal(int[][] matrix, int l) {
		int[][] tempMatrix = matrix;
		int size = defSize(l);
	
		return tempMatrix;
	}

	private static int[][] fourCal(int[][] matrix, int l) {
		int[][] tempMatrix = matrix;
		int size = defSize(l);
	
		return tempMatrix;
	}

	private static int[][] fiveCal(int[][] matrix, int l) {
		int[][] tempMatrix = matrix;
		int size = defSize(l);
	
		return tempMatrix;
	}

	private static int[][] sixCal(int[][] matrix, int l) {
		int[][] tempMatrix = matrix;
		int size = defSize(l);
		
		return tempMatrix;
	}

	private static int[][] sevenCal(int[][] matrix, int l) {
		int[][] tempMatrix = matrix;
		int size = defSize(l);
	
		return tempMatrix;
	}

	private static int[][] eightCal(int[][] matrix, int l) {
		int[][] tempMatrix = matrix;
		int size = defSize(l);
	
		return tempMatrix;
	}

	private static int[][] defMatrix(BufferedReader br) throws Exception {
		int[][] matrix = new int[maxSize][maxSize];
		for (int i = 0; i < maxSize; i++) {
			String[] def = br.readLine().split(" ");
			for (int j = 0; j < def.length; j++) {
				matrix[i][j] = Integer.parseInt(def[j]);
			}
		}
		return matrix;
	}

	private static void print(int[][] matrix) {
		for (int i = 0; i < maxSize; i++) {
			for (int j = 0; j < maxSize; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static int defSize(int n) {
		int size = 1;
		for (int i = 0; i < n; i++) {
			size = size * 2;
		}
		return size;
	}

}
