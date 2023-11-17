package backjon2.implement;
import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/15686
// 치킨 배달(골5)

public class Implement07 {
	private static int m;
	private static ArrayList<int[]> homeArray;
	private static ArrayList<int[]> chickenArray;
	private static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);	// matrix size
		m = Integer.parseInt(temp[1]);	// 최대 치킨집 개수
		result = Integer.MAX_VALUE;
		
		homeArray = new ArrayList<>();
		chickenArray = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			temp = br.readLine().split(" ");
			for(int z= 0; z<n; z++) {
				if(temp[z].equals("1")){ 	// 집
					homeArray.add(new int[] {i,z});
				}else if(temp[z].equals("2")) {	//치킨집
					chickenArray.add(new int[] {i,z});
				}
			}
		}
		int[][] pickList = new int[m][2];
		boolean[] isVisit = new boolean[chickenArray.size()];
		pickChicken(0,0,pickList, isVisit);

		System.out.println(result);
	}
	
	private static void pickChicken(int depth, int before, int[][] pickList, boolean[] isVisit) {
		if(depth == m) {
			int min = Integer.MAX_VALUE;
			int sum = 0;
			int distance = 0;
			for(int[] home : homeArray) {
				min = Integer.MAX_VALUE;
				for(int[] chicken : pickList) {
					distance = Math.abs(home[0] - chicken[0])+Math.abs(home[1] - chicken[1]);
					min = Math.min(min, distance);
				}
				sum += min;
			}
			result = Math.min(result, sum);
			return;
		}
		
		for(int i = before; i<isVisit.length; i++) {
			if(isVisit[i]) {
				continue;
			}
			
			pickList[depth][0] = chickenArray.get(i)[0];
			pickList[depth][1] = chickenArray.get(i)[1];
			isVisit[i] = true;
			pickChicken(depth+1, i, pickList, isVisit);
			isVisit[i] = false;
		}
	}

}
