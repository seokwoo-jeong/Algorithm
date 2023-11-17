package backjon.implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// https://www.acmicpc.net/problem/15662
// 톱니바퀴(2)

/* N극: 0 / S극: 1 
 * 12시부터 시계방향으로 N극/ S극 정보 제공
 * 시계방향: 1 / 반시계방향 : -1
 * 
 * 1. 돌리는 톱니바퀴 왼쪽 오른쪽 다른 극인지 확인
 * 2. 다른 극이면 반대 방향으로 돌려버림
 * 3. 돌아간 톱니바퀴를 기준으로 왼쪽 오른쪽 다른 극인지 확인
 * 4. 다른 극이면 반대 방향으로 돌려버림
 * 5. 1. ~ 2. 반복
 * 
 */
public class Implement6 {
	static char[][] gearArray;
	static int gearLength = 8;
	static int left = -1;
	static int right = 1;
	static int t;  //톱니바퀴 개수
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());	
		
		gearArray = new char[t][gearLength];	//톱니바퀴 array
		for(int i = 0; i<t; i++) {
			String temp = br.readLine();
			gearArray[i] = temp.toCharArray();
		}
		
		int k = Integer.parseInt(br.readLine());	//회전 횟수
		for(int i = 0; i<k; i++) {
			String[] def = br.readLine().split(" ");
			int gearNo = Integer.parseInt(def[0]);
			int rotation = Integer.parseInt(def[1]);
			
			Rotate currentGear = new Rotate(true, gearNo, rotation);	//기준 톱니바퀴
			Rotate leftGear = searchLeft(currentGear); //톱니바퀴 왼쪽 확인
			Rotate rightGear = searchRight(currentGear); //톱니바퀴 오른쪽 확인
			
			rotateGear(currentGear);	//기준 톱니바퀴 돌리기
			
			while(leftGear.isRotate || rightGear.isRotate) {		//왼쪽 혹은 오른쪽을 돌려야 하는 경우
				if(leftGear.isRotate) {	//왼쪽 톱니바퀴 돌려야하는 경우
					currentGear = leftGear;	//왼쪽 톱니바퀴를 현재 톱니바퀴로 바꿔줌
					leftGear = searchLeft(currentGear);	//현재 톱니바퀴의 왼쪽이 돌아갈수 있는지 확인
					rotateGear(currentGear);//현재 톱니바퀴 돌려보림
				}
				if(rightGear.isRotate) {//오른쪽 톱니바퀴 돌려야하는 경우
					currentGear = rightGear;//오른쪽 톱니바퀴를 현재 톱니바퀴로 바꿔줌
					rightGear = searchRight(currentGear);//현재 톱니바퀴의 오른쪽이 돌아갈 수 있는지 확인
					rotateGear(currentGear);//현재 톱니바퀴 돌림
				}
			}

		}
		int count = 0;
		for(int i = 0; i<t; i++) {
			if(gearArray[i][0] == '1') {	//12시방향 톱니바퀴가 s극인 경우
				count++;
			}
		}
		System.out.println(count);

	}
	private static Rotate searchRight(Rotate currentGear) {	//오른쪽 톱니바퀴 돌릴 수 있는지 확인
		Rotate temp = null;
		if(currentGear.gearNo == t) {//마지막 톱니바퀴인경우 오른쪽 없어서 못돌림
			temp = new Rotate(false,0,0);
			return temp;
		}
		
		char[] currentInfo = gearArray[currentGear.gearNo-1];
		char[] rightInfo = gearArray[currentGear.gearNo];
		
		if(currentInfo[2] != rightInfo[6]) { //접촉 극이 다른 극인 경우
			temp = new Rotate(true, currentGear.gearNo+1, getRotationDirection(currentGear.rotation));
		}else {//접촉 극이 같은 경우 
			temp = new Rotate(false,0,0);
		}
		
		return temp;
	}

	
	private static Rotate searchLeft(Rotate currentGear) {//왼쪽 톱니바퀴 돌릴 수 있는지 확인
		Rotate temp = null;
		if(currentGear.gearNo == 1) { //첫바퀴인 경우 왼쪽 없어서 못돌림
			temp = new Rotate(false,0,0);
			return temp;
		}
		char[] currentInfo = gearArray[currentGear.gearNo -1];
		char[] leftInfo = gearArray[currentGear.gearNo -2];
		
		if(currentInfo[6] != leftInfo[2]) {	//접촉극이 다른 경우
			temp = new Rotate(true, currentGear.gearNo-1, getRotationDirection(currentGear.rotation));
		}else {
			temp = new Rotate(false,0,0);
		}
		return temp;
	}
	
	private static void rotateGear(Rotate gearInfo) {
		if(gearInfo.rotation == left) {
			rotateLeft(gearInfo);	//기준 톱니바퀴 왼쪽으로 돌리기
		}else {
			rotateRight(gearInfo);	//기준 톱니바퀴 오른쪽으로 돌리기
		}
	}
	
	private static void rotateRight(Rotate gearInfo) {	//오른쪽으로 돌려버림
		char[] currentInfo = gearArray[gearInfo.gearNo -1];
		char[] tempInfo = new char[gearLength];
		tempInfo[0] = currentInfo[gearLength-1];
		for(int i = 1; i<gearLength; i++) {
			tempInfo[i] = currentInfo[i-1];
		}
		gearArray[gearInfo.gearNo -1] = tempInfo;
	}

	private static void rotateLeft(Rotate gearInfo) {//왼쪽으로 돌려버림
		char[] currentInfo = gearArray[gearInfo.gearNo -1];
		char[] tempInfo = new char[gearLength];
		
		tempInfo[gearLength -1] = currentInfo[0];
		for(int i = 0; i<gearLength-1; i++){
			tempInfo[i] = currentInfo[i+1];
		}
		gearArray[gearInfo.gearNo -1] = tempInfo;
		
	}
	


	private static int getRotationDirection(int rotation) {	//해당 톱니바퀴 어디 방향으로 돌아야 하는지 return
		int temp;
		if(rotation == right) {
			temp = left;
		}else {
			temp = right;
		}
		return temp;
	}


	public static class Rotate {
		boolean isRotate;	//해당 톱니바퀴 돌려야 할지 말아야 할지
		int gearNo; //해당 톱니바퀴 번호
		int rotation;	//해당 톱니바퀴 시계방향으로 돌려야 할지 반시계 방향으로 돌려야 할지
		
		public Rotate(boolean isRotate,  int gearNo, int rotation) {
			this.isRotate = isRotate;
			this.gearNo = gearNo;
			this.rotation = rotation;
		}
		
	}

}
