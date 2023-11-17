package programmer.mockexam1;

import java.util.*;
public class Solution4 {
    int answer;
    public boolean[] isVisit;
    public int solution(int[][] beginning, int[][] target) {
        answer = 0;
        isVisit = new boolean[beginning.length*2];
        bruteForce(beginning, target, 0);
        return answer;
    }

    public void bruteForce(int[][] current, int[][] target, int count){
        Queue<Info> queue = new LinkedList<>();

        Info info = new Info(current,count);
        queue.add(info);

        while(!queue.isEmpty()){
            Info nowInfo = queue.poll();

            if(isSame(nowInfo.matrix, target)){
                answer = nowInfo.count;
                break;
            }
            if(nowInfo.count > current.length*2){
                answer = -1;
                break;
            }


            for(int i = 0; i<current.length * 2; i++){
                if(!isVisit[i]){
                    isVisit[i] = true;
                    queue.add(new Info(reverseCurrent(nowInfo.matrix,i), nowInfo.count+1));
                    isVisit[i] = false;
                }
            }
        }


    }
    public class Info{
        int[][] matrix;
        int count;
        public Info(int[][] matrix, int count){
            this.matrix = matrix;
            this.count = count;
        }
    }

    public int[][] reverseCurrent(int[][] current, int index){
        int[][] temp = new int[current.length][current[0].length];
        for(int i = 0; i< current.length; i++){
            for(int j = 0; j<current[0].length; j++){
                temp[i][j] = current[i][j];
            }
        }

        if(index >= current.length){
            index = index - current.length;
            for(int i = 0; i<current.length; i++){
                if(current[index][i] == 0){
                    temp[index][i] = 1;
                }else{
                    temp[index][i] = 0;
                }
            }
            return temp;
        }
        for(int i = 0; i<current.length; i++){
            if(temp[i][index] == 0){
                temp[i][index] = 1;
            }else{
                temp[i][index] = 0;
            }
        }

        return temp;
    }

    public boolean isSame(int[][] current, int[][] target){
        for(int i = 0; i<current.length; i++){
            for(int j = 0; j<current[0].length; j++){
                if(current[i][j] != target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
