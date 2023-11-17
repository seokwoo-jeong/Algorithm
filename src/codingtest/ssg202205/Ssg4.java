package codingtest.ssg202205;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

//int[][] macaron = {{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};
public class Ssg4 {
	static int[] dx = {1,0,0,-1};
	static int[] dy = {0,-1,1,0};
	static int max = 6;
	static int[][] matrix;
	static int[][] visit;
	public String[] solution(int[][] macaron) {
		String[] answer = new String[max];
		matrix = new int[max][max];
		visit = new int[max][max];
		boolean flag = false;
		
		
		for(int i = 0; i<macaron.length; i++) {
			matrix = dropMacaron(macaron[i]);	//마카론 배열 하나 읽어서 메트릭스에 세팅
			Bomb bomb = isBomb();
			flag = bomb.bomb;		//터지는지 확인
			while(flag) {
				matrix = bombMatrix(bomb);  //폭발
				reset();
				bomb = isBomb();
				flag = bomb.bomb;
			}
			reset();
		}
		
		
		for(int i = 0; i<max; i++) {
			for(int j = 0; j<max; j++) {
				answer[i] += matrix[i][j];
				answer[i] = answer[i].replace("null", "");
			}
		}
		return answer;
	}
	
	private void reset() {
		for(int i =0; i<max; i++) {
			for(int j = 0; j<max; j++) {
				visit[i][j] = 0;
			}
		}
		
	}

	public Bomb isBomb() {		//폭발하는지 확인
		Bomb bomb = new Bomb();
		boolean flag =false;
		for(int i = max-1; i>=0; i--) {
			for(int j = 0; j<max; j++) {
				if(matrix[i][j] != 0) {	//마카론 있는 구간을 찾음
					
					int count = 1;
					bomb.bombArray[0][0] = i;
					bomb.bombArray[0][1] = j;
					bomb = bfs(bomb,i,j,count);
					if(bomb.count >= 3) {
						bomb.bomb = true;
						flag = true;
						break;
					}
				}
			}
			if(flag) {
				break;
			}
		}
		return bomb;
	}

	private Bomb bfs(Bomb bomb,int x, int y, int count) {
		Bomb tempBomb = bomb;
		tempBomb.color = matrix[x][y];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visit[x][y]= 1;
		tempBomb.count = count;
		while(!queue.isEmpty()) {
			int[] before = queue.poll();
			int bx = before[0];
			int by = before[1];
			
			for(int z = 0; z<4; z++) {
				int nx = dx[z] + bx;
				int ny = dy[z] + by;
				
				if(0<=nx && nx < max && 0<=ny && ny<max) {	//메트릭스 안넘어간 경우
					if(matrix[bx][by] == matrix[nx][ny] && visit[nx][ny] == 0) {//동일한 색 찾은 경우
						queue.add(new int[] {nx,ny});
						visit[nx][ny] = 1;
						tempBomb.bombArray[tempBomb.count][0] = nx;
						tempBomb.bombArray[tempBomb.count][1] = ny;
						tempBomb.count = tempBomb.count+1;
					}
				}
			}
			
		}
		return tempBomb;
	}
	
	private int[][] bombMatrix(Bomb bomb) {
		int[][] temp = matrix;
		Arrays.sort(bomb.bombArray, Comparator.comparingInt(o1 ->o1[0]));
		for(int i = 0; i<bomb.bombArray.length; i++) {
			int x = bomb.bombArray[i][0];
			int y = bomb.bombArray[i][1];
			if(x == 0 && y == 0) {
				continue;
			}
			for(int j = x; j>=1; j--) {
				temp[j][y] =  matrix[j-1][y];
			}
		}
		return temp;
	}

	public class Bomb {
		boolean bomb;		//터지는지 안터지는지
		int[][] bombArray;
		int count;
		int color;
		public Bomb() {
			this.bomb = false;
			this.bombArray = new int[max][max];
			this.count = 0;
		}
		
	}
	
	private int[][] dropMacaron(int[] macaron) {
		int y = macaron[0]-1;
		int[][] temp = matrix;
		for(int i = max-1; i>=0; i--) {
			if(temp[i][y] == 0) {
				temp[i][y] = macaron[1];
				break;
			}
		}
		return temp;
	}

}
