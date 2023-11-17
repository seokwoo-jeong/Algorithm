package programmer.programmerLv2;

// https://programmers.co.kr/learn/courses/30/lessons/42883
// ū �� �����   

public class Greedy1 {
	public String solution(String number, int k) {
		char[] numbers = number.toCharArray();
		int count = k;
		char max = ' ';
		int maxIndex = 0;
		int index = 0;
		String result = "";
		StringBuilder sb = new StringBuilder();
		while(count > 0) {
			if(index+count == numbers.length) {
				break;
			}
			for(int i = index; i<=index+count; i++) {
				if(numbers[i] > max) {
					max = numbers[i];
					maxIndex = i;
				}
			}
			count -= maxIndex - index;
			
			index = maxIndex+1;
			sb.append(max);
			max = ' ';
		}
		if(numbers.length-maxIndex -1> count) {
			for(int i = maxIndex+1; i<numbers.length; i++) {
				sb.append(numbers[i]);
			}
		}
		result = sb.toString();
		return result;
    }

}
