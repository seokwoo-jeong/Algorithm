package codingtest.ssg202205;

import java.util.*;

public class Ssg2_re {

	public String[] solution(String[] logs) {
		
		int studentNo = 0;
		int questionNo = 0;
		int score = 0;
		String[] temp = null;
		
		int[][] matrix = new int[10000][101];
		HashMap<Integer, HashSet<Integer>> hash = new HashMap<>();
		// 학생번호 , 푼 문제 들
		for(String log: logs) {
			temp = log.split(" ");
			
			studentNo = Integer.parseInt(temp[0]);
			questionNo = Integer.parseInt(temp[1]);
			score = Integer.parseInt(temp[2]);
			
			matrix[studentNo][questionNo] = score;
			
			if(hash.containsKey(studentNo)) {
				hash.get(studentNo).add(questionNo);
			}else {
				HashSet<Integer> hashSet = new HashSet<>();
				hashSet.add(questionNo);
				hash.put(studentNo, hashSet);
			}
		}
		
		ArrayList<Integer> studentNoList = new ArrayList<>(hash.keySet());
		HashSet<Integer> result = new HashSet<>();
		for(int i = 0; i<studentNoList.size()-1; i++) {	// 학생들 뽑기
			int studentNo1 = studentNoList.get(i);	//학생 한명 뽑기
			ArrayList<Integer> questionNoList1 = new ArrayList<>(hash.get(studentNo1));	//해당 학생의 문제 번호들
			
			if(questionNoList1.size() < 5) {
				continue;
			}
			
			for(int z = i+1; z<studentNoList.size(); z++) {	// 다음 학생 뽑기
				int count = 0;
				int studentNo2 = studentNoList.get(z);	// 다음 학생 번호
				
				if(hash.get(studentNo2).size() < 5) {
					continue;
				}
				
				for(int question : questionNoList1){//다음 학생 문제헤 해당 학생의 문제가 있는지
					if(hash.get(studentNo2).contains(question)) {
						if(matrix[studentNo1][question] == matrix[studentNo2][question]) {
							count++;
						}
					}
				}
				if(count == questionNoList1.size()) {
					result.add(studentNo1);
					result.add(studentNo2);
				}
			}

		}
		ArrayList<Integer> t = new ArrayList<>(result);
		Collections.sort(t);
		
		
		String[] result2 = new String[t.size()];
		int index = 0;
		for(int re : t) {
			result2[index] = setResult(re);
			
			System.out.println(result2[index]);
		}
		if(result2.length == 0) {
			return new String[] {"None"};
			
		}
		
		
		return result2;
	}
	
	private String setResult(int no) {
		String temp = String.valueOf(no);
		
		if(temp.length() == 3) {
			temp = "0" + temp;
		}else if(temp.length() == 2) {
			temp = "00" + temp;
		}else if(temp.length() == 1) {
			temp = "000" + temp;
		}
		return temp;
	}
}
