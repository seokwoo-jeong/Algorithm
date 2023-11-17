package backjon2.string;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/20920
// 영단어 암기는 괴로워 (실3)

public class String02 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);	// 영단어 개수
		int m = Integer.parseInt(temp[1]);	// 길이 기준
		
		HashMap<String, Word> hash = new HashMap<>();
		ArrayList<Word> wordList = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			String word = br.readLine();
			
			if(word.length() < m) {	//m못넘으면 버림
				continue;
			}
			
			if(!hash.containsKey(word)) {
				Word w = new Word(word);
				hash.put(word, w);
				wordList.add(w);
				
			}else {
				hash.get(word).count ++;
			}
		}
		Collections.sort(wordList);
	
		StringBuilder sb = new StringBuilder();
		for(Word w : wordList) {
			sb.append(w.name + "\n");
		}
		System.out.println(sb.toString());

	}
	private static class Word implements Comparable<Word>{
		String name;
		int length;
		int count;
		
		public Word(String name) {
			this.name = name;
			this.length = name.length();
			this.count = 1;
		}

		@Override
		public int compareTo(Word o) {
			if(this.count != o.count) {
				return o.count - this.count;	//내림차순
			}
			
			if(this.length != o.length) {
				return o.length - this.length;	//내림차순
			}
			
			return this.name.compareTo(o.name);	//오름차순
		}
	}

}
