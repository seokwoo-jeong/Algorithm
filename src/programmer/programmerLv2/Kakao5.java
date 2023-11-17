package programmer.programmerLv2;

//https://programmers.co.kr/learn/courses/30/lessons/1835
//단체사진 찍기
public class Kakao5 {
	String[] friends = { "A", "C", "F", "J", "M", "N", "R", "T" };
	boolean[] isVisit;
	String[] array;
	int count;
	String[] datas;
	public int solution(int n, String[] data) {
		isVisit = new boolean[friends.length];
		count = 0;
		array = new String[friends.length];
		datas = data;
		dfs(0);

		System.out.println(count);
		return count;
	}

	public void dfs(int index) {
		if (index == friends.length) {
			if(isRight(array)) {
				count++;
			}
			return;
		}
		for (int i = 0; i < friends.length; i++) {
			if (!isVisit[i]) {
				array[index] = friends[i];
				isVisit[i] = true;
				dfs(index+1);
				isVisit[i] = false;
			}
		}
	}

	private boolean isRight(String[] array) {
		boolean flag = true;
		for(int i = 0; i<datas.length; i++) {
			char[] temp = datas[i].toCharArray();
			String a = String.valueOf(temp[0]);
			String b = String.valueOf(temp[2]);
			String operation = String.valueOf(temp[3]);
			int val = temp[4]-'0';
			
			int aIndex = findIndex(array,a);
			int bIndex = findIndex(array,b);
			
			if(operation.equals("=")) {
				if(Math.abs(aIndex-bIndex)-1 !=  val) {
					flag = false;
					break;
				}
			}else if(operation.equals(">")) {
				if(Math.abs(aIndex-bIndex) -1  <=val) {
					flag = false;
					break;
				}
			}else{
				if(Math.abs(aIndex-bIndex) -1  >=val) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	private int findIndex(String[] array, String a) {
		int idx = 0;
		for(int i = 0; i<array.length; i++) {
			if(array[i].equals(a)) {
				idx = i;
				break;
			}
		}
		return idx;
	}
}