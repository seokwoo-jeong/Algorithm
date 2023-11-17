package programmer.mockexam3;

import java.util.*;

public class Solution3 {
	// [2,2] 2초일하고 2초 쉬고 1,2(일) 3,4(쉼) 5,6(일) 7,8(쉼)
	// [2,4] 2초일하고 4초 쉬고 1,2 3,4,5,6 7,8 9,10,11,12
	public int solution(int distance, int[][] scope, int[][] times) {
		ArrayList<Info> checkScope = getCheckScope(scope);
		ArrayList<Integer> notGo = new ArrayList<>();
		for (int i = 0; i < checkScope.size(); i++) {
			if (!isGo(checkScope.get(i).curLoc, times, checkScope.get(i).index)) {
				notGo.add(checkScope.get(i).curLoc);
			}
		}

		if (notGo.isEmpty()) {
			return distance;
		}
		int min = Integer.MAX_VALUE;
		for (int a : notGo) {
			min = Math.min(min, a);
		}
		return min;
	}

	private class Info {
		int curLoc;
		int index;

		public Info(int curLoc, int index) {
			this.curLoc = curLoc;
			this.index = index;
		}
	}

	private ArrayList<Info> getCheckScope(int[][] scope) {
		ArrayList<Info> temp = new ArrayList<>();
		int start = 0;
		int finish = 0;
		for (int i = 0; i < scope.length; i++) {
			if (scope[i][0] > scope[i][1]) {
				start = scope[i][1];
				finish = scope[i][0];
			} else {
				start = scope[i][0];
				finish = scope[i][1];
			}
			for (int j = start; j <= finish; j++) {
				temp.add(new Info(j, i)); // 현재 위치, 인덱스
				// System.out.print(j + " ");
			}
			// System.out.println();
		}
		return temp;
	}

	// [2,4] 2초일하고 4초 쉬고 1,2 3,4,5,6 7,8 9,10,11,12
	private boolean isGo(int cur, int[][] times, int index) {
		int workTime = times[index][0];
		int restTime = times[index][1];
		int totalTime = workTime + restTime;
		int temp = cur / totalTime;
		cur = cur - (totalTime * temp);
		if (cur == 0) {
			return true;
		} else if (cur <= workTime) {
			return false;
		}

		return true;

	}
}
