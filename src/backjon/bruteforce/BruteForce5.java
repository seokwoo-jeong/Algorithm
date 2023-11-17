package backjon.bruteforce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/14500
// 테트로미노

public class BruteForce5 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int[][] map = new int[x][y];
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				map[i][j] = scanner.nextInt();
			}
		}		
		solution(x, y, map);
	}

	private static void solution(int x, int y, int[][] map) {
		int[][][] cases = { {{0,1},{0,2},{0,3}} , {{1,0},{2,0},{3,0}}    		// ㅡ 인 경우
						  , {{0,1},{0,2},{-1,2}} , {{0,1},{0,2},{1,2}}
						  , {{1,0},{2,0},{2,1}} , {{1,0},{2,0},{2,-1}}
						  , {{0,-1},{0,-2},{-1,-2}} , {{0,-1},{0,-2},{1,-2}}
						  , {{-1,0},{-2,0},{-2,1}} , {{-1,0},{-2,0},{-2,-1}} 	// ㄴ 인 경우
						  , {{0,1},{-1,1},{-1,2}} , {{0,1},{1,1},{1,2}}
						  , {{1,0},{1,1},{2,1}} , {{1,0},{1,-1},{2,-1}}
						  , {{0,-1},{-1,-1},{-1,-2}} , {{0,-1},{1,-1},{1,-2}}
						  , {{-1,0},{-1,-1},{-2,-1}} , {{-1,0},{-1,1},{-2,1}}  	// ㄴㄱ 인 경우
						  , {{0,1},{-1,1},{1,1}} , {{1,0},{1,1},{1,-1}}
						  , {{0,-1},{-1,-1},{1,-1}} , {{-1,0},{-1,1},{-1,-1}}  	// ㅜ 인 경우
						  , {{0,1},{1,0},{1,1}}							 		// ㅁ 인 경우
		};
		//cases[a][b][0] => x
		//cases[a][b][1] => y
		int dx = 0;
		int dy = 0;
		int sum = 0;
		int max = 0;
		for(int i = 0; i< x; i++) {
			for(int j = 0; j < y; j++) {
				sum = map[i][j];
				for(int a = 0; a< cases.length; a++) {
					for(int b = 0; b<3; b++) {
						dx = i + cases[a][b][0];
						dy = j + cases[a][b][1];
						
						if((0<= dx && dx < x) && (0<= dy && dy < y)) {
							sum += map[dx][dy];
						}else {
							sum = map[i][j];
							break;
						}
					}
					max = Math.max(max, sum);
					sum = map[i][j];
				}
			}
		}
		System.out.println(max);
		
		
	}
	
}
