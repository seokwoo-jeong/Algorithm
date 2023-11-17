package backjon.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//https://www.acmicpc.net/problem/15685
//드래곤 커브

public class Implement8 {
	
	static int[][] matrix = new int[101][101];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> directionArray = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] def = br.readLine().split(" ");
			int x = Integer.parseInt(def[0]); // x
			int y = Integer.parseInt(def[1]); // y
			int d = Integer.parseInt(def[2]); // 방향
			int g = Integer.parseInt(def[3]); // 세대수
			
			directionArray = getDirectionArray(d, g);	//방향구하기
			drawDragonCurve(x,y,directionArray);		//방향기준으로 점찍기
		}
		int result = 0;
		
		result = getSquareCount();	//정사각형구하기
		
		System.out.println(result);

	}

	private static int getSquareCount() {	//정사각형 완전탐색
		int temp = 0;
		for(int i = 0; i<matrix.length-1; i++) {
			for (int k = 0; k<matrix.length-1; k++) {
				if(matrix[i][k] == 1 && matrix[i][k+1] == 1 && matrix[i+1][k] == 1 && matrix[i+1][k+1] == 1) {
					temp++;
				}
			}
		}
		return temp;
	}

	private static void drawDragonCurve(int x, int y, ArrayList<Integer> directionArray) {//마지막점을 기준으로 방향에따라 점 추가
		int dx = x;
		int dy = y;
		matrix[dx][dy] = 1;
		for(int i = 0; i<directionArray.size(); i++) {
			switch(directionArray.get(i)) {
			case 0:	//동
				matrix[dx+1][dy] = 1;
				dx++;
				break;
			case 1: //븍
				matrix[dx][dy-1] = 1;
				dy--;
				break;
			case 2: //서
				matrix[dx-1][dy] = 1;
				dx--;
				break;
			case 3: //남
				matrix[dx][dy+1] = 1;
				dy++;
				break;
			}
		}
		
	}

	private static ArrayList<Integer> getDirectionArray(int d, int g) {	//방향 구하기
		ArrayList<Integer> directionArray = new ArrayList<>();
		directionArray.add(d);
		for(int i = 0; i<g; i++) {
			int size = directionArray.size();
			for(int j = size-1; j>=0; j--) {
				directionArray.add((directionArray.get(j)+1) % 4);
			}
		}
		return directionArray;
	}


}
