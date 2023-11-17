package softeer.starthree;

import java.util.*;
import java.io.*;

// https://softeer.ai/practice/info.do?idx=1&eid=804
// [인증평가(3차) 기출] 플레이페어 암호
public class StarThree1 {

	/*
	 * 1. 중복된거 제거하고 matrix에 넣기 2. J는 제외(i==j)
	 * 
	 * 3. 두쌍씩 짝지어서 동일할 경우 X추가 4. XX일 경우 Q추가 5. 마지막은 그냥 X추가
	 * 
	 * 6. 같은행이면 오른쪽 값 7. 같은열이면 아래 값 8. 다른행이면 서로 열 바꾼 값
	 */

	static char[][] matrix;
	static int size;
	static String newMsg;

	public static void main(String args[]) throws IOException {
		size = 5;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg = br.readLine();
		String key = br.readLine();
		matrix = setMatrix(key.toCharArray());
		newMsg = "";
		setNewMsg(msg);
		String answer = getAnswer();
		System.out.println(answer);
	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static String getAnswer() {
		// System.out.println(newMsg);
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (int i = 0; i < newMsg.length() - 1; i += 2) {
			flag = false;
			Node node1 = getNode(newMsg.charAt(i));
			Node node2 = getNode(newMsg.charAt(i + 1));

			if (node1.x == node2.x) { // 행이 같은경우
				node1.y++;
				node2.y++;
				if (node1.y == 5) {
					node1.y = 0;
				}
				if (node2.y == 5) {
					node2.y = 0;
				}

			} else if (node1.y == node2.y) {
				node1.x++;
				node2.x++;
				if (node1.x == 5) {
					node1.x = 0;
				}
				if (node2.x == 5) {
					node2.x = 0;
				}
			} else {
				flag = true;
				sb.append(matrix[node1.x][node2.y]);
				sb.append(matrix[node2.x][node1.y]);
			}
			if (!flag) {
				sb.append(matrix[node1.x][node1.y]);
				sb.append(matrix[node2.x][node2.y]);
			}

		}
		return sb.toString();
	}

	private static Node getNode(char c) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (matrix[i][j] == c) {
					Node node = new Node(i, j);
					return node;
				}
			}
		}
		return null;
	}

	private static void setNewMsg(String message) {
		boolean flag = true;
		StringBuilder sb = new StringBuilder(message);
		for (int i = 0; i < sb.length() - 1; i += 2) {
			if (sb.charAt(i) == sb.charAt(i + 1)) {
				if (sb.charAt(i) == 'X') {
					sb.insert(i + 1, 'Q');
				} else {
					sb.insert(i + 1, 'X');
				}
				// System.out.println(message);
				// System.out.println(sb.toString());
				setNewMsg(sb.toString());
				flag = false;
				break;
			}
		}
		if (sb.length() % 2 != 0) {
			sb.append('X');
		}
		if (flag) {
			newMsg = sb.toString();
		}

	}

	private static char[][] setMatrix(char[] array) {
		char[][] temp = new char[size][size];
		int x = 0;
		int y = 0;
		int[] alpha = new int[26];
		alpha[9] = 1; // J제외
		for (int i = 0; i < array.length; i++) {
			if (alpha[array[i] - 65] == 0) {
				temp[x][y] = array[i];
				alpha[array[i] - 65] = 1;
				y++;
			}
			if (y == 5) {
				x++;
				y = 0;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (x == 5) { // 다채운경우
				break;
			}
			if (alpha[i] == 0) {
				temp[x][y] = (char) (i + 65);
				y++;
			}
			if (y == 5) {
				x++;
				y = 0;
			}

		}
		/*
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
		*/

		return temp;
	}
}
