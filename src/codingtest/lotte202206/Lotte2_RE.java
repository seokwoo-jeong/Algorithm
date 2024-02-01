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

public class Lotte2_RE {
	private int[][] answer;
	private int value;
	private int r;
	private int c;
	
	public int[][] solution(int r, int c){
		this.answer = new int[r][c];
		this.value = 1;
		this.r = r;
		this.c = c;
		
		int round = 0;
		int x = 0;
		int y = c-1;
		
		while(round < r/2+1) {
			if(round % 2 == 0) {	//위에서 아래로 ㄷ
				y = setRightToLeft(x,y,round);
				x = setTopToDown(x,y,round);
				if(round == r/2) {
					break;
				}
				y = setLeftToRight(x,y,round);
				x--;
			}else {					//아래에서 위로 ㄷ
				y = setRightToLeft(x,y,round);
				x = setDownToTop(x,y,round);
				if(round == r/2) {
					break;
				}
				y = setLeftToRight(x,y,round);
				x++;
			}
			
			round++;
		}
		

		
		return answer;
	}
	
	private void print() {
		for(int i = 0; i<r; i++) {
			for(int z= 0; z<c; z++) {
				System.out.print(answer[i][z] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------");
	}
	
	private int setDownToTop(int x, int y, int round) {
		for(int i = x-1; i>=round; i--) {
			answer[i][y] = value;
			value++;
		}
		return round;
	}

	private int setLeftToRight(int x, int y, int round) {
		for(int i = y+1; i<c; i++) {
			answer[x][i] = value;
			value++;
		}
		return c-1;
	}

	private int setTopToDown(int x, int y, int round) {
		for(int i = x+1; i<r-round; i++) {
			answer[i][y] = value;
			value++;
		}
		return r-round-1;
	}

	public int setRightToLeft(int x, int y, int round) {
		for(int i = y; i>=round; i--) {
			answer[x][i] = value;
			value++;
		}
		return round;
	}
	
	
}
