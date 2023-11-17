package backjon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/16926
//배열돌리기1

public class Implement2 {
	static int n;
	static int m;
	static int[] dx = {1,0,-1,0};	//아래, 오른쪽, 위, 왼쪽
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] def = in.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		m = Integer.parseInt(def[1]);
		int r = Integer.parseInt(def[2]);
		int[][] matrix = new int[n][m];
		for(int i = 0; i<n; i++) {
			String[] line = in.readLine().split(" ");
			matrix[i] = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
		}
		
		for(int i = 0; i<r; i++) {
			matrix =  rotate(matrix);
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static int[][] rotate(int[][] matrix) {
		int[][] rotateMatrix = new int[n][m];
		int squareCount = Math.min(n, m)/2;
		int count = 0;
		while(count < squareCount) {
			
			int beforeX = count;
			int beforeY = count;	//(0,0),(1,1),(2,2)에서 사각형이 시작된다.
			
			int index = 0;	//사각형의 한면
			while(index < dx.length) {
				int currentX = beforeX + dx[index];
				int currentY = beforeY + dy[index];
				if(0+count<=currentX && currentX< n-count && 0+count<=currentY && currentY<m-count ) {	//한 껍대기 들어갈 때마다 바깥 껍대기로 넘어가지 않게끔 범위 하나씩 줄여주어야 한다.
					rotateMatrix[currentX][currentY] = matrix[beforeX][beforeY];
					beforeX = currentX;
					beforeY = currentY;
				}else {
					index++;
				}
			}
			count++;
		}
		
		return rotateMatrix;
	}

}
