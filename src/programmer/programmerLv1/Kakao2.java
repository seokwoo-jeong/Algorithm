package programmer.programmerLv1;



// https://programmers.co.kr/learn/courses/30/lessons/72410
// �ű� ���̵� ��õ

/*
 * 1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
 * 2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
 * 3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
 * 4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
 * 5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
 * 6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
     ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
 * 7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
 */
public class Kakao2 {
    public String solution(String new_id) {
        String answer = "";
        
        // 1�ܰ� �빮�� -> �ҹ���
        answer = new_id.toLowerCase(); 
       
        // 2�ܰ� �̻��� ���� ����
        char[] listAnswer = answer.toCharArray();
        StringBuilder tempAnswer = new StringBuilder();
        for(char word: listAnswer) {
        	if( Character.isLowerCase(word) || word == '-' || word == '_' || word == '.' || Character.isDigit(word)) {
        		tempAnswer.append(word);
        	}
        }
        answer = tempAnswer.toString();
       
        
        // 3�ܰ� ..�� .���� ġȯ
        while(answer.contains("..")) {
        	answer = answer.replace("..", "."); 
        }
       
        
        // 4�ܰ� ó���� �����ִ� .����
        if(answer.length() > 0) {
        	if(answer.charAt(0) == '.') {
            	answer = answer.substring(1, answer.length());
            }
        }
        if(answer.length() > 0) {
	        if(answer.charAt(answer.length()-1) == '.') {
	        	answer = answer.substring(0,answer.length()-1);
	        }
        }    
       
        // 5�ܰ� ���� a�� ġȯ
        if(answer.equals("")) {
        	answer = "a";
        }
       
        // 6�ܰ� 15�ڸ� �ʰ� ���� ����
        if(answer.length() >= 16) {
        	answer = answer.substring(0, 15);
        	
        	if(answer.charAt(answer.length()-1) == '.') {
        		answer = answer.substring(0, answer.length()-1);
        	}
        }
       
        // 7�ܰ� 2�ڸ� ���϶�� ������ ���ڸ� ��� �ٿ� 3�ڸ��� �����
        StringBuilder tempAnswer7 = new StringBuilder(answer);
        if(tempAnswer7.length() <=2) {
        	char last = tempAnswer7.charAt(tempAnswer7.length() -1);
        	
        	while(tempAnswer7.length() < 3) {
        		tempAnswer7.append(last);
        	}
        }
        answer = String.valueOf(tempAnswer7);
       
        return answer;
    }
}
