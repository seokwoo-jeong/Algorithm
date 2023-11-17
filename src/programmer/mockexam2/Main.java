package programmer.mockexam2;

public class Main {

	public static void main(String[] args) {
		int n = 5;
		int[][] roads = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		int[] sources = {2,4,3};
		int destination = 5;
		
		Solution3 s = new Solution3();
		s.solution(n, roads, sources, destination);

	}

}
