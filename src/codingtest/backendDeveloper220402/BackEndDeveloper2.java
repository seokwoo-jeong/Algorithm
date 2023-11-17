package codingtest.backendDeveloper220402;

public class BackEndDeveloper2 {
	
	String[] grid = {"??b", "abc", "cc?"};
    public int solution(String[] grid) {
    	int[] x = {0,1,0,-1};
    	int[] y = {1,0,-1,0};
    	int rowLength = grid.length;
    	int colLength = grid[0].length();
    	char[][] map = new char[rowLength][colLength];
    	for(int i= 0; i<rowLength; i++) {
    		for(int j = 0; j<colLength; j++) {
    			map[i][j] = grid[i].toCharArray()[j];
    			System.out.print(map[i][j]);
    		}
    		System.out.println();
    	}
    	System.out.println();
    	int dx = 0;
    	int dy = 0;
    	for(int i = 0; i<rowLength; i++) {
    		for(int j = 0; j<colLength; j++) {
    			if(map[i][j] == '?') {
    				for(int k =0; k<3; k++) {
    					dx = i + x[k];
    					dy = j + y[k];
    					
    					if((0 <= dx && dx < rowLength) && (0 <= dy && dy < colLength)){
    						if(map[dx][dy] == 'a' || map[dx][dy] == 'b' || map[dx][dy] == 'c') {
    							map[i][j] = map[dx][dy];
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	int answer = -1;
        return answer;
    }
}
