package backjon2.string;

//https://www.acmicpc.net/problem/20920
//영단어 암기는 괴로워 (실3)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class String02_RE {
	private static int n;
	private static int m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		Map<String,Info> hash = new HashMap<>();
		List<Info> infoList = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			String name = br.readLine();
			
			if(name.length() < m) {
				continue;
			}
			
			if(hash.keySet().contains(name)){
				hash.get(name).plusCount();
			}else {
				Info info = new Info(name, 1, name.length());
				hash.put(name, info);
				infoList.add(info);
			}
		}
		Collections.sort(infoList);
		
		StringBuilder sb = new StringBuilder();
		for(Info info : infoList) {
			sb.append(info.name + "\n");
		}
		System.out.println(sb.toString());
		
	}
	
	private static class Info implements Comparable<Info>{
		String name;
		int count;
		int length;
		
		public Info (String name, int count, int length) {
			this.name = name;
			this.count = count;
			this.length = length;
		}
		
		public void plusCount() {
			this.count++;
		}
		
		@Override
		public int compareTo(Info o) {
			if(o.count != this.count) {
				return o.count - this.count;
			}else if(o.length != this.length) {
				return o.length - this.length;
			}
			
			return this.name.compareTo(o.name);
		}
	}

}
