package codingtest.lotte202206;

/*
 * 롯데정보통신 2번 문제 복기
 * 이차배열 가로 r(홀수만), 세로 c를 solution parameter로 줌
 * ㄷ자로 1부터 이차배열 채우기
 * 
 * r = 5, c= 5
 * 5  4  3  2  1
 * 6 19 20 21 22
 * 7 18 25 24 23
 * 8 17	16 15 14
 * 9 10 11 12 13
 */



public class Lotte2 {
	public int[][] solution(int r, int c){
		int[][] answer = new int[r][c];
		int val = 1;
		int stdX1 = 0;
		int stdX2 = r-1;
		int stdY = 0;
		Direction direction = new Direction();
		int x = 0;
		int y = c-1;
		while(val <= r*c) {
			if(direction.upStart) {
				if(direction.left) {
					if(y < stdY) {
						direction.left = false;
						direction.down = true;
						y = stdY;
						x++;
					}else {
						answer[x][y] = val;
						y--;
						val++;
					}
				}else if(direction.down) {
					if(x > stdX2) {
						direction.down = false;
						direction.right = true;
						x = stdX2;
						y++;
					}else {
						answer[x][y] = val;
						x++;
						val++;
					}
					
				}else if(direction.right) {
					if(y == c) {
						direction.upStart = false;
						direction.downStart = true;
						direction.right = false;
						direction.left = true;
						stdY++;
						stdX2--;
						stdX1++;
						y= c-1;
						x= stdX2;
					}else {
						answer[x][y] = val;
						y++;
						val++;
					}
				}
			}else if(direction.downStart){
				if(direction.left) {
					if(y < stdY) {
						direction.left = false;
						direction.up = true;
						y = stdY;
						x--;
					}else {
						answer[x][y] = val;
						y--;
						val++;
					}
				}else if(direction.up) {
					if(x < stdX1) {
						direction.up = false;
						direction.right = true;
						x = stdX1;
						y++;
					}else {
						answer[x][y] = val;
						x--;
						val++;
					}
					
				}else if(direction.right) {
					if(y == c) {
						direction.upStart = true;
						direction.downStart = false;
						direction.right = false;
						direction.left = true;
						stdY++;
						stdX2--;
						stdX1++;
						y= c-1;
						x= stdX1;
					}else {
						answer[x][y] = val;
						y++;
						val++;
					}
					
				}
			}
			
			
		}
		
		
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
		
		
		return answer;
	}
	
	public class Direction{
		boolean upStart;	//위에서 시작하는지
		boolean downStart;  //아래에서 시작하는지
		boolean left;		//왼쪽으로 가는지
		boolean right;		//오른쪽으로 가는지
		boolean down;		//아래로 가는지
		boolean up;			//위로 가는지
		public  Direction() {
			this.upStart = true;
			this.downStart = false;
			this.left = true;
			this.right = false;
			this.down = false;
			this.up = false;
		}
	}
}
