package codingtest.Nhn202205;

import java.util.*;
import java.util.stream.Collectors;

public class Nhn2_Re {

	public int[] solution(int[] balance, int[][] transaction, int[] abnormal) {
		int size = balance.length;
		
		LinkedList<Info>[] array = new LinkedList[size];
		
		for(int i = 0; i<size; i++) {
			Info info = new Info(i, balance[i]);
			array[i] = new LinkedList<>();
			
			array[i].add(info);
		}
		
		array = setArray(array, transaction);
		array = remove(array, abnormal);
		
		int[] answer = setAnswer(array, size);
		
		/*
		for(LinkedList<Info> temp : array) {
			for(Info tem2 : temp) {
				System.out.print("(" + tem2.no + ": " + tem2.coin + ")");
			}
			System.out.println();
		}
		
		
		for(int a : answer) {
			System.out.println(a);
		}
		*/
		
		return answer;
	}
	private int[] setAnswer(LinkedList<Info>[] array, int size) {
		int[] answer = new int[size];
		
		for(int i = 0; i<size; i++) {
			for(Info temp: array[i]) {
				answer[i] += temp.coin;
			}
		}
		return answer;
	}
	
	
	private LinkedList<Info>[] remove(LinkedList<Info>[] array, int[] abnormal){
		HashSet<Integer> hash =  new HashSet<>();
		
		for(int temp : abnormal) {
			hash.add(temp-1);
		}

		for(LinkedList<Info> temp : array) {
			for(int i = temp.size()-1; i>=0; i--) {
				if(hash.contains(temp.get(i).no)) {
					temp.remove(i);
				}
			}
		}
		return array;
	}
	
	
	private LinkedList<Info>[] setArray(LinkedList<Info>[] array, int[][] transaction){
		for(int[] trans : transaction) {
			int from = trans[0]-1; 	// from이
			int to = trans[1]-1;	// to 한테
			int pay = trans[2];
			
			LinkedList<Info> take = array[to];
			while(pay != 0) {
				Info pick = array[from].getLast();
				
				if(pick.coin > pay) {
					pick.coin = pick.coin - pay;
					take.add(new Info(pick.no, pay));
					break;
				}else{
					pay = pay - pick.coin;
					
					take.add(pick);
					array[from].removeLast();
				}
			}
		}
		return array;
	}
	
	private class Info{
		int no;
		int coin;
		
		public Info(int no, int coin) {
			this.no = no;
			this.coin = coin;
		}
	}

}
