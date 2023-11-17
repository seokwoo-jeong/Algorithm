package codingtest.Nhn202205;

import java.util.LinkedList;
import java.util.Queue;

public class Nhn3 {
	char[][] matrix;
	int[][] countMatrix;
	boolean[][] isVisited;
	int[] dx = {1,0,-1,0};
	int[] dy = {0,1,0,-1};
	int width;
	int height;
    public int[] solution(String[] maze, String[] queries) {
    	height = maze.length;
    	width = maze[0].length();
    	matrix = new char[height][width];
    	countMatrix = new int[height][width];
    	isVisited = new boolean[height][width];
    	defineMatrix(maze);		//matrix선언
    	
    	int[] result = defineQueries(queries);
    	
 
        return result;
    }
    
	private int[] defineQueries(String[] queries) {
		int[] result = new int[queries.length];
		for(int i = 0; i<queries.length; i++) {
			String[] def = queries[i].split(" ");
			bfs(def);
			int finishX = Integer.parseInt(def[2])-1;
			int finishY = Integer.parseInt(def[3])-1;
			
			int val = countMatrix[finishX][finishY];
			if(val == 0) {
				result[i] = -1;
			}else {
				result[i] = val;
			}
			
		}
		return result;

	}

	private void bfs(String[] def) {
    	countMatrix = new int[height][width];
    	isVisited = new boolean[height][width];
		int startIndexX = Integer.parseInt(def[0])-1;
		int startIndexY = Integer.parseInt(def[1])-1;

		char[] possibleArray = def[4].toCharArray();
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {startIndexX,startIndexY});
		isVisited[startIndexX][startIndexY] = true;
		countMatrix[startIndexX][startIndexY] = 1;
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			int startX = xy[0];
			int startY = xy[1];
			
			for(int i =0; i<dx.length; i++) {
				int nx = startX + dx[i];
				int ny = startY + dy[i];
				if(0<=nx&& nx<height && 0<=ny && ny<width) {
					if(contains(possibleArray,matrix[nx][ny])){
						if(!isVisited[nx][ny] || countMatrix[startX][startY] + 1 < countMatrix[nx][ny]) {
							countMatrix[nx][ny] = countMatrix[startX][startY] + 1;
							isVisited[nx][ny] = true;
							queue.offer(new int[] {nx,ny});
						}
					}
				}
			}
		}
		
	}
    public boolean contains(final char[] arr, final char key) {
        boolean flag = false;
        for(int i = 0; i<arr.length; i++) {
        	if(arr[i] == key) {
        		flag = true;
        		break;
        	}
        }
        return flag;
    }

	private void defineMatrix(String[] maze) {
		for(int i = 0; i<maze.length; i++) {
			matrix[i] = maze[i].toCharArray();
		}
		
	}
}
