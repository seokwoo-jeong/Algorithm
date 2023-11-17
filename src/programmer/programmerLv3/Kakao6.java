package programmer.programmerLv3;
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/17678
// [1차]셔틀버스
public class Kakao6 {
	PriorityQueue<Time> queue;

	public String solution(int n, int t, int m, String[] timetable) {
		queue = new PriorityQueue<>();

		for (String time : timetable) {
			queue.add(new Time(time));
		}

		int startTime = 540;
		for (int i = 0; i < n - 1; i++) {
			frontGo(startTime, m);
			startTime = startTime + t;

		}

		String answer = getAnswer(startTime, m);
		return answer;

	}

	private String getAnswer(int startTime, int m) {
		int lastTime = startTime;
		int count = 0;
		String answer = "";
		if (queue.size() < m) {
			answer = getTime(startTime);
		} else {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Time pick = queue.peek();
				if (pick.time <= startTime) {
					count++;
					lastTime = queue.poll().time;
					// System.out.println(lastTime);
				}
				if (count == m) {
					break;
				}
			}
			if (count < m) {
				answer = getTime(lastTime);
			} else {
				answer = getTime(lastTime - 1);
			}

		}
		// System.out.println(lastTime + " " + count);

		return answer;
	}

	private String getTime(int t) {
		int time = t;
		int hour = time / 60;
		int min = time - (hour * 60);

		StringBuilder sb = new StringBuilder();
		if (hour < 10) {
			sb.append("0");

		}
		sb.append(hour);
		sb.append(":");
		if (min < 10) {
			sb.append("0");
		}
		sb.append(min);
		return sb.toString();
	}

	private void frontGo(int startTime, int m) {
		for (int i = 0; i < m; i++) {
			Time pick = queue.peek();
			if (pick.time <= startTime) {
				queue.poll();

			} else {
				break;
			}
		}
	}

	private class Time implements Comparable<Time> {
		int time;

		public Time(String time) {
			String[] temp = time.split(":");
			this.time = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
		}

		@Override
		public int compareTo(Time t) {
			return this.time - t.time;
		}

	}
}