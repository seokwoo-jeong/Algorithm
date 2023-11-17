package codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import codingtest.Nhn202205.Nhn1;
import codingtest.Nhn202205.Nhn2;
import codingtest.Nhn202205.Nhn2_Re;
import codingtest.Nhn202205.Nhn2_rere;
import codingtest.Nhn202205.Nhn3;
import codingtest.Nhn202205.Nhn4;
import codingtest.autoever2208.Solution3;
import codingtest.dev2_220623.Dev1;
import codingtest.dev2_220623.Dev3;
import codingtest.eleven202205.Eleven1;
import codingtest.hanhwasol2211.Hanwha1;
import codingtest.lotte202206.Lotte2;
import codingtest.sktelecom202206.SkTel1_Re;
import codingtest.sktelecom202206.SkTel2_Re;
import codingtest.ssg202205.Ssg1;
import codingtest.ssg202205.Ssg2;
import codingtest.ssg202205.Ssg2_re;
import codingtest.ssg202205.Ssg3;
import codingtest.ssg202205.Ssg4;
import codingtest.ssg202205.Ssg4_re;
import codingtest.summerCodingTest220508.SummerCoding1;
import codingtest.summerCodingTest220508.SummerCoding2;
import codingtest.toss220806.Toss2;
import codingtest.wooribank220723.WooriBank2;

public class Main {

	public static void main(String[] args) {
		/*
		 * SummerCoding1 summerCoding1 = new SummerCoding1(); int[][] a = {{80, 35},
		 * {70, 38}, {100, 41}, {75,30}, {160,80}, {77, 29}, {181, 68}, {151, 76}};
		 * System.out.println(summerCoding1.solution(a));
		 */

		/*
		 * SummerCoding2 summerCoding2 = new SummerCoding2(); String[] a = {
		 * "[402]Sindy", "[403]James", "[405]Azad,Louis,Andy,asd", "[101]Azad,Guard",
		 * "[501]Sindy,Guard,Azad" }; int target = 403; summerCoding2.solution(a,
		 * target);
		 */

		/*
		 * Ssg1 ssg1 = new Ssg1(); int[] v = {4,5,5}; int a = 2; int b = 1;
		 * System.out.println(ssg1.solution(v,a,b));
		 */

		Ssg2_re ssg2 = new Ssg2_re();
		//String[] logs = { "0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90",
		//		"0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90" };
		/*String[] logs = { "1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100",
				"1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100",
				"1903 2 100", "1903 1 100", "1101 1 95", "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100",
				"1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100", "1102 9 100" };
		*/
	//	String[] logs = { "1901 10 50", "1909 10 50" };
		String[] logs = { "0001 1 0", "0001 2 0", "0001 3 0", "0001 4 0", "0001 5 0", "0456 1 0", "0456 2 0",
				"0456 3 0", "0456 4 0", "0456 5 0" };
	
		ssg2.solution(logs);

		/*
		 * Ssg3 ssg3 = new Ssg3(); int[][] masks = {{3651,365},{10,1}}; String[] dates =
		 * {"2025/01/01~2025/12/31"}; ssg3.solution(masks, dates);
		 */

		Ssg4_re ssg4 = new Ssg4_re();
		// int[][] macaron = { { 1, 1 }, { 2, 1 }, { 1, 2 }, { 3, 3 }, { 6, 4 }, { 3, 1
		// }, { 3, 3 }, { 3, 3 }, { 3, 4 },
		// { 2, 1 } };
		// int[][] macaron =
		// {{1,1},{1,2},{1,4},{2,1},{2,2},{2,3},{3,4},{3,1},{3,2},{3,3},{3,4},{4,4},{4,3},{5,4},{6,1}};

		// ssg4.solution(macaron);
		// int[][] macaron = { { 1, 1 }, { 2, 1 }, { 3, 1 }, { 3, 3 }, { 6, 4 }, { 3, 1
		// }, { 3, 3 }, { 3, 3 }, { 3, 4 },
		// { 5, 4 }, { 5, 4 }, { 2, 1 } };
		// ssg4.solution(macaron); for(int i =0; i<ssg4.solution(macaron).length; i++)
		// {
		// System.out.println(ssg4.solution(macaron)[i]);
		// }

		/*
		 * Eleven1 eleven1 = new Eleven1(); int a = 53000; int b = 1578653000;
		 * eleven1.solution(a,b);
		 */

		/*
		 * Nhn1 nhn1 = new Nhn1(); int[][] cards1 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
		 * int[][] cards2 = {{5, 7, 9, 11, 13}, {11, 13, 15, 17, 19}};
		 * nhn1.solution(cards1,cards2);
		 */

		/*
		 * Nhn2_rere nhn2 = new Nhn2_rere(); int[] balance = { 100,1,1,1,1 }; int[][]
		 * transaction = { { 1, 2, 100 }, { 2, 3, 101 }, { 3, 4, 102 }, { 4,5,103 }, {
		 * 5,1,104 } }; int[] abnormal = { 1 }; nhn2.solution(balance, transaction,
		 * abnormal);
		 */

		/*
		 * Nhn3 nhn3 = new Nhn3(); String[] maze = {"AAAAA", "AABBB", "CAEFG", "AAEFF"};
		 * String[] queries = {"1 1 1 5 AF", "1 1 4 5 AF", "2 1 4 5 FAE", "1 5 4 5 ABF",
		 * "1 1 4 1 A"}; nhn3.solution(maze, queries);
		 */

		/*
		 * Nhn4 nhn4 = new Nhn4();
		 * 
		 * long[] players = {10, 11, 15, 14, 16, 18, 19, 20}; int power = 10; int k =2;
		 * nhn4.solution(players, power, k);
		 */

		/*
		 * Lotte2 lotte2 = new Lotte2(); int r = 3; int c = 5; lotte2.solution(r, c);
		 */

		/*
		 * Dev1 dev1 = new Dev1(); // ex) {1,3,2} -> {1,2,2} result: 1 // ex) {4,3,2} ->
		 * {2,2,2} result: 3 // ex) {5,2,1,1,5,3,4} -> {1,1,1,1,3,3,4} result: 7 int[]
		 * array = {5,2,1,1,5,3,4}; dev1.solution(array);
		 */

		/*
		 * Dev3 dev3 = new Dev3(); int a = 9; int b = 7; int[][] lands = {{2, 2}, {2,
		 * 3}, {2, 5}, {3, 2}, {3, 4}, {3, 5}, {3, 6}, {4, 3}, {4, 6}, {5, 2}, {5, 5},
		 * {6, 2}, {6, 3}, {6, 4}, {6, 6}, {7, 2}, {7, 6}, {8, 3}, {8, 4}, {8, 5}};
		 * dev3.solution(a,b,lands);
		 */

		/*
		 * WooriBank2 wooriBank2 = new WooriBank2(); String[] grid = {"......####",
		 * "...#...###", "..#.##..##", "..#...#..#", "...#.#....", "....#..###"};
		 * String[] grid2 = {"...#......","..#.##....","..#...#...","...#.#...."};
		 * wooriBank2.solution(grid);
		 */

		/*
		 * Toss2 toss2 = new Toss2(); int[] levels = {1}; toss2.solution(levels);
		 */

		/*
		 * Hanwha1 h = new Hanwha1(); h.solution();
		 */

		SkTel1_Re sk = new SkTel1_Re();
		int[] temp = new int[1000];
		for (int i = 1; i <= 1000; i++) {
			temp[i - 1] = i;
		}

		sk.solution(temp);
		/*
		 * SkTel2_Re sk = new SkTel2_Re(); sk.solution(new int[] {24,59,59,60}, new
		 * int[][] {{50000,550000},{50000,550000},{350000,550000},{50000,550000}},new
		 * int[] {350000,50000,40000,50000});
		 */

		/*
		 * List<String> array = Arrays.asList("자기소개", "이직 사유", "직무에서 가장 필요한 역량은?",
		 * "지원하게 된 동기는 무엇인가요?", "스트레스 푸는법(취미, 특기)", "MZ세대들이 현대오토에버에 지원을 하는 이유",
		 * "자신의 장단점", "원치 않는 직무를 배정받으면 어떻게 할건지?", "도전 경험", "업무를 하면서 가장 힘들었던 경험 (실패 경험)",
		 * "DBA 직무를 지원하지 않고 어플리케이션 개발 직무를 지원한 이유", "입사 후 포부 (자기 PR)",
		 * "상사가 부당한 업무를 시킨 경우", "나에게 가장 나쁜 상사란", "상사와 의견 차이가 발생한 경우",
		 * "상사와 관계가 좋지 못하다면 어떻게 해결할 것인가?", "최근 현대오토에버의 기사를 본적이 있는지");
		 * 
		 * Random random = new Random();
		 * 
		 * int index = random.nextInt(array.size());
		 * System.out.println(array.get(index));
		 * 
		 * char[] a = new char[3]; if(a[0] == 0) { System.out.println(a[0] + "d"); }
		 */
	}

}
