package backjon.implement2;

import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/16235
// 나무 재테크

/* 각 칸에는 여러 나무가 존재할 수 있다. 처음에 모든 칸에 5만큼 양분이 존재
 * 봄: 나무가 양분을 나이만큼 먹고 나이가 1증가
 *    나이가 어린 나무부터 양분 먹고, 나이만큼 양분 못먹으면 즉사
 * 여름: 봄에 죽은 나무가 양분으로 변함. 죽은 나무 나이 / 2 한 값 (소수점 버림)
 * 가을: 나이가 5배수인 나무가 번식한다. (인근 8칸) -> 1인 나무가 생긴다.
 * 겨울: 각 칸에 양분을 추가한다.
 * 
 * 둘째 줄부터 N개의 줄에 A배열의 값이 주어짐
 * 다음 M개의 줄에는 상도가 심은 나무의 정보를 나타내는 세 정수 X,Y,Z가 주어짐.
 * (X,Y) -> 위치, 마지막 값은 나무 나이
 * 
 * 
 */

/*
 * 봄 때 나무 제거 하는거 for문 돌려서 바로바로 제거 하기 위해 iterator사용 O(1)
 * 가을 때 새로 추가되는 나무 for문돌려서 list에 넣지 말고 addAll 사용해서 O(1)으로 넣으니 해결
*/
public class Implement2 {
	private static int[][] matrix; // 양분 값
	private static LinkedList<Tree> treeArray;
	private static int[][] addMatrix; // 겨울에 양분 추가용
	private static int n;// NxN(땅 크기)
	private static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]); // NxN(땅 크기)
		int m = Integer.parseInt(temp[1]); // 나무 개수
		int k = Integer.parseInt(temp[2]); // K년 지난 후 땅의 나무 개수 구하기

		result = 0;
		matrix = new int[n][n];
		addMatrix = new int[n][n];
		treeArray = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < temp.length; j++) {
				addMatrix[i][j] = Integer.parseInt(temp[j]); // 겨울 양분 추가용
				matrix[i][j] = 5; // 현재 땅 양분
			}
		}

		for (int i = 0; i < m; i++) { // 입력으로 들어오는 나무 위치는 모두 서로 다름
			temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]) - 1;
			int y = Integer.parseInt(temp[1]) - 1;
			Tree tree = new Tree(x, y, Integer.parseInt(temp[2]));
			treeArray.add(tree);
			result++;
		}
		Collections.sort(treeArray);

		for (int i = 0; i < k; i++) {
			spring();
			fall();
			winter();
			
		
		}
		System.out.println(result);

	}

	private static void spring() {
		// 봄: 나무가 양분을 나이만큼 먹고 나이가 1증가
		// 나이가 어린 나무부터 양분 먹고, 나이만큼 양분 못먹으면 즉사
		ArrayList<Tree> deadTree = new ArrayList<>();

		Iterator<Tree> iterator = treeArray.iterator();
		while (iterator.hasNext()) {
			Tree tree = iterator.next();
			int x = tree.x;
			int y = tree.y;
			int age = tree.age;
			if (matrix[x][y] >= age) {
				matrix[x][y] = matrix[x][y] - age;
				tree.getAge();
			} else {
				deadTree.add(tree);
				iterator.remove();
				result--;
			}
		}
		summer(deadTree);
	}

	private static void summer(ArrayList<Tree> deadTree) {
		for (Tree dead : deadTree) { // 죽은 나무들 양분으로 삼기(여름)
			matrix[dead.x][dead.y] += dead.age / 2;
		}
	}

	private static void fall() {
		// 나이가 5배수인 나무가 번식한다. (인근 8칸) -> 1인 나무가 생긴다.
		int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
		LinkedList<Tree> newTree = new LinkedList<>();
		for (Tree tree : treeArray) {
			if (tree.age % 5 == 0) {
				for (int i = 0; i < dx.length; i++) {
					int nx = tree.x + dx[i];
					int ny = tree.y + dy[i];

					if (!isGo(nx, ny)) {
						continue;
					}
					newTree.add(new Tree(nx, ny, 1));
				}
			}
		}
		treeArray.addAll(0,newTree);	//for문돌려서 안넣고 allAll쓰면 O(1)
		result += newTree.size();
	}

	private static boolean isGo(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < n) {
			return true;
		}
		return false;
	}

	private static void winter() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] += addMatrix[i][j];
			}
		}

	}

	private static class Tree implements Comparable<Tree> {
		int x;
		int y;
		int age;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		public void getAge() {
			this.age++;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
}
