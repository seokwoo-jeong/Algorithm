package backjon.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/16967
// 배열 복원하기

/*
 * 안 겹치는 부분 먼저 설정
 * 겹치는 부분 찾아서 빼주기
 */

public class Implement11 {
	static int[][] b;
	static int[][] a;
	static int h;
	static int w;
	static int x;
	static int y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def = br.readLine().split(" ");

		h = Integer.parseInt(def[0]);
		w = Integer.parseInt(def[1]);
		x = Integer.parseInt(def[2]);
		y = Integer.parseInt(def[3]);
		
		b = new int[h + x][w + y];
		a = new int[h][w];
		
		for (int i = 0; i < h + x; i++) { // 메트릭스 선언
			String[] def2 = br.readLine().split(" ");
			for (int j = 0; j < def2.length; j++) {
				b[i][j] = Integer.parseInt(def2[j]);
				if((i <h && j <w) || (i <x && j<y)) {
					a[i][j] = b[i][j];
				}
			}
		}

		defineA();
		print();

	}

	private static void print() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
			
		}
		
	}

	private static void defineA() {
		for (int i = x; i <h; i++) {
			for (int j = y; j < w; j++) {
				if(isContainB(i, j)) {
					a[i][j] = b[i][j] - a[i - x][j - y];
				}
			}
		}

	}
	private static boolean isContainB(int currentX, int currentY) {
		boolean flag = false;
		if (currentX < h + x && currentY < w + y) { // b에속하는경우
			flag = true;
		}
		return flag;
	}

}
