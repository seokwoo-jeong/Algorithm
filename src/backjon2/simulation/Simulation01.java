package backjon2.simulation;
// https://www.acmicpc.net/problem/16935

// 배열 돌리기3 (골5)

import java.io.*;
import java.util.*;

public class Simulation01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");

		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]); // matrix[n][m]
		int r = Integer.parseInt(temp[2]); // 연산 개수

		int[][] matrix = new int[n][m];

		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < temp.length; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
			}
		}

		temp = br.readLine().split(" ");
		int no = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < r; i++) {
			no = Integer.parseInt(temp[i]);

			switch (no) {
			case 1:
				matrix = one(matrix);
				break;
			case 2:
				matrix = two(matrix);
				break;
			case 3:
				matrix = three(matrix);
				break;
			case 4:
				matrix = four(matrix);
				break;
			case 5:
				matrix = five(matrix);
				break;
			case 6:
				matrix = six(matrix);
				break;
			}
			
		}
		print(matrix, matrix.length, matrix[0].length);
	}

	private static int[][] one(int[][] matrix) { // 상하 반전
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] temp = new int[n][m];

		int index = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				temp[index][j] = matrix[i][j];
			}
			index++;
		}

		return temp;
	}

	private static int[][] two(int[][] matrix) { // 좌우 반전
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] temp = new int[n][m];

		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				temp[i][index] = matrix[i][j];
				index++;
			}
			index = 0;
		}
		return temp;
	}

	private static int[][] three(int[][] matrix) { // 오른쪽 90도 회전
		int m = matrix[0].length;
		int n = matrix.length;
		
		int[][] temp = new int[m][n];
/*
		int lx = 0;
		int ly = 0;
		int rx = n - 1;
		int ry = 0;

		int lSize = n;
		int rSize = m;
		for (int z = 0; z < n / 2; z++) {
			for (int i = 0; i < 4; i++) { // 껍대기
				if (i == 0) { // 위
					for (int k = 0; k < lSize; k++) {
						temp[lx][ly] = matrix[rx][ry];
						ly++;
						rx--;
						
						print(temp,n,m);
						System.out.println("-------------");
					}
					ly--;
					rx++;
					
				} else if (i == 1) { // 오
					for (int k = 0; k < rSize; k++) {
						temp[lx][ly] = matrix[rx][ry];
						lx++;
						ry++;
					}
					lx--;
					ry--;
				} else if (i == 2) { // 아래
					for (int k = 0; k < lSize; k++) {
						temp[lx][ly] = matrix[rx][ry];
						ly--;
						rx++;
					}
					ly++;
					rx--;
				} else if (i == 3) { // 왼
					for (int k = 0; k < rSize; k++) {
						temp[lx][ly] = matrix[rx][ry];
						lx--;
						ry--;
					}
					lx++;
					ry++;
				}

			}
			lx++;
			ly++;
			rx--;
			ry++;
			lSize = lSize - 2;
			rSize = rSize - 2;
		}
	*/	
		for(int i = 0; i<m; i++) {
			for(int j =0; j<n; j++) {
				temp[i][j] = matrix[n-1-j][i];
			}
		}
		return temp;
	}

	private static int[][] four(int[][] matrix) { // 왼쪽 90도 회전
		int m = matrix[0].length;
		int n = matrix.length;
		
		int[][] temp = new int[m][n];
/*
		int lx = 0;
		int ly = 0;
		int rx = 0;
		int ry = m - 1;

		int lSize = n;
		int rSize = m;
		for (int z = 0; z < n / 2; z++) {
			for (int i = 0; i < 4; i++) { // 껍대기
				if (i == 0) { // 위
					for (int k = 0; k < lSize; k++) {
						temp[lx][ly] = matrix[rx][ry];
						ly++;
						rx++;
					}
					ly--;
					rx--;
				} else if (i == 1) { // 오
					for (int k = 0; k < rSize; k++) {
						temp[lx][ly] = matrix[rx][ry];
						lx++;
						ry--;
					}
					lx--;
					ry++;
				} else if (i == 2) { // 아래
					for (int k = 0; k < lSize; k++) {
						temp[lx][ly] = matrix[rx][ry];
						ly--;
						rx--;
					}
					ly++;
					rx++;
				} else if (i == 3) { // 왼
					for (int k = 0; k < rSize; k++) {
						temp[lx][ly] = matrix[rx][ry];
						lx--;
						ry++;
					}
					lx++;
					ry--;
				}
			}
			lx++;
			ly++;
			rx++;
			ry--;
			lSize = lSize - 2;
			rSize = rSize - 2;
		}
	*/
		for(int i = 0; i<m; i++) {
			for(int j =0; j<n; j++) {
				temp[i][j] = matrix[j][m-1-i];
			}
		}
		return temp;
	}

	private static int[][] five(int[][] matrix) { // 4그룹 오른쪽으로 이동
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] temp = new int[n][m];

		int lx = 0;
		int ly = 0;
		int rx = n / 2;
		int ry = 0;

		int lSize = n / 2;
		int rSize = m / 2;
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < lSize; k++) {
				for (int z = 0; z < rSize; z++) {
					temp[lx][ly] = matrix[rx][ry];
					ly++;
					ry++;
				}
				lx++;
				rx++;
				if(i == 0) {
					ly = 0;
					ry = 0;
				}else if (i==1) {
					ly = m/2;
					ry = 0;
				}else if(i==2) {
					ly=m/2;
					ry=m/2;
				}else {
					ly=0;
					ry = m/2;
				}
			}
			
			if(i==0) {
				lx = 0;
				ly = m/2;
				
				rx = 0;
				ry = 0;
				
			}else if(i==1) {
				lx = n/2;
				ly = m/2;
				
				rx=0;
				ry = m/2;
			}else if(i==2) {
				lx = n/2;
				ly = 0;
				
				rx = n/2;
				ry = m/2;
			}
			
		}
		return temp;
	}

	private static int[][] six(int[][] matrix) { // 4그룹 왼쪽으로 이동
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] temp = new int[n][m];

		int lx = 0;
		int ly = 0;
		int rx = 0;
		int ry = m/2;

		int lSize = n / 2;
		int rSize = m / 2;
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < lSize; k++) {
				for (int z = 0; z < rSize; z++) {
					temp[lx][ly] = matrix[rx][ry];
					ly++;
					ry++;
				}
				lx++;
				rx++;
				if(i == 0) {
					ly = 0;
					ry = m/2;
				}else if (i==1) {
					ly = m/2;
					ry = m/2;
				}else if(i==2) {
					ly=m/2;
					ry=0;
				}else {
					ly=0;
					ry =0;
				}
			}
			
			if(i==0) {
				lx = 0;
				ly = m/2;
				
				rx = n/2;
				ry = m/2;
				
			}else if(i==1) {
				lx = n/2;
				ly = m/2;
				
				rx= n/2;
				ry = 0;
			}else if(i==2) {
				lx = n/2;
				ly = 0;
				
				rx = 0;
				ry = 0;
			}

		}
		return temp;
	}



	private static void print(int[][] matrix, int x, int y) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}
}
