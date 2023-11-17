package backjon.implement2;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/17143
// 낚시왕

// 낚시왕이 한번 이동할 때마다 O(n) 100 * 100 = 10000
// 총 c번 이동 가능 (100번) 
// 10000 * 100 = 1,000,000
public class Implement4 {
	public static int[][] matrix;
	public static ArrayList<Shark> array;
	public static int r;
	public static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		String[] temp = br.readLine().split(" ");
		r = Integer.parseInt(temp[0]);
		c = Integer.parseInt(temp[1]);
		int m = Integer.parseInt(temp[2]);

		matrix = new int[r][c];
		array = new ArrayList<>();
		array.add(new Shark(0, 0, 0, 0, 0)); // matrix 인덱스 번호와 맞춰주기 위해 더미 shark을 0번 인덱스에 넣어줌
		array.get(0).dead = true;

		for (int i = 0; i < m; i++) {
			temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]) - 1;
			int y = Integer.parseInt(temp[1]) - 1;
			int s = Integer.parseInt(temp[2]);
			int d = Integer.parseInt(temp[3]);
			int z = Integer.parseInt(temp[4]);

			if (d == 1 || d == 2) {
				s = s % (r * 2 - 2); // 재자리 돌아오는 값으로 나눠줌
			} else {
				s = s % (c * 2 - 2);
			}

			matrix[x][y] = i + 1;
			array.add(new Shark(x, y, s, d, z));
		}
		for (int k = 0; k < c; k++) {
			
			/*
			// 상어 그림 호출
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (matrix[i][j] != 0) {
						System.out.print(array.get(matrix[i][j]).z + " ");
					} else {
						System.out.print(matrix[i][j] + " ");
					}
				}
				System.out.println();
			}
			System.out.println();
			*/
			
			result += catchShark(k);
			moveShark();
		}



		System.out.println(result);
	}

	private static int catchShark(int col) {
		int size = 0;
		for (int i = 0; i < r; i++) {
			if (matrix[i][col] != 0) {
				int index = matrix[i][col];
				size = array.get(index).z; // 잡은 상어 사이즈
				array.get(index).dead = true; // array에서 상어 죽었다고 표기
				matrix[i][col] = 0; // 상어 제거
				break;
			}
		}
		return size;
	}

	private static void moveShark() {
		for (int i = 1; i < array.size(); i++) {
			Shark shark = array.get(i);
			if (shark.dead) {
				continue;
			}

			for (int j = 0; j < shark.s; j++) {
				move(shark);
			}
		}
		resetMatrix();

	}

	private static void move(Shark shark) {
		int dir = shark.d;
		switch (dir) {
		case 1: // 위
			if (shark.x != 0) {
				shark.x -= 1;
			} else {
				shark.d = 2;
				shark.x += 1;
			}
			break;
		case 2: // 아래
			if (shark.x != r - 1) {
				shark.x += 1;
			} else {
				shark.d = 1;
				shark.x -= 1;
			}
			break;
		case 3: // 오른쪽
			if (shark.y != c - 1) {
				shark.y += 1;
			} else {
				shark.d = 4;
				shark.y -= 1;
			}
			break;
		case 4: // 왼쪽
			if (shark.y != 0) {
				shark.y -= 1;
			} else {
				shark.d = 3;
				shark.y += 1;
			}
			break;
		}

	}
	private static void resetMatrix() {
		matrix = new int[r][c];
		for(int i = 1; i<array.size(); i++) {
			Shark shark = array.get(i);
			if(shark.dead) {
				continue;
			}
			if(matrix[shark.x][shark.y] == 0) {
				matrix[shark.x][shark.y] = i;
			}else {
				if(array.get(matrix[shark.x][shark.y]).z < array.get(i).z) {
					array.get(matrix[shark.x][shark.y]).dead = true;
					matrix[shark.x][shark.y] = i;
				}else {
					array.get(i).dead = true;
				}
			}
		}
		
	}
	
	public static class Shark {
		int x;
		int y;
		int s; // 속력
		int d; // 이동방향(1:위, 2:아래, 3:오른쪽, 4:왼쪽)
		int z; // 크기
		boolean dead; // 사망 여부

		public Shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
			this.dead = false;
		}
	}

}
