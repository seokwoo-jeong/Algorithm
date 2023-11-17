package codingtest.Nhn202205;

public class Nhn4 {
	/*
	long[] players = {10, 11, 15, 14, 16, 18, 19, 20};
	int power = 10;
	int k =2;
	*/
	long[] powerArray;
	public long solution(long[] players, int power, int k) {
		powerArray = new long[players.length];
		for(int i = 0; i<players.length; i++) {
			if(i==0 && !isWin(players[i],power)) {
				powerArray[i] = power + k;
				continue;
			}else {
				
			}
			
			
		}
		
		
		return (Long) null;
	}
	
	public boolean isWin(long playerPower, int mePower) {
		boolean flag = false;
		if(playerPower <= mePower) {
			flag = true;
		}
		return flag;
	}
}
