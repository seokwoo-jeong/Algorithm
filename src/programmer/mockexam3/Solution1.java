package programmer.mockexam3;

public class Solution1 {
	   public int solution(int a, int b, int n) {
	        //처음에 빈병 n개를 가지고 있음
	        //a개주면 b개 줌
	        int answer = 0;
	        int cur = n;
	        int rest = 0;
	        while(cur >= a){
	            answer += (cur / a) * b;
	            if(cur/a != 0){
	               rest = cur % a; 
	            }else{
	                rest = 0;
	            }
	            cur = (cur/a) * b + rest;
	        }
	        return answer;
	    }
	}