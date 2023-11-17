package codingtest.sktelecom202206;

public class SkTel2_Re {

	public int[] solution(int[] periods, int[][] payments, int[] estimates) {
		
		int[] result = new int[2];
		for(int i = 0; i<periods.length; i++) {
			if(periods[i] < 23) {	//23개월 미만인 사람은 vip무조건 못된다.
				continue;
			}
			
			int thisMonthPay = 0;
			for(int k = 0; k<payments[i].length; k++) {
				thisMonthPay += payments[i][k];
			}
			
			boolean isThisMonthVip = isVip(periods[i], thisMonthPay);
			
			int nextMonthPay = thisMonthPay - payments[i][0] + estimates[i];
			boolean isNextMonthVip = isVip(periods[i] + 1, nextMonthPay);
			
			System.out.println(isThisMonthVip + "  " + isNextMonthVip);
			System.out.println(thisMonthPay + " " + nextMonthPay);
			if(!isThisMonthVip && isNextMonthVip) {
				result[0] ++;
			}else if(isThisMonthVip && !isNextMonthVip) {
				result[1] ++;
			}
		}
		System.out.println(result[0] + " " +result[1]);
		
		return result;
	}
	
	private boolean isVip(int period, int payments) {
		if(period <24) {
			return false;
		}else if(24 <= period && period < 60) {	//2년이상 5년 미만
			if(payments >= 900000) {
				return true;
			}
		}else {
			if(payments >= 600000) {
				return true;
			}
		}
		
		
		return false;
	}
}
