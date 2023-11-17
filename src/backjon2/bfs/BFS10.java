package backjon2.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/9019
// DSLR (골4)

public class BFS10 {

	private static int b;
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		int index = 0;
		int a = 0;
		String[] temp = null;
		sb = new StringBuilder();
		while(index < t) {
			temp = br.readLine().split(" ");
			
			a = Integer.parseInt(temp[0]);
			b = Integer.parseInt(temp[1]);
			
			bfs(a);
			
			index++;
		}
		System.out.println(sb.toString());
		
	}
	
	private static void bfs(int a) {
		HashSet<Integer> hash = new HashSet<>();
		Queue<Info> queue = new LinkedList<>();
		
		queue.add(new Info(a,""));
		hash.add(a);
		
		while(!queue.isEmpty()) {
			Info info = queue.poll();
			
			if(info.no == b) {
				sb.append(info.result + "\n");
				return;
			}
			
			Info newInfo = null;
			newInfo = caseD(info,hash,queue);
			addQueue(info, newInfo, hash, queue);
			
			newInfo = caseS(info,hash,queue);
			addQueue(info, newInfo, hash, queue);
			
			newInfo = caseL(info,hash,queue);
			addQueue(info, newInfo, hash, queue);
			
			newInfo = caseR(info,hash,queue);
			addQueue(info, newInfo, hash, queue);
		}
		
	}
	private static Info caseR(Info info, HashSet<Integer> hash, Queue<Info> queue) {
		StringBuilder temp = getFourWord(info);
		
		int d1 = Character.digit(temp.charAt(0),10);
		int d2 = Character.digit(temp.charAt(1),10);
		int d3 = Character.digit(temp.charAt(2),10);
		int d4 = Character.digit(temp.charAt(3),10);

		int no = ((d4 * 10 + d1) * 10 + d2) * 10 + d3;
		
		return new Info(no, "R");
	}

	private static Info caseL(Info info, HashSet<Integer> hash, Queue<Info> queue) {
		StringBuilder temp = getFourWord(info);
		
		int d1 = Character.digit(temp.charAt(0),10);
		int d2 = Character.digit(temp.charAt(1),10);
		int d3 = Character.digit(temp.charAt(2),10);
		int d4 = Character.digit(temp.charAt(3),10);

		int no = ((d2 * 10 + d3) * 10 + d4) * 10 + d1;
		
		return new Info(no, "L");
	}

	private static Info caseS(Info info, HashSet<Integer> hash, Queue<Info> queue) {
		int no = info.no-1;
		if(no == -1) {
			no = 9999;
		}
		return new Info(no, "S");
	}
	
	
	private static Info caseD(Info info, HashSet<Integer> hash, Queue<Info> queue) {
		int no = info.no*2;
		if(no > 9999) {
			no = no % 10000;
		}
		return new Info(no, "D");
	}
	
	private static StringBuilder getFourWord(Info info) {
		StringBuilder temp = new StringBuilder();
		temp.append(info.no);
		int size = 4-temp.length();
		for(int i = 0; i<size; i++) {
			temp.insert(i, '0');
		}
		return temp;
	}
	
	private static void addQueue(Info info, Info newInfo, HashSet<Integer> hash, Queue<Info> queue) {
		if(hash.contains(newInfo.no)) {
			return;
		}
		hash.add(newInfo.no);
		queue.add(new Info(newInfo.no, info.result + newInfo.result));
	}
	
	private static class Info{
		int no;
		String result;
		
		public Info(int no, String result) {
			this.no = no;
			this.result = result;
		}
	}

}
