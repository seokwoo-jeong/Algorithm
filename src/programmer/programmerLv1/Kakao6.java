package programmer.programmerLv1;

import java.util.HashMap;

// ������(Lv1)
// https://programmers.co.kr/learn/courses/30/lessons/42889

// ������ = ���������� ���������� ���� Ŭ�������� ���� �÷��̾��� �� / ���������� ������ �÷��̾� ��
// ��ü �������� ���� = N
// ����ڰ� ���� �����ִ� ���������� ��ȣ�� ��� �迭 stages
// return: �������� ���� ������������ ������������ ���������� ��ȣ�� ��� �迭 return

// n = 5;
// stages = {2,1,2,6,2,4,3,3};
// result = 3,4,2,1,5
public class Kakao6 {
	public int[] solution(int N, int[] stages) {
		HashMap<Integer, Double> hash = new HashMap<>();
		int[] answer = {};
		for (int i = 0; i < N; i++) {
			hash.put(i + 1, getFailureRate(i + 1, stages)); // key: value = �������� �ܰ� : ������
		}

		answer = sortHashFromValue(hash, N); // �������� �������� �������� �ܰ� ����

		return answer;
	}

	public double getFailureRate(int stage, int[] stages) {
		double failureRate = 0;				//������
		double numerator = 0;				//����
		double denominator = 0;				//�и�
		for (int num : stages) {
			if (num == stage) {
				numerator++;
			}
			if (num >= stage) {
				denominator++;
			}
		}
		if (denominator != 0) {				//�и� = 0�̸� ������ = 0(�ʱ⼱��) ����
			failureRate = numerator / denominator;
		}

		return failureRate;
	}

	private int[] sortHashFromValue(HashMap<Integer, Double> hash, int N) {
		int[] answer = new int[hash.size()];
		for (int i = 0; i < N; i++) {
			double maxValue = -1;			// ���� ū �� ã������ ���
			int maxKey = 0;					// ���� ū ���� stage��ȣ
			for (int key : hash.keySet()) {		// ���� ū ���� stage��ȣ ã��
				if (maxValue < hash.get(key)) {
					maxValue = hash.get(key);
					maxKey = key;
				}
			}
			answer[i] = maxKey;					// ���� ū �� stage��ȣ answer�� add
			hash.remove(maxKey);				// answer�� �� stage��ȣ hash���� ����

		}
		return answer;
	}

}
