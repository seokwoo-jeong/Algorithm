package backjon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Implement3 {
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static int n;
	static int m;
	static int r;
	static int[][] matrix;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] def = in.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		m = Integer.parseInt(def[1]);
		r = Integer.parseInt(def[2]);
		
		matrix = new int[n][m];
		for(int i = 0; i < n; i++) {
			String[] line = in.readLine().split(" ");
			matrix[i] = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
		}
		
		int newN = n;
		int newM = m;
		for(int i = 0; i<Math.min(n, m)/2; i++) {
			rotate(i, 2*newN+2*newM-4);	//몇번째 껍대기인지, 껍대기 몇번돌면 원래 대로 돌아오는지
			newN -= 2;
			newM -= 2;
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void rotate(int squareCount, int originRotateCount) {
		int rotateCount = r % originRotateCount; //각 껍대기당 몇번 돌면 되는지
		for (int i = 0; i<rotateCount; i++) {
			int beforeX = squareCount;
			int beforeY = squareCount;
			int line = 0;	//껍대기 한면
			int startValue = matrix[squareCount][squareCount];
			
			while(line < dx.length) {
				int currentX = beforeX + dx[line];
				int currentY = beforeY + dy[line];
				
				if(currentX == squareCount && currentY == squareCount) {
					break;
				}
				
				if(squareCount<=currentX && currentX < n-squareCount && squareCount <= currentY && currentY < m - squareCount) {
					matrix[beforeX][beforeY] = matrix[currentX][currentY];
					 beforeX = currentX; 
					 beforeY = currentY;
				}else {
					line++;
				}
				
			}
			matrix[squareCount+1][squareCount] = startValue;		
			
		}
	}

}
