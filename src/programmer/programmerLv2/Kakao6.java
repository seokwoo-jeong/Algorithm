package programmer.programmerLv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/72411
// 메뉴 리뉴얼
public class Kakao6 {
	   public boolean[] isVisit;
	   ArrayList<Menu> menuArray;
	   ArrayList<String> answer = new ArrayList<>();
	    public String[] solution(String[] orders, int[] course) {
	        int size = 0;
	        
	        for(int i = 0; i<course.length; i++){
	            size = course[i];
	            menuArray = new ArrayList<>();
	            for(int j = 0; j<orders.length; j++){
	            	char[] sortedOrder = sortOrders(orders[j]);

	                isVisit = new boolean[orders[j].length()];
	                pickMenu(0,"",0,size, sortedOrder);
	            }
	            Collections.sort(menuArray);
	            /*
	            for(int k = 0; k<menuArray.size(); k++) {
	            	System.out.println(menuArray.get(k).name + " " + menuArray.get(k).count);
	            }
	            */
	            setAnswer();
	        }
	        String[] result = new String[answer.size()];
	        
	        int index=0;
	        for(String temp : answer){
	        	result[index++] = temp;
	        }
	        Arrays.sort(result);
	        return result;
	    }
	    
	    private char[] sortOrders(String orders) {
        	char[] temp = orders.toCharArray();
        	Arrays.sort(temp);
        	return temp;
		}

		private void setAnswer() {
            if(!menuArray.isEmpty() && menuArray.get(0).count != 1) {
	            answer.add(menuArray.get(0).name);
    	        for(int k = 1; k<menuArray.size(); k++) {
    	        	int max = menuArray.get(0).count;
    	        	if(max == menuArray.get(k).count) {
    	        		answer.add(menuArray.get(k).name);
    	        	}else {
    	        		break;
    	        	}
    	        }	
            }
		}

		public void pickMenu(int depth, String current,int index, int size, char[] order){
	        if(depth == size){
	        	boolean flag = false;
	        	for(int i = 0; i<menuArray.size(); i++) {
	        		if(current.equals(menuArray.get(i).name)) {
	        			menuArray.get(i).plus();
	        			flag = true;
	        			break;
	        		}
	        	}
	        	if(!flag) {
	        		Menu menu = new Menu(current,1);
	        		menuArray.add(menu);
	        	}
	            return;
	        }
	        
	        for(int i = index; i<order.length; i++){
	            if(!isVisit[i]){
	                isVisit[i] = true;
	                pickMenu(depth+1,current+order[i],i+1,size,order);
	                isVisit[i] = false;
	            }
	        }
	        return;
	    }
	    
	    
	    public class Menu implements Comparable<Menu>{
	        public String name;
	        public int count;
	        
	        public Menu(String name, int count){
	            this.name = name;
	            this.count = count;
	        }
	        public void plus() {
	        	count++;
	        }
			@Override
			public int compareTo(Menu o1) {
				return o1.count - this.count;
			}
		
	    }
	}