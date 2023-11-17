package programmer.programmerLv2;

public class Main {
	public static void main(String[] args) {
//		Greedy2 greedy2= new Greedy2();
//		int[] people = {70, 50, 80, 50}; 
//		int limit = 100;
//		greedy2.solution(people, limit);
		
		
		/*
		Kakao5 k = new Kakao5();
		String[] data = {"N~F=0","R~T>2"};
		k.solution(2, data);
		*/
		
		/*
		Kakao6 k = new Kakao6();
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		String[] a= k.solution(orders, course);
		for(int i = 0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		*/
		/*
		Kakao7 k = new Kakao7();
		k.solution(")(");
		*/
		
		/*
		Kakao8 k = new Kakao8();
		k.solution("50*6-3*2");
		*/
		
		/*
		Kakao9 k = new Kakao9();
		k.solution(4,5,new String[] {"CCBDE", "AAADE", "AAABF", "CCBBF"});		
		*/
		
		Kakao13 k = new Kakao13();
		k.solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"});
	}

}
