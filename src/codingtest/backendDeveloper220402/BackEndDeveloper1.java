package codingtest.backendDeveloper220402;


public class BackEndDeveloper1 {
	
    public int[][] solution(int[][] dist) {
    	int length = dist.length;
    	int[] result1 = new int[length];
    	int[] result2 = new int[length];
     	int x = 0;
    	int y = 0;
    	int max = 0;
    	int first = 0;
    	int last = length-1;
    	int count = 1;
    	boolean flag = false;
    	while(count <= length-1) {
	    	for(int i = 0; i<length; i++) {
	    		for(int j = i+1; j<length; j++) {
	    			if(dist[i][j] > max) {
	    				max = dist[i][j];
	    				x = i;
	    				y = j;
	    			}
	    		}
	    		
	    	}
	    //	System.out.println(x + "  " + y);
	    	if(count == 1) {
		    	result1[first] = x;
		    	result1[last] = y;
		    	first++;
		    	last--;
	    	}else {
	    		for(int i = last+1; i<length; i++) {
	    			if(result1[i] == y) {
	    				result1[first] = x;
	    				first++;
	    				flag = true;
	    				System.out.println(x + "Ddd");
	    				break;
	    			}else if(result1[i] == x) {
	    				result1[first] = y;
	    				first++;
	    				flag = true;
	    				break;
	    			}
	    		}
	    		if(!flag) {
		    		for(int i = first-1; i>=0; i--) {
		    			if(result1[i] == x) {
		    				result1[last] = y;
		    				last--;
		    				break;
		    			}else if(result1[i] == y) {
		    				result1[last] = x;
		    				last--;
		    				break;
		    			}
		    		}
	    		}

	    	}
	    	dist[x][y] = -1;
	    	max = 0;
	    	count ++;
	    	flag = false;
    	}
    	for(int i = 0; i<length; i++) {
    //		System.out.print(result1[i]);
    		result2[i] = result1[length-i-1];
    	}
    	
    	
        int[][] answer = {result1,result2};
        return answer;
    }
}
