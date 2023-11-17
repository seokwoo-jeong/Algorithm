package programmer.programmerLv2;

// https://school.programmers.co.kr/learn/courses/30/lessons/60058
// 괄호 변환

/*
 * '(' 와 ')' 의 개수가 같은경우: 균형잡힌 괄호 문자열
 * 개수가 같으면서 짝이 맞는경우: 올바른 괄호 문자열 
 * 
 * 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
 * 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
 * 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
 *  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
 * 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
 *  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
 *  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
 *  4-3. ')'를 다시 붙입니다. 
 *  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
 *  4-5. 생성된 문자열을 반환합니다.
 *  
 *  ex) p: "(()())()" || ")("	|| "()))((()"
 */
public class Kakao7 {
	StringBuilder sb = new StringBuilder();

	public String solution(String p) {
        sb.append(recur(p));
        System.out.println(sb);
        return sb.toString();
    }
    
    public String recur(String p) {
        //1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
        if(p.equals("")) {
        	return p;
        }
        
        //2. 두 균형잡힌 괄호 문자열로 분리
        UV uv = separate(p);
        
        //3. 올바른 문자열인지 확인
        if(isRightString(uv.u)) {//올바른 문자열인 경우
        	return caseThree(uv);
        	
        }else {	//올바른 문자열 아닌 경우
        	
        	return caseFour(uv);
        }
    }
    
    private String caseFour(UV uv) {
    	StringBuilder temp = new StringBuilder(); 
    	temp.append('(');	//4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
    	temp.append(recur(uv.v));	// 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
    	temp.append(')');   // 4-3. ')'를 다시 붙입니다. 
    	temp.append(reverse(uv.u.substring(1,uv.u.length()-1)));	//4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
    	return temp.toString();
	}

	private String caseThree(UV uv) {
    	//3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
    	//v 1번부터 다시 수행
    	StringBuilder temp = new StringBuilder();
    	temp.append(uv.u);	// u를 더한다.
    	temp.append(recur(uv.v));	// v 1번부터 다시 수행한 결과를 문자열 u에 이어 붙인다.
		return temp.toString();
	}

	private String reverse(String u) {
		StringBuilder sb = new StringBuilder(u.length());
		char[] temp = u.toCharArray();
		
		for(int i = 0; i<temp.length; i++) {
			if(temp[i] == '(') {
				sb.append(')');
			}else {
				sb.append('(');
			}
		}
		return sb.toString();
	}

	private boolean isRightString(String u) {
    	char[] temp = u.toCharArray();
    	int count = 0;
    	boolean flag = true;
    	for(int i = 0; i<temp.length; i++) {
    		if(temp[i] == '(') {
    			count++;
    		}else {
    			count--;
    		}
    		if(count <0) {
    			flag = false;
    			break;
    		}
    	}
    	return flag;
	}

	private UV separate(String p) {
    	char[] temp = p.toCharArray();
    	int left = 0;
    	int right = 0;
    	String u = "";
    	String v = "";
    	for(int i =0; i<temp.length; i++) {
    		if(temp[i] == '(') {
    			left++;
    		}else {
    			right++;
    		}
    		if(left==right) {
    			u = p.substring(0,i+1);
    			v = p.substring(i+1);
    			break;
    		}
    	}
    	UV uv = new UV(u,v);
		return uv;
	}

	public class UV {
    	public String u;
    	public String v;
    	
    	public UV(String u, String v) {
    		this.u = u;
    		this.v = v;
    	}
    }
}
