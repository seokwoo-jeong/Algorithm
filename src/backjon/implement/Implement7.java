package backjon.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/14503
//로봇 청소기

/*
 * 1. 현재위치 청소
 * 2. if(현재위치 바로 왼쪽 청소x){
 * 		왼쪽으로 회전후 전진해서 청소
 * 	  }else{
 * 	  	왼쪽으로 회전
 * 		count++;
 *    }
 * 3. if(count == 4){
 *    	if(바로 뒤 벽){
 *    		break;
 *      }else{
 *      	뒤로 한칸 후진
 *      }
 *    }   
 *    
 */
public class Implement7 {
	static int[][] matrix;
	static int result;
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def = br.readLine().split(" ");
		n = Integer.parseInt(def[0]); // 세로
		m = Integer.parseInt(def[1]); // 가로
		matrix = new int[n][m];
		String[] def2 = br.readLine().split(" ");
		int r = Integer.parseInt(def2[0]);
		int c = Integer.parseInt(def2[1]);
		int direction = Integer.parseInt(def2[2]); // 0북, 1동, 2남, 3서

		for (int i = 0; i < n; i++) {
			String[] def3 = br.readLine().split(" ");
			for (int j = 0; j < def3.length; j++) {
				matrix[i][j] = Integer.parseInt(def3[j]);
			}
		}
		int count = 0;
		result = 0;
		CurrentInfo currentInfo = new CurrentInfo(r, c, direction);
		clean(currentInfo);
		while (true) {
			//System.out.println(currentInfo.x + " " + currentInfo.y + "  " + currentInfo.direction +" " + count);
			if (isLeftNotCleanAndEmpty(currentInfo)) { // 현재위치 바로 왼쪽 청소안되어있고 빈공간 인 경우
				currentInfo.setDirection(changeDirectionToLeft(currentInfo)); // 방향왼쪽으로돌리기
				currentInfo = goFront(currentInfo); // 앞으로가기
				clean(currentInfo); // 청소하기
				count = 0;
			} else {
				currentInfo.setDirection(changeDirectionToLeft(currentInfo)); // 방향왼쪽으로돌리기
				count++;
			}
			if (count == 4) { // 위에 짓거리 4번 한 경우
				if (isBackWall(currentInfo)) { // 바로 뒤가 벽이다
					break;
				} else {
					currentInfo = goBack(currentInfo);
					clean(currentInfo); // 청소하기
					count=0;
				}
			}
		}
		System.out.println(result);
	}

	private static CurrentInfo goBack(CurrentInfo currentInfo) {
		CurrentInfo temp = currentInfo;
		switch (temp.direction) {
		case 0: // 북
			temp.setX(temp.x + 1);
			break;
		case 1:// 동
			temp.setY(temp.y - 1);
			break;
		case 2:// 남
			temp.setX(temp.x - 1);
			break;
		case 3:// 서
			temp.setY(temp.y + 1);
			break;
		}
		return temp;
	}

	private static boolean isBackWall(CurrentInfo currentInfo) {
		boolean flag = false;
		switch (currentInfo.direction) {
		case 0:// 북
			if(matrix[currentInfo.x+1][currentInfo.y] == 1) {
				flag = true;
			}
			break;
		case 1:// 동
			if(matrix[currentInfo.x][currentInfo.y-1] == 1) {
				flag = true;
			}
			break;
		case 2:// 남
			if(matrix[currentInfo.x-1][currentInfo.y] == 1) {
				flag = true;
			}
			break;
		case 3:// 서
			if(matrix[currentInfo.x][currentInfo.y+1] == 1) {
				flag = true;
			}
			break;
		}
		return flag;
	}

	private static CurrentInfo goFront(CurrentInfo currentInfo) {// 앞으로가기
		CurrentInfo temp = currentInfo;
		switch (temp.direction) {
		case 0: // 북
			temp.setX(temp.x - 1);
			break;
		case 1:// 동
			temp.setY(temp.y + 1);
			break;
		case 2:// 남
			temp.setX(temp.x + 1);
			break;
		case 3:// 서
			temp.setY(temp.y - 1);
			break;
		}
		return temp;
	}

	private static int changeDirectionToLeft(CurrentInfo currentInfo) { // 방향왼쪽으로돌리기
		int direction;
		if (currentInfo.direction == 0) {
			direction = 3;
		} else {
			direction = currentInfo.direction - 1;
		}
		return direction;

	}

	private static boolean isLeftNotCleanAndEmpty(CurrentInfo currentInfo) {// 현재위치 바로 왼쪽 청소안되어있고 빈공간 인 경우
		boolean flag = false;
		switch (currentInfo.direction) {
		case 0: // 북쪽보고있는경우
			if (matrix[currentInfo.x][currentInfo.y - 1] == 0) {
				flag = true;
			}
			break;
		case 1: // 동쪽보고있는경우
			if (matrix[currentInfo.x - 1][currentInfo.y] == 0) {
				flag = true;
			}
			break;
		case 2: // 남쪽보고있는경우
			if (matrix[currentInfo.x][currentInfo.y + 1] == 0) {
				flag = true;
			}
			break;
		case 3: // 서쪽보고있는경우
			if (matrix[currentInfo.x + 1][currentInfo.y] == 0) {
				flag = true;
			}
			break;
		}
		return flag;
	}

	private static void clean(CurrentInfo currentInfo) { // 청소하기
		if (matrix[currentInfo.x][currentInfo.y] == 0) { // 빈공간이면서 청소안한경우
			result++; // 청소++
			matrix[currentInfo.x][currentInfo.y] = 2; // 빈공간인데 청소한 경우면 2로 표시
		}

	}

	public static class CurrentInfo {
		int x;
		int y;
		int direction;

		public CurrentInfo(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void setDirection(int direction) {
			this.direction = direction;
		}

	}

}
