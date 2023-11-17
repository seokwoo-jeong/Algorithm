package backjon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14499
// 주사위 굴리기
public class Implement4 {
	static int n;
	static int m;
	static int[][] matrix;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] def = in.readLine().split(" ");
		n = Integer.parseInt(def[0]); //세로길이
		m = Integer.parseInt(def[1]); //가로길이
		int x = Integer.parseInt(def[2]); //시작 x위치
		int y  = Integer.parseInt(def[3]); //시작 y위치
		int k = Integer.parseInt(def[4]); //명령 개수
		matrix = new int[n][m];
		
		for(int i = 0; i<n; i++) {//지도 정의
			String[] line = in.readLine().split(" ");
			matrix[i] = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
		}
		
		String[] orderLine = in.readLine().split(" "); //명령 array정의
		int[] order = Arrays.stream(orderLine).mapToInt(Integer::parseInt).toArray();
		int[] location = {x,y};
		Dice dice = new Dice();
		for(int i :order) {
			if(isOut(moveLocatin(i,location))) {	//위치 옮겨보고 나갔는지 안나갔는지 판단
				continue;
			}
			location = moveLocatin(i,location);	//위치 안나갔으면 새로운 위치로 바꿔줌
			System.out.println(dice.moveDice(i,location));
		}
		

	}
	
	private static boolean isOut(int[] location) {
		if(0<= location[0] && location[0]< n && 0<= location[1] && location[1]< m) {
			return false;	//안나감
		}
		return true;	//나감
	}
	public static int[] moveLocatin(int order, int[] location) {
		int[] moveLocation = new int[2];
		switch(order) {
		case 1:	//동쪽
			moveLocation[0] = location[0];
			moveLocation[1] = location[1] + 1;
			break;
		case 2:	//서쪽
			moveLocation[0] = location[0];
			moveLocation[1] = location[1] - 1;
			break;
		case 3:	//남쪽
			moveLocation[0] = location[0] - 1;
			moveLocation[1] = location[1];
			break;
		case 4:	//북쪽
			moveLocation[0] = location[0] + 1;
			moveLocation[1] = location[1];
			break;
		default:
			break;
		}
	return moveLocation;
	}

	public static class Dice {
		int top;			//위
		int bottom;			//아래
		int right;			//오른쪽
		int left;			//왼쪽
		int front;			//앞면
		int back;			//뒷면
		public Dice() {
			this.top = 0;
			this.bottom = 0;
			this.right = 0;
			this.left = 0;
			this.front = 0;
			this.back = 0;
		}
		public int moveDice(int order, int[] location) {
			int tempTop = this.top;
			int tempBottom = this.bottom;
			int tempRight = this.right;
			int tempLeft = this.left;
			int tempFront = this.front;
			int tempBack = this.back;
			switch(order) {
			case 1:	//동쪽
				this.top = tempLeft;
				this.bottom = tempRight;
				this.right = tempTop;
				this.left = tempBottom;
				diceBottomChange(location);
				break;
			case 2:	//서쪽
				this.top = tempRight;
				this.bottom = tempLeft;
				this.right = tempBottom;
				this.left = tempTop;
				diceBottomChange(location);
				break;
			case 3:	//북쪽
				this.top = tempBack;
				this.bottom = tempFront;
				this.front = tempTop;
				this.back = tempBottom;
				diceBottomChange(location);
				break;
			case 4:	//남쪽
				this.top = tempFront;
				this.bottom = tempBack;
				this.front = tempBottom;
				this.back = tempTop;
				diceBottomChange(location);
				break;
			default:
				break;
			}
			return this.top;
		}
		
		public void diceBottomChange(int[] location) {
			if(matrix[location[0]][location[1]] == 0) {//현재 주사위 위치의 지도값이 0인경우
				matrix[location[0]][location[1]] = this.bottom;
			}else {//현재 주사위 위치의 지도값이 0이 아닌경우
				this.bottom = matrix[location[0]][location[1]];
				matrix[location[0]][location[1]] = 0;
			}
		}
		
		
	}
}
