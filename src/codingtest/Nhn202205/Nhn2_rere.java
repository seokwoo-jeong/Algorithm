package codingtest.Nhn202205;

import java.util.*;

public class Nhn2_rere {
	public int[] solution(int[] balance, int[][] transaction, int[] abnormal) {
		int size = balance.length;
		LinkedList<Info>[] array = new LinkedList[size];
		
		for(int i = 0; i<balance.length; i++) {
			Info info = new Info(i+1, balance[i]);
			array[i] = new LinkedList<>();
			
			array[i].add(info);
		}
		
		moveMoney(array,transaction);
		deleteMoney(array,abnormal);
		
		int[] result = new int[size];
		
		for(int i = 0; i<size; i++) {
			for(Info info : array[i]) {
				result[i] += info.pay;
			}
			System.out.println(result[i]);
		}
		
		return result;
	}
	private void deleteMoney(LinkedList<Info>[] array, int[] abnormal) {
		HashSet<Integer> hash = new HashSet<>();
		
		for(int i = 0; i<abnormal.length; i++) {
			hash.add(abnormal[i]);
		}
		
		for(LinkedList<Info> temp : array) {
			for(int k = temp.size()-1; k>=0; k--) {
				if(hash.contains(temp.get(k).no)) {
					temp.remove(k);
				}
			}
		}
	}
	
	
	private void moveMoney(LinkedList<Info>[] array, int[][] transaction) {
		int from = 0;
		int to = 0;
		int pay = 0;
		for(int i = 0; i<transaction.length; i++) {
			from = transaction[i][0] - 1;
			to = transaction[i][1] - 1;
			pay = transaction[i][2];
			
			while(pay > 0) {
				int fromMoney = array[from].getLast().pay;
				
				if(fromMoney > pay) {
					array[from].getLast().pay = fromMoney - pay;	// 주는놈 줄 금액 제외
					array[to].add(new Info(array[from].getLast().no, pay));	//받는놈에게 준 금액 추가
					pay = 0;
				}else {
					array[to].add(array[from].getLast());	//받는놈에게 줄 금액 일부 추가
					pay = pay - array[from].getLast().pay;	//일부금액 제외
					array[from].removeLast();				//주는놈 마지막 날리기
					
				}
			}
			
		}
	}
	
	
	private class Info {
		int no;
		int pay;
		
		public Info(int no, int pay) {
			this.no = no;
			this.pay = pay;
		}
	}
	

}

