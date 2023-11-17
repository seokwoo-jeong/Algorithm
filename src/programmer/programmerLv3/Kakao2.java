package programmer.programmerLv3;

import java.util.*;

public class Kakao2 {
	private HashSet<Set<Integer>> result;
	private List<ArrayList<Integer>> possible = new ArrayList<>();

	public int solution(String[] user_id, String[] banned_id) {
		result = new HashSet<>();
		for (int i = 0; i < banned_id.length; i++) {
			possible.add(new ArrayList<>());
			for (int j = 0; j < user_id.length; j++) {
				if (isPossible(banned_id[i], user_id[j])) {
					possible.get(i).add(j + 1);
				}
			}
		}
		HashSet<Integer> array = new HashSet<>();

		dfs(0, array, banned_id.length);

		return result.size();
	}

	private void dfs(int depth, HashSet<Integer> array, int size) {
		if (depth == size) {
			result.add(new HashSet<>(array));
			return;
		}
		for (int i = 0; i < possible.get(depth).size(); i++) {
			if (!array.contains(possible.get(depth).get(i))) {
				array.add(possible.get(depth).get(i));
				dfs(depth + 1, array, size);
				array.remove(possible.get(depth).get(i));
			}
		}
	}

	private boolean isPossible(String bannedId, String userId) {
		if (bannedId.length() != userId.length()) {
			return false;
		}
		char[] banArray = bannedId.toCharArray();
		char[] userArray = userId.toCharArray();

		for (int i = 0; i < banArray.length; i++) {
			if (banArray[i] == '*') {
				continue;
			}
			if (userArray[i] != banArray[i]) {
				return false;
			}
		}
		return true;
	}
}