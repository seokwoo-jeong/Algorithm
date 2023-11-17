package backjon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/16935
//배열 돌리기3

//인덱스 고려하는데 진짜 미치는줄... 2시간 넘게 소요함
public class Implement1 {
	static int n;
	static int m;
	static int r;
	static int[][] originMatrix;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] def = in.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		m = Integer.parseInt(def[1]);
		r = Integer.parseInt(def[2]);
	
		originMatrix = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			String[] line = in.readLine().split(" ");
			originMatrix[i] = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
		}
		
		String[] howChange = in.readLine().split(" ");
		
		for(int i = 0; i<howChange.length; i++) {
			change(Integer.parseInt(howChange[i]));
		}
		
		for(int i = 0; i<originMatrix.length; i++) {
			for(int j = 0; j<originMatrix[0].length; j++) {
				System.out.print(originMatrix[i][j] + " ");
			}
			System.out.println();
		}

	}
	private static void change (int changeNumber) {
		switch(changeNumber) {
		case 1:	//상하반전
			originMatrix = one();
			break;
		case 2:	//좌우반전
			originMatrix= two();
			break;
		case 3: //오른쪽90도 회전
			originMatrix = three();
			break;
		case 4: //왼쪽90도 회전
			originMatrix = four();
			break;
		case 5: //4등분해서 시계방향으로 회전
			originMatrix = five();
			break;
		case 6: //4등분 해서 반시계방향으로 회전
			originMatrix = six();
			break;
		}
	}
	private static int[][] one() {
		int n = originMatrix.length;
		int m = originMatrix[0].length;
		int[][] tempMatrix = new int[n][m];
		for(int i = 0; i<n/2; i++) {
			for(int j = 0; j<m; j++) {
				tempMatrix[i][j] = originMatrix[n-1-i][j]; 
				tempMatrix[n-1-i][j] = originMatrix[i][j];
			}
		}
		return tempMatrix;
	}
	private static int[][]  two() {
		int n = originMatrix.length;
		int m = originMatrix[0].length;
		int[][] tempMatrix = new int[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m/2; j++) {
				tempMatrix[i][j] = originMatrix[i][m-1-j];
				tempMatrix[i][m-1-j] = originMatrix[i][j];
			}
		}
		return tempMatrix;
	}
	private static int[][]  three() {
		int n = originMatrix.length;
		int m = originMatrix[0].length;
		int[][] temp = new int[m][n];
		for(int i = 0; i<m; i++) {
			for(int j =0; j<n; j++) {
				temp[i][j] = originMatrix[n-1-j][i];
			}
		}
		return temp;
	}
	private static int[][]  four() {
		int n = originMatrix.length;
		int m = originMatrix[0].length;
		int[][] temp = new int[m][n];
		for(int i = 0; i<m; i++) {
			for(int j =0; j<n; j++) {
				temp[i][j] = originMatrix[j][m-1-i];
			}
		}
		return temp;
	}
	
	
	private static int[][]  five() {
		int n = originMatrix.length;
		int m = originMatrix[0].length;
		int[][] tempMatrix = new int[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(i<n/2 && j<m/2) {	// 1구간
					tempMatrix[i][j] = originMatrix[(n/2)+i][j];
				}else if(i<n/2 && j>= m/2) {	// 2구간
					tempMatrix[i][j] = originMatrix[i][j-(m/2)];
				}else if (i>=n/2 && j>=m/2) {	// 3구간
					tempMatrix[i][j] = originMatrix[i-(n/2)][j];
				}else {
					tempMatrix[i][j] = originMatrix[i][j+(m/2)];
				}
			}
		}
		return tempMatrix;
	}

	private static int[][]  six() {
		int n = originMatrix.length;
		int m = originMatrix[0].length;
		int[][] tempMatrix = new int[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(i<n/2 && j<m/2) {	// 1구간
					tempMatrix[i][j] = originMatrix[i][(m/2)+j];
				}else if(i<n/2 && j>= m/2) {	// 2구간
					tempMatrix[i][j] = originMatrix[(n/2)+i][j];
				}else if (i>=n/2 && j>=m/2) {	// 3구간
					tempMatrix[i][j] = originMatrix[i][j-(m/2)];
				}else {
					tempMatrix[i][j] = originMatrix[i-(n/2)][j];
				}
			}
		}
		return tempMatrix;
	}
	

}
