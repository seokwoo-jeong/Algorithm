package codingtest.sk220312;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 1. ������ ��ġ��Ű��
// 2. �ܰ��� ���� �� �������� ����
// 3. �ܰ��� �� �������� ���� ��, ���� ȭ�� ������ ���� ������� ����
// 4. �������� �������� �ܰ��� �� ȭ�� �������� 3�� ����

public class SK1 {

	public int solution(int money, int[] costs) {
		int[] moneyUnit = {1,5,10,50,100,500};
		double unit = 0.0;
		double result = 0.0;
		HashMap<Double,Integer> hash = new HashMap<>();
		
		// 1. ������ ��ġ��Ű��
		for(int i = 0; i < costs.length; i++) {
			unit = (double)costs[i] / moneyUnit[i];	
			hash.put(unit,moneyUnit[i]);
		}
		
		// 2. �ܰ��� ���� �� �������� ����
		List<Double> keyList = new ArrayList<>(hash.keySet());	
		keyList.sort(Double::compareTo);
		
		for(Double key: keyList) {
			if(money == 0) {
				break;
			}
			// 3. �ܰ��� �� �������� money�� ���� ��, ���� ȭ�� ������ ���� ������� ����
			result += (key * hash.get(key)) * (money / hash.get(key));		
			// 4. �������� �������� �ܰ��� �� ȭ�� �������� 3�� ����
			money = money % hash.get(key);
		}
		return (int)result;
	}

}
