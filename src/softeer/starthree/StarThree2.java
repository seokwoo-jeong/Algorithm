package softeer.starthree;

import java.util.*;
import java.io.*;

// https://softeer.ai/practice/formCodeEditor.do
// [인증평가(3차) 기출] 교차로

public class StarThree2 {
	static Queue<Integer> A;
	static Queue<Integer> B;
	static Queue<Integer> C;
	static Queue<Integer> D;
	static int n;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		A = new LinkedList<>();
		B = new LinkedList<>();
		C = new LinkedList<>();
		D = new LinkedList<>();
		Queue<String[]> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			queue.add(temp);
		}
		setQueue(queue);
	}

	private static void setQueue(Queue<String[]> queue) {
		String[] temp = queue.poll();
		int curTime = Integer.parseInt(temp[0]);
		String road = temp[1];
		int index = 1;
		while (index < n) {

			temp = queue.peek();
			int tempTime = Integer.parseInt(temp[0]);
			if (curTime == tempTime) { // 초가 같으면 일단 맞는 queue에 input
				queue.poll();
				addQueue(temp);
				index++;
			} else {
				curTime = move(curTime);
			}
		}

	}

	private static int move(int curTime) {
		int temp = curTime;
		boolean[] flag = { false, false, false, false }; // a,b,c,d
		if (!A.isEmpty() && D.isEmpty()) {
			flag[0] = true;
		}
		if (!B.isEmpty() && A.isEmpty()) {
			flag[1] = true;
		}
		if (!C.isEmpty() && B.isEmpty()) {
			flag[2] = true;
		}
		if (!D.isEmpty() && C.isEmpty()) {
			flag[3] = true;
		}
		if (!flag[0] && !flag[1] && !flag[2] && !flag[3]) {
			System.out.println(-1);
			return -1;
		}
		if (flag[0]) {
			A.poll();
			System.out.println(temp);
		}
		if (flag[1]) {
			B.poll();
			System.out.println(temp);
		}
		if (flag[2]) {
			C.poll();
			System.out.println(temp);
		}
		if (flag[3]) {
			D.poll();
			System.out.println(temp);
		}

		return temp++;
	}

	private static void addQueue(String[] info) {
		int time = Integer.parseInt(info[0]);
		String road = info[1];
		switch (road) {
		case "A":
			A.add(time);
			break;
		case "B":
			B.add(time);
			break;
		case "C":
			C.add(time);
			break;
		case "D":
			D.add(time);
			break;
		}
	}
}
