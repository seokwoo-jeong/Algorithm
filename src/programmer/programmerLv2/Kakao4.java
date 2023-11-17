package programmer.programmerLv2;
import java.util.ArrayList;

public class Kakao4 {
	// https://programmers.co.kr/learn/courses/30/lessons/72412
	// 순위 검색 (IDE사용 X)
	public int[] solution(String[] info, String[] query) {
		ArrayList<User> userArray = defUserArray(info);

		int[] answer = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			answer[i] = readQuery(userArray, query[i]);
		}
		return answer;
	}

	public int readQuery(ArrayList<User> userArray, String query) {
		int count = 0;
		query = query.replace(" and", "");
		User queryInfo = new User(query.split(" "));

		for (int i = 0; i < userArray.size(); i++) {
			User user = userArray.get(i);
			if (isMatchLanguage(queryInfo, user) && isMatchJob(queryInfo, user) && isMatchCareer(queryInfo, user)
					&& isMatchFood(queryInfo, user) && isMatchScore(queryInfo, user)) {
				count++;
			}
		}

		return count;
	}

	public boolean isMatchScore(User query, User user) {
		boolean flag = false;
		if (query.score <= user.score) {
			flag = true;
		}
		return flag;
	}

	public boolean isMatchFood(User query, User user) {
		boolean flag = false;
		if (query.food.equals("-") || query.food.equals(user.food)) {
			flag = true;
		}
		return flag;
	}

	public boolean isMatchCareer(User query, User user) {
		boolean flag = false;
		if (query.career.equals("-") || query.career.equals(user.career)) {
			flag = true;
		}
		return flag;
	}

	public boolean isMatchJob(User query, User user) {
		boolean flag = false;
		if (query.job.equals("-") || query.job.equals(user.job)) {
			flag = true;
		}
		return flag;
	}

	public boolean isMatchLanguage(User query, User user) {
		boolean flag = false;
		if (query.language.equals("-") || query.language.equals(user.language)) {
			flag = true;
		}
		return flag;
	}

	public ArrayList<User> defUserArray(String[] info) {
		ArrayList<User> userArray = new ArrayList<>();
		for (int i = 0; i < info.length; i++) {
			String[] temp = info[i].split(" ");
			User user = new User(temp);
			userArray.add(user);
		}
		return userArray;
	}

	class User {
		String language;
		String job;
		String career;
		String food;
		int score;

		public User(String[] info) {
			this.language = info[0];
			this.job = info[1];
			this.career = info[2];
			this.food = info[3];
			this.score = Integer.parseInt(info[4]);
		}
	}

}
