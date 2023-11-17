package backjon2.implement;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/15662
// 톱니바퀴(2) (골5)
public class Implement08 {
	private static int t;
	private static char[][] matrix;
	private static boolean[] isVisit;
	private static ArrayList<int[]> rotateArray;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		matrix = new char[t][8];
		isVisit = new boolean[t];
		for (int i = 0; i < t; i++) {
			matrix[i] = br.readLine().toCharArray();
		}

		int k = Integer.parseInt(br.readLine());

		String[] temp = null;
		int no = 0;
		int dir = 0;
		for (int i = 0; i < k; i++) {
			temp = br.readLine().split(" ");

			no = Integer.parseInt(temp[0]) - 1;
			dir = Integer.parseInt(temp[1]);

			isVisit = new boolean[t];
			rotateArray = new ArrayList<>();

			rotateArray.add(new int[] { no, dir });
			getRotateArray(no, dir);

			for (int[] info : rotateArray) {
				if (info[1] == 1) {
					rotate(info[0]);
				} else {
					reverseRotate(info[0]);
				}
			}
		}
		int result = 0;
		for (int i = 0; i < t; i++) {
			if (matrix[i][0] == '1') {
				result++;
			}
		}
		System.out.println(result);
	}

	private static void insertRotateArray(int cur, int cIndex, int next, int nIndex, int dir) {
		if (matrix[cur][cIndex] != matrix[next][nIndex] && !isVisit[next]) {
			rotateArray.add(new int[] { next, -dir });
			getRotateArray(next, -dir);
		}
	}

	private static void getRotateArray(int no, int dir) {
		if (t == 1 || isVisit[no]) {
			return;
		}
		isVisit[no] = true;
		if (no == 0) {
			insertRotateArray(no, 2, no + 1, 6, dir);
		} else if (no == t - 1) {
			insertRotateArray(no, 6, no - 1, 2, dir);
		} else {
			insertRotateArray(no, 2, no + 1, 6, dir);
			insertRotateArray(no, 6, no - 1, 2, dir);
		}

	}

	private static void rotate(int no) {
		char[] temp = new char[8];

		for (int i = 1; i < temp.length; i++) {
			temp[i] = matrix[no][i - 1];
		}
		temp[0] = matrix[no][temp.length - 1];

		matrix[no] = temp;
	}

	private static void reverseRotate(int no) {
		char[] temp = new char[8];

		for (int i = 0; i < temp.length - 1; i++) {
			temp[i] = matrix[no][i + 1];
		}
		temp[temp.length - 1] = matrix[no][0];

		matrix[no] = temp;
	}

}
