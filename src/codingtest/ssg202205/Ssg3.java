package codingtest.ssg202205;

import java.util.Arrays;

/*
 * 2021~2030을 1차원 배열로 정의 (월의 마지막과 월의 첫번째를 이어줘야 함)
 * date의 배열 크기는 (2030-2021) * 365 = 3650
 * 2021-01-01 -> index 0
 * 2021-01-31 -> index 30
 * 2021-02-01 -> index 31
 * 2021-03-01 -> index 31+28
 * 20220101 -> index 365
 * 
 * 20231231 - index 3649
 * 
 */

public class Ssg3 {
	int[] calendar;
	Mask[] maskArray;
	int[] dateArray;
	int[] priceArray;
	int max = 3651;
	int startIndex = max;
	int finishIndex = 0;
	static int[] lastDay = {31,28,31,30,31,30,31,31,30,31,30,31};
	public int solution(int[][] masks, String[] dates) {
		int answer = 0;
		maskArray = new Mask[masks.length];
		dateArray = new int[max];
		
		defineMaskArray(masks);
		defineDateArray(dates);
		Arrays.sort(maskArray);
		priceArray = new int[finishIndex - startIndex + 1];
		
		setMinPrice();
		//System.out.println(priceArray[priceArray.length - 1]);
		answer = priceArray[priceArray.length - 1];
		return answer;
	}
	
	

	private void setMinPrice() {
		for(int i = startIndex; i<=finishIndex; i++) {
			int priceIndex = i - startIndex;
			if(dateArray[i] == 0 && i>0) {
				priceArray[priceIndex] = priceArray[priceIndex-1];
				continue;
			}
			for(int j = 0; j<maskArray.length; j++) {
				if(priceIndex + 1 <= maskArray[j].able ) {
					if(priceArray[priceIndex] == 0) {
						priceArray[priceIndex] = maskArray[j].price;
					}else {
						priceArray[priceIndex] = Math.min(priceArray[priceIndex], maskArray[j].price);
						
					}
				}else {
					int price1 = priceArray[priceIndex - maskArray[j].able] + maskArray[j].price;
					if(priceArray[priceIndex] == 0) {
						priceArray[priceIndex] = price1;
					}else {
						priceArray[priceIndex] = Math.min(priceArray[priceIndex], price1);
					}
					
				}
			}
			
		}
		
	}



	private void defineDateArray(String[] dates) {
		String[] def = null;
		for(int i = 0; i<dates.length; i++) {
			def = dates[i].split("~");
			if(def.length > 1) {	//연속인거
				setMultiDate(def);
			}else {	//단일인거
				setSingleDate(def[0]);
			}
		}
		
	}
	
	public void setSingleDate(String date) {
		String[] tempDate = date.split("/");
		String yy = tempDate[0];
		String mm = tempDate[1];
		String dd = tempDate[2];
		dateArray[getIndex(yy,mm,dd)] = 1;
		
	}

	public void setMultiDate(String[] date) {
		String[] tempDate = null;
		int startIndex = 0;
		int finishIndex = 0;
		for(int i = 0; i<date.length; i++) {
			tempDate = date[i].split("/");
			String yy = tempDate[0];
			String mm = tempDate[1];
			String dd = tempDate[2];
			if(i == 0) {
				startIndex = getIndex(yy,mm,dd);
			}else {
				finishIndex = getIndex(yy,mm,dd);
			}
		}
		for(int i = startIndex; i<=finishIndex; i++) {
			dateArray[i] = 1;
		}
	}	





	private int getIndex(String yy, String mm, String dd) {
		int index = 0;
		index = (Integer.parseInt(yy) - 2021) * 365;	//년
		
		for(int i = 1; i< Integer.parseInt(mm); i++) {	//월
			index += lastDay[i-1];
		}
		
		index += Integer.parseInt(dd);		//일
		startIndex = Math.min(startIndex, index);
		finishIndex = Math.max(finishIndex, index);
		return index;
	}

	public class Mask implements Comparable<Mask>{
		int price;
		int able;
		
		public Mask(int[] mask) {
			this.price = mask[0];
			this.able = mask[1];
		}

		@Override
		public int compareTo(Mask o) {
			if(o.price < this.price) {
				return -1;
			}else {
				return 1;
			}
			
		}
	}
	
	private void defineMaskArray(int[][] masks) {
		for(int i = 0; i<masks.length; i++) {
			Mask mask = new Mask(masks[i]);
			maskArray[i] = mask;
		}
	}
}
