package programmer.programmerLv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

//�Ű� ��� �ޱ�(Lv1)
// https://programmers.co.kr/learn/courses/30/lessons/92334


public class Kakao3 {
	public int[] solution(String[] id_list, String[] report, int k)  {
		HashMap<String,Integer> reporting = new LinkedHashMap<>();		//�Ű��� �� -> key������ �ٲ�� linkedHashMap���
		HashMap<String,Integer> reported = new HashMap<>();			//�Ű���� ��
		String[] newReport = Arrays.stream(report).distinct().toArray(String[]::new); 	//�ߺ�����
		int[] result = {};
		for(String name: id_list) {
			reporting.put(name, 0);
			reported.put(name, 0);
		}
		
		for(String reports : newReport) {		//�� ������ �Ű���� �� add
			reported.replace(reports.split(" ")[1], reported.get(reports.split(" ")[1]) + 1);
		}
		
		for(String reports: newReport) {
			if(reported.get(reports.split(" ")[1]) >= k) { // �Ű���� ���� k�� ���� ��
				reporting.replace(reports.split(" ")[0], reporting.get(reports.split(" ")[0]) + 1); 	// �Ű��� ��� value ++
			}
		}
		result = Arrays.stream(reporting.values().toArray()).mapToInt(o -> (int)o).toArray(); //hash value�� int[]�� ��ȯ
		return result;
      
    }
}
