package programmer.mockexam1;

import java.util.*;
public class Solution3 {
    public int solution(int[] order) {
        //4 3 1 2 5 순서 
        //1  2  3   보조
        //4 3 본체peek, 보조 peek
        //보조: 1,2
        //본체: 5
        //1못빼서 2 return
        int answer = 0;
        
        Stack<Integer> subCon = new Stack<>();
        int current = 1;    //현재 컨테이너에서 나오는 놈
        int index = 0;      //현재 필요한 놈의 index
        boolean flag = false;
        while(true){
            flag = false;
            if(index >= order.length){
                break;
            }
            if(current > order.length){
                if(!subCon.empty()){
                    if(subCon.peek() == order[index]){
                        index++;
                        answer++;
						subCon.pop();
						continue;
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }

            if(order[index] == current){
                answer++;
                index++;
                flag = true;
                current++;
            }else{
                if(!subCon.empty()){
                    if(subCon.peek() == order[index]){
                        subCon.pop();
                        answer++;
                        index++;
                        flag = true;
                    }
                }
            }
            if(!flag){
                subCon.push(current);
                 current++;
            } 
        }
        return answer;
    }
}