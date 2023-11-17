package backjon2.implement;

import java.io.*;

// https://www.acmicpc.net/problem/1244
// 스위치 켜고 끄기 (실4)

public class Implement01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 스위치개수

		String[] temp = br.readLine().split(" ");

		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}

		int studentNo = Integer.parseInt(br.readLine());

		int no = 0;
		for (int i = 0; i < studentNo; i++) {
			temp = br.readLine().split(" ");

			no = Integer.parseInt(temp[1]);
			if (temp[0].equals("1")) { // 남자
				switchMan(no, array);
			} else { // 여자
				switchWoman(no, array);

			}
		}
		for(int z = 0; z<n; z++) {
			System.out.print(array[z] + " ");
			
			if((z+1) % 20 == 0) {
				System.out.println();
			}
		}
	}

	private static void switchMan(int no, int[] array) {
		for(int i = no; i<=array.length; i=i+no) {
			array[i-1] = Math.abs(array[i-1] -1 );
		}
		
	}

	private static void switchWoman(int no, int[] array) {
		int index = no-1;
		int left = index-1;
		int right = index+1;
		while(0<= left && right < array.length) {
			if(array[left] == array[right]) {
				array[left] = Math.abs(array[left] - 1);
				array[right] = Math.abs(array[right] - 1);
				
				left--;
				right++;
			}else {
				break;
			}
		}
		array[index] = Math.abs(array[index] -1);
	}

}
