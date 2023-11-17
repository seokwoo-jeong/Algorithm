package programmer.mockexam2;
import java.util.*;

public class Solution3 {
	int[] isVisit;
	int[] save;

	public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		int[] answer = new int[sources.length];
		save = new int[n + 1];
		for (int i = 0; i < sources.length; i++) {
			isVisit = new int[n + 1];
			answer[i] = bfs(sources[i], roads, destination, n);
			
		}
		return answer;
	}

	private int bfs(int init, int[][] roads, int destination, int n) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { init, 0 });
		if (save[init] != 0) {
			return save[init];
		} else {
			isVisit[init] = -1;
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int start = cur[0];
			int length = cur[1];
			if (start == destination) {
				int cu = start;
				int dept = 1;
				while (true) {
					if (isVisit[cu] == -1 || save[isVisit[cu]] != 0) {
						break;
					}
					save[isVisit[cu]] = dept;
					dept++;
					cu = isVisit[cu];

				}
				return length;
			}
			if (length == n) {
				break;
			}
			for (int i = 0; i < roads.length; i++) {
				int dot1 = roads[i][0];
				int dot2 = roads[i][1];
				int next = 0;
				if (dot1 == start) {
					next = dot2;
				} else if (dot2 == start) {
					next = dot1;
				}
				if (next == 0) {
					continue;
				}
				if (save[next] != 0) {
					return save[next] + length + 1;
				}
				if (isVisit[next] == 0) {
					queue.add(new int[] { next, length + 1 });
					isVisit[next] = start;
				}
			}
		}
		return -1;
	}

}