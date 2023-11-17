package programmer.programmerLv2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/17683
// [3차]방금그곡

public class Kakao13 {
	public String solution(String m, String[] musicinfos) {
		m = changeSyllable(m);
		int size = musicinfos.length;
		Info[] infoArray = new Info[size];
		String startTime = "";
		String endTime = "";
		int totalTime = 0;
		String musicName = "";
		String syllable = "";
		for (int i = 0; i < size; i++) {
			String[] temp = musicinfos[i].split(",");
			startTime = temp[0];
			endTime = temp[1];
			totalTime = getTotalTime(startTime, endTime);
			musicName = temp[2];
			syllable = getSyllable(changeSyllable(temp[3]), totalTime);
			Info info = new Info(startTime, endTime, totalTime, musicName, syllable);

			infoArray[i] = info;

		}
		String answer = "(None)";

		int total = Integer.MIN_VALUE;

		for (int i = 0; i < size; i++) {
			if (infoArray[i].syllable.contains(m)) {
				if (infoArray[i].totalTime > total) {
					answer = infoArray[i].musicName;
					total = infoArray[i].totalTime;
				}
			}
		}
		return answer;
	}

	private String changeSyllable(String m) {
		m = m.replaceAll("C#", "H");
		m = m.replaceAll("D#", "I");
		m = m.replaceAll("F#", "J");
		m = m.replaceAll("G#", "K");
		m = m.replaceAll("A#", "L");
		return m;
	}

	public int getTotalTime(String startTime, String endTime) {
		String[] temp1 = startTime.split(":");
		String[] temp2 = endTime.split(":");
		int startHour = Integer.parseInt(temp1[0]);
		int endHour = Integer.parseInt(temp2[0]);
		int startMin = Integer.parseInt(temp1[1]);
		int endMin = Integer.parseInt(temp2[1]);

		return ((endHour - startHour) * 60 + (endMin - startMin));
	}

	public String getSyllable(String sy, int totalTime) {
		StringBuilder sb = new StringBuilder();

		if (totalTime > sy.length()) {
			for (int i = 0; i < totalTime / sy.length(); i++) {
				sb.append(sy);
			}
			sb.append(sy.substring(0, totalTime % sy.length()));
			sy = sb.toString();
		} else {
			sy = sy.substring(0, totalTime);
		}
		// System.out.println(sy);
		return sy;
	}

	private class Info {
		String startTime;
		String endTime;
		int totalTime;
		String musicName;
		String syllable;

		public Info(String startTime, String endTime, int totalTime, String musicName, String syllable) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.totalTime = totalTime;
			this.musicName = musicName;
			this.syllable = syllable;
		}
	}
}
