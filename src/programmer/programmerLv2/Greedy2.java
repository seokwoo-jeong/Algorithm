package programmer.programmerLv2;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42885
// ���� ��Ʈ   

public class Greedy2 {
	public int solution(int[] people, int limit) {
		Arrays.sort(people);	//������������
		int result = 0;
		int min = 0;	//���� �ε���
		
		for(int max = people.length-1; min<max; max--) { //max = ���� �ε���
			if(people[min] + people[max] <= limit) {  // ���� ��(���� ��) + ���� ��(ū��) <=100 
				result ++;	
				min++;	//���� �ε��� ��ĭ �̵� (���� ���� �� �ּ� �� �״�� �����ϰ� ���� ���� �� ���� ������ �̵�)
			}
			
		}
		result += people.length - (result*2); 		//���� ������ ��ź ��� result�� �����ֱ�
		return result;
    }

}
