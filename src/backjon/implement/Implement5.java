package backjon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//https://www.acmicpc.net/problem/14890
//경사로
public class Implement5 {
	static int n;
	static int l;
	static int[][] matrix;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] def = in.readLine().split(" ");
		n = Integer.parseInt(def[0]);
		l = Integer.parseInt(def[1]);
		matrix = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			String[] line = in.readLine().split(" ");
			matrix[i] = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
		}
		
		for(int i = 0; i<n; i++) {
			solution(widthList(i));
			solution(heightList(i));
		}
		
		System.out.println(result);
	}
	
	private static void solution(int[] list) {
		int count = 0;
		int before = 0;
		int current = 0;
		boolean lower = false;
		for(int i = 0; i<list.length; i++) {
			before = current;
			current = list[i];
			if(before == 0) {	// list가장 처음 값 들어온 경우
				count++;
				continue;
			}
			if(lower) {//커졌다가 작아진 상황이 온 경우
				if(before == current) { //동일한 높이의 발판이 온 경우
					count++;
					if(count == l) {	//발판 놓을 공간이 있는 경우
						count = 0;
						lower = false;
					}
				}else {
					if(count != l) {	//동일한 높이의 발판이 오지 않았는데, 발판을 못 놓을 때
						break;
					}
				}
			}else {
				if(before == current) {	//현재값과 전값이 같은 경우
					count++;
				}else if(current - before == 1) { //작아 졌다간 커진 경우
					if(count >= l) {	//발판 놓을 충분한 공간이 있는 경우
						count = 1;
					}else {	//발판 놓을 충분한 공간이 없는 경우
						break;
					}
				}else if(before - current == 1) { // 큰곳에서 작은곳으로 간경우
					lower = true;
					count = 1;
					if(count == l) {	//발판 놓을 공간 있는 경우
						count = 0;
						lower = false;
					}
				}else {
					break;
				}
			}
			if(lower && i == n-1) {	//큰곳에서 작은 곳으로 간 경우가 유지중인데, 발판을 못 놓고 마지막 까지 온 경우
				break;
			}
			if(i == n-1) {	//열 OR 행을 끝까지 확인한 경우 이 열을 갈수 있다고 판단
				result++;
			}
		}
	}
	
	private static int[] widthList(int index) {	//가로열
		int[] list = new int[n];
		for(int i = 0; i<n; i++) {
			list[i] = matrix[index][i];
		}
		return list;
	}
	
	private static int[] heightList(int index) {	//세로열
		int[] list = new int[n];
		for(int i = 0; i<n; i++) {
			list[i] = matrix[i][index];
		}
		return list;
	}

}
