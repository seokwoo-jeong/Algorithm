package codingtest.Nhn202205;

import java.util.*;

public class Nhn2_RE2 {

	private Map<Integer,LinkedList<Coin>> hash;
	private int size;
	private int[] result;
	public int[] solution(int[] balance, int[][] transaction, int[] abnormal) {
	
		size = balance.length;
		hash = new HashMap<>();
		
		result = new int[size];
		LinkedList<Coin> list = null;
		for(int i = 1; i<=size; i++) {
			Coin coin = new Coin(i,balance[i-1]);
			
			list = new LinkedList<>();
			list.add(coin);
			
			hash.put(i, list);
		}
		
		trans(transaction);
		
		remove(abnormal);
		
		getAnswer();
		
		for(int a : result) {
			System.out.print(a + " ");
		}
		
		return result;
	}
	public void getAnswer() {
		for(int key: hash.keySet()) {
			LinkedList<Coin> list = hash.get(key);
			for(int i = 0; i<list.size(); i++) {
				result[key-1] += list.get(i).value;
			}
		}		
	}
	
	
	public void remove(int[] abnor) {
		HashSet<Integer> abnoraml = new HashSet<>();
		
		for(int abno : abnor) {
			abnoraml.add(abno);
		}
		
		for(int key: hash.keySet()) {
			LinkedList<Coin> list = hash.get(key);
			for(int i = list.size()-1; i>=0; i--) {
				
				if(abnoraml.contains(list.get(i).user)) {
					list.remove(i);
				}
			}
		}
		
	}
	
	public void trans(int[][] transaction) {
		int give = 0;
		int receive = 0;
		int pay = 0;
		
		for(int[] tran : transaction) {
			give = tran[0];
			receive = tran[1];
			pay = tran[2];
			
			while(pay >0) {
				if(hash.get(give).getLast().value > pay) {
					hash.get(receive).add(new Coin(hash.get(give).getLast().user,pay));
					
					hash.get(give).getLast().value = hash.get(give).getLast().value - pay; 
					pay = 0;
				}else if(hash.get(give).getLast().value == pay){
					hash.get(receive).add(new Coin(hash.get(give).getLast().user,pay));
					hash.get(give).removeLast();
					pay = 0;
				}else {
					hash.get(receive).add(new Coin(hash.get(give).getLast().user,hash.get(give).getLast().value));
					pay = pay - hash.get(give).getLast().value;
					hash.get(give).removeLast();
					
				}
			}
			
		}
	}
	
	private class Coin{
		public int user;
		public int value;
		
		public Coin(int user, int value) {
			this.user = user;
			this.value = value;
		}
		
		
	}
}
