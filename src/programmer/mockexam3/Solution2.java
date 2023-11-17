package programmer.mockexam3;

public class Solution2 {
	public int solution(int[] ingredient) {
		// 1,2,3,1 이면 bomb
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ingredient.length; i++) {
			sb.append(ingredient[i]);
		}
		// System.out.println(sb.toString());
		int index = 0;
		while (true) {
			int size = sb.length();
			if (index < 0) {
				index = 0;
			}
			if (index > size - 4) {
				break;
			}
			if (sb.charAt(index) == '1' && sb.charAt(index + 1) == '2' && sb.charAt(index + 2) == '3'
					&& sb.charAt(index + 3) == '1') {
				sb.delete(index, index + 4); // 1231삭제
				index = index - 3; // 사라진 부분 빼고 붙이고 -3부터 다시 확인
				answer++;
				// System.out.println(index + " " + sb.toString());
			} else {
				index++;
			}
		}
		return answer;
	}
}