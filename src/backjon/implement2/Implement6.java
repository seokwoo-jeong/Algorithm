package backjon.implement2;
import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/17780
//새로운 게임

/*
 * 체스판:N X N
 * 말 개수: K개
 * 1. 하나의 말 위에 다른 말 올릴 수 있음
 * 2. 체스판은 흰색, 빨간, 파란색 중 하나로 색칠되어있음
 * 3. 체스판 위에 K개의 말을 놓고 시작
 * 4. 말은 1~K번 까지의 번호가 매겨져 있음
 * 5. 말은 이동방향이 정해져 있으며, 이동 방향은 위,아래,왼쪽, 오른쪽 4가지중 하나이다.
 * 
 * 6. 한턴당 1번~K번까지의 말이 순서대로 움직임
 * 7. 말이 올라가 있는 경우, 같이 움직이며 가장 아래의 말만 이동 가능
 * 
 * 8. 이동하려는 칸의 색깔에 따라서 행위가 달라짐
 * 8-1. 이동하려는 칸: 흰색
 *      - 기존꺼 위에 올린다.
 * 8-2. 이동하려는 칸: 빨간색
 *      - 기존꺼 위에 올리고, 올라간 애들 순서 바꾼다.
 *        EX) A,B 빨간색에 있고, D,E,F가 올라올 때, 결과는? -> A,B,F,E,D
 * 8-3. 이동하려는 칸: 파란색
 *      - 말의 이동방향을 반대로 하고 한칸 이동.
 *      - 반대로 하고 이동하려고 했는데, 그 칸이 파란색이다? 그럼 이동하지 않고 방향만 바뀐채로 냅둔다.
 * 8-4. 체스판을 벗어나는 경우: 파란색과 동일
 */
public class Implement6 {
	private static int n;
	private static int k;
	private static int[][] matrix;
	private static int[] dx = {0,0,-1,1}; //오,왼,위,아래
	private static int[] dy = {1,-1,0,0};
	private static int[] change = {1,0,3,2};
	private static LinkedList<Integer>[][] stack;
	private static Horse[] horses;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		
		matrix = new int[n][n];	//0:흰색, 1:빨간색, 2:파란색
		stack = new LinkedList[n][n];
		horses = new Horse[k];
		
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			for(int j = 0; j<n; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
				stack[i][j] = new LinkedList<>();
			}
		}
		
		for(int i = 0; i<k; i++) {
			temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]) -1;
			int y = Integer.parseInt(temp[1]) -1;
			int dir = Integer.parseInt(temp[2])-1;
			stack[x][y].add(i);
			
			horses[i] = new Horse(x,y,dir);
		}
		
		int count = 0;
		boolean flag = false;
		while(count < 1000) {
			count++;
			
			for(int i = 0; i<horses.length; i++) {
				int x = horses[i].x;
				int y = horses[i].y;
				
				if(stack[x][y].get(0) != i) {	//현재 말이 가장 아래에 있는 놈이 아니라면 continue
					continue;
				}
				
				int nx = x + dx[horses[i].dir];
				int ny = y + dy[horses[i].dir];
				
				if(isOut(nx,ny) || matrix[nx][ny] == 2) { //매트릭스 나가거나 파란색 만난 경우
					horses[i].dir = change[horses[i].dir];
					nx = x + dx[horses[i].dir];
					ny = y + dy[horses[i].dir];
				}
				
				if(isOut(nx,ny) || matrix[nx][ny] == 2) { // 또 매트릭스 나가거나 파란색 만난 경우
					continue;
				}else if(matrix[nx][ny] == 0) {	//흰색
					for(int z = 0; z<stack[x][y].size(); z++) {
						int horseNo = stack[x][y].get(z);
						stack[nx][ny].add(horseNo);
						horses[horseNo].x = nx;
						horses[horseNo].y = ny;
 					}
					stack[x][y].clear();
				}else if(matrix[nx][ny] == 1) {	//빨간색
					for(int z = stack[x][y].size()-1; z>=0; z--) {
						int horseNo = stack[x][y].get(z);
						stack[nx][ny].add(horseNo);
						horses[horseNo].x = nx;
						horses[horseNo].y = ny;
 					}
					stack[x][y].clear();
				}
				
				if(stack[nx][ny].size() >= 4) {
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
			
		}
		if(count >= 1000) {
			System.out.println(-1);
		}else {
			System.out.println(count);
		}
	}
	private static boolean isOut(int x, int y) {
		if(0<= x && x < n && 0<= y && y < n) {
			return false;
		}
		return true;
	}
	
	
	private static class Horse{
		int x;
		int y;
		int dir;
		public Horse(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}
