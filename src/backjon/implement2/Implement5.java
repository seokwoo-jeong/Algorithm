package backjon.implement2;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/17140
// 이차원 배열과 연산
public class Implement5 {
	private static int x;
	private static int y;
	private static int tempX;
	private static int tempY;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int r = Integer.parseInt(temp[0]) -1;	// x index
		int c = Integer.parseInt(temp[1]) -1;	// y index
		int k = Integer.parseInt(temp[2]);		// value

		x = 3;
		y = 3;
		tempX = Integer.MIN_VALUE;
		tempY = Integer.MIN_VALUE;
		int[][] matrix = new int[100][100];
		
		for(int i = 0; i<x; i++) {
			temp = br.readLine().split(" ");
			for(int j = 0; j<temp.length; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		if(isRight(k, matrix[r][c])) {
			System.out.println(0);
			System.exit(0);
		}
		
		int time = 0;
		while(time < 100) {
			time++;
			System.out.println("--------------");
			if(x>=y) {	//행에 대해서 정렬 수행
				for(int i = 0; i<x; i++) {
					getOneRow(i, matrix);
				}
			}else {	//열에 대해서 정렬 수행
				for(int i = 0; i<y; i++) {
					getOneCol(i, matrix);
				}
				
			}
			break;
			/*
			if(isRight(k, matrix[r][c])) {
				System.out.println(time + "sdfsdf");
				break;
			}
			*/
			
			
			/*
			for(int q = 0; q< 100; q++) {
				for(int j = 0; j<100; j++) {
					System.out.print(matrix[q][j] + " ");
				}
				System.out.println();
			}
			*/
			//break;
		}
		
	}

	
	
	
	private static void getOneCol(int y, int[][] matrix) {
		PriorityQueue<Info> queue = new PriorityQueue<>();
		HashMap<Integer,Integer> hash = new HashMap<>();
		
		int key = 0;
		for(int i = 0; i<x; i++) {
			key = matrix[i][y];
			if(hash.isEmpty() || !hash.containsKey(key)) {
				hash.put(key, 1);
				continue;
			}
			
			hash.replace(key, hash.get(key)+1);
		}
		
		for(int keyy : hash.keySet()) {
			queue.add(new Info(keyy, hash.get(keyy)));
		}
		int i = 0;
		while(!queue.isEmpty()) {
			Info info = queue.poll();
			matrix[i][key] = info.key;
			i++;
			matrix[i][key] = info.count;
			i++;
			System.out.print(info.key + " " + info.count + " ");
		}
		System.out.println("--------------");
		y = Math.max(i, y);
		while(i <= 99) {
			matrix[i][key] = 0;
			i++;
			matrix[i][key] = 0;
			i++;
		}
	}




	private static void getOneRow(int x, int[][] matrix) {
		PriorityQueue<Info> queue = new PriorityQueue<>();
		HashMap<Integer,Integer> hash = new HashMap<>();
		
		int key = 0;
		for(int i = 0; i<y; i++) {
			key = matrix[x][i];
			if(hash.isEmpty() || !hash.containsKey(key)) {
				hash.put(key, 1);
				continue;
			}
			
			hash.replace(key, hash.get(key)+1);
		}
		
		for(int keyy : hash.keySet()) {
			queue.add(new Info(keyy, hash.get(keyy)));
			System.out.println(keyy + "  " +  hash.get(keyy));
		}
		int i = 0;
		while(!queue.isEmpty()) {
			Info info = queue.poll();
			matrix[key][i] = info.key;
			i++;
			matrix[key][i] = info.count;
			i++;
			
			System.out.print(info.key + " " + info.count + " ");
		}
		System.out.println();
		while(i <= 99) {
			matrix[key][i] = 0;
			i++;
			matrix[key][i] = 0;
			i++;
		}
	}




	private static class Info  implements Comparable<Info> { 
		public int key;
		public int count;
		
		public Info(int key, int count) {
			this.key = key;
			this.count = count;
		}

		@Override
		public int compareTo(Info o) {
			if(this.count == o.count) {
				if(this.key < o.key) {
					return -1;
				}else {
					return 1;
				}
			}
			
			if(this.count < o.count) {
				return -1;
			}else {
				return 1;
			}
		}
	}
	
	
	private static boolean isRight(int k, int value) {
		if(k == value) {
			return true;
		}
		return false;
	}

}
