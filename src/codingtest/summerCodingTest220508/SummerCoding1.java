package codingtest.summerCodingTest220508;

public class SummerCoding1 {
	/*
	 * 1. 둘중 하나라도 나쁨인 경우 마스크 착용
	 * 2. 마스크는 2일후에 반드시 버림
	 * 3. 둘다 매우나쁨인 경우 마스크 버림
	 * 상태	미세먼지 농도
		좋음	30 이하
		보통	31 ~ 80
		나쁨	81 ~ 150
		매우나쁨	151 이상

		상태	초미세먼지 농도
		좋음	15 이하
		보통	16 ~ 35
		나쁨	36 ~ 75
		매우나쁨	76 이상
		{{80, 35}, {70, 38}, {100, 41}, {75,30}, {160,80}, {77, 29}, {181, 68}, {151, 76}};
		
		
		DAY	1	2	     3	     4	  5	     6	    7	 8
미세먼지 농도	80	70	   (100)	75	(160)   77	 (181)	(151)
초미세먼지 농도	35	(38)	(41)	30	(80)	29	  (68)	(76)
마스크	     -	첫 사용	재사용	폐기	첫 사용 후 폐기	-	첫 사용	재사용 후 폐기
	 */
	public int solution(int[][] atmos) {
		int answer = 0;
		boolean mask = false;
		int maskDay = 0;
		for(int i = 0; i< atmos.length; i++) {
			
			if(!mask) {//마스크 착용 안한 상태
				if(isVeryBad(atmos[i])) {
					maskDay = 0;
					mask = false;
					answer++;
				}else if(isBad(atmos[i])) {//둘중 하나라도 나쁨인 경우 
					mask = true;
					answer++;
					maskDay++;
				}
				
			}else {	//마스크 착용 한 상태
				if(isVeryBad(atmos[i])) {
					maskDay = 0;
					mask = false;
					continue;
				}
				if(maskDay ==2) {//착용한지 3일 된 경우
					mask = false;
					maskDay = 0;
				}else {
					maskDay++;
				}
			}
		//	System.out.println(mask + " " + maskDay + " " + answer);
		}
		
        return answer;
		
	}
	
	public boolean isBad(int[] atmos) {
		if(atmos[0] >= 81 || atmos[1] >= 36) {
			return true;
		}
		return false;
		
	}
	
	public boolean isVeryBad(int[] atmos) {
		if(atmos[0] >= 151 && atmos[1] >= 76) {
			return true;
		}
		return false;
	}
	

}
