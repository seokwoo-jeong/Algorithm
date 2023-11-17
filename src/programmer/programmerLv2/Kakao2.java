package programmer.programmerLv2;

import java.util.Arrays;
import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/72411
// �޴� ������
// fees:[180, 5000, 10, 600] �⺻�ð�(��), �⺻ ���, ���� �ð�(��), ���� ���
/* records: ["05:34 5961 IN", 
			 "06:00 0000 IN",
			 "06:34 0000 OUT", 
			 "07:59 5961 OUT", 
			 "07:59 0148 IN", 
			 "18:59 0000 IN", 
			 "19:09 0148 OUT", 
			 "22:59 5961 IN", 
			 "23:00 5961 OUT"]
*/
// result: [14600, 34400, 5000]

public class Kakao2 {
	HashMap<String, String> hash = new HashMap<>(); // ������ȣ, �����忡 �־��� �ð��� ���� string ���·� ����

	public int[] solution(int[] fees, String[] records) {
		String time = null; // �ð�
		String carNumber = null; // ������ȣ
		String status = null; // �������� �ȳ�������
		int totalTime = 0;

		for (String record : records) {
			time = record.split(" ")[0]; // �ð�
			carNumber = record.split(" ")[1]; // ������ȣ
			status = record.split(" ")[2]; // in/out

			carInOut(time, carNumber, status); // �� ���Դ��� ���Դ���
		}

		String[] key = Arrays.copyOf(this.hash.keySet().toArray(), this.hash.keySet().toArray().length, String[].class); // key����
																															// ����
		Arrays.sort(key);

		int[] answer = new int[key.length];
		for (int i = 0; i < key.length; i++) {
			isOut(key[i]);
			totalTime = getTotalTime(key[i]);
			answer[i] = getFee(fees, key[i], totalTime);
			// System.out.println(key[i] + " " + this.hash.get(key[i]) + " " + totalTime+ "
			// "+getFee(fees, key[i], totalTime));
			// System.out.println(answer[i]);
		}
		return answer;
	}

	private int getFee(int[] fees, String carNum, int totalTime) { // fees:[180, 5000, 10, 600] �⺻�ð�(��), �⺻ ���, ����
																	// �ð�(��), ���� ���
		if (totalTime <= fees[0]) { // �⺻�ð����� ���ų� �����ϰ� �־��� ��� �⺻��� ����
			return fees[1];
		}
		return (int) (fees[1] + Math.ceil((double) ((totalTime - fees[0]) / (double) fees[2])) * fees[3]);
	}

	public int getTotalTime(String carNum) { // ���������� �� ���Դ��� ���
		String[] timeArr = this.hash.get(carNum).split(",");
		int inTime = 0;
		int outTime = 0;
		int totalTime = 0;
		for (int i = 0; i < timeArr.length; i++) {
			if (i % 2 == 0) { // in �� ���
				inTime = changeMin(timeArr[i]);
			} else { // out �� ���
				outTime = changeMin(timeArr[i]);
				totalTime += outTime - inTime;
			}
		}
		return totalTime;
	}

	public int changeMin(String time) {
		int min = Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
		return min;
	}

	private void carInOut(String time, String carNumber, String status) {
		if (status.equals("IN")) { // ���� ���� ���
			if (this.hash.keySet().contains(carNumber)) { // ���ſ� ������ �ִ� ���
				this.hash.replace(carNumber, this.hash.get(carNumber) + "," + time);
			} else { // ���ſ� ���� �� ���� ���
				this.hash.put(carNumber, time);
			}
		} else { // ���� �������
			this.hash.replace(carNumber, this.hash.get(carNumber) + "," + time);
		}
	}

	public void isOut(String carNumber) { // �ȳ��� �� Ȯ�� (23:59�� out���� ����)
		if (this.hash.get(carNumber).split(",").length % 2 != 0) { // �ȳ��� ���
			this.hash.replace(carNumber, this.hash.get(carNumber) + ",23:59");
		}

	}
}