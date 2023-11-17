package programmer.programmerLv2;

import java.util.LinkedList;
import java.util.Queue;
// https://programmers.co.kr/learn/courses/30/lessons/1829
// īī�� ������ �÷�����

public class Kakao1 {
	public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();
        int[][] visited = new int[m][n];
        
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                visited[i][j] = 0;
            } 
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if ((picture[i][j] !=0)&&(visited[i][j]==0)){
                	numberOfArea ++;
                    qx.add(i);
                    qy.add(j);
                    visited[i][j] = 1;
                    int miniCount = 1;
           
                    while (!qx.isEmpty()){
                        int x = qx.poll();
                        int y = qy.poll();
                        
                        for (int k =0; k<4; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if ((0<=nx)&&(nx<m) && (0<=ny)&&(ny<n)){
                                if ((visited[nx][ny] == 0) && (picture[nx][ny]==picture[x][y])){
                                    qx.add(nx);
                                    qy.add(ny);
                                    visited[nx][ny] = 1;
                                    miniCount ++;
                                }
                            }
                        }
                        
                    }
                    if (maxSizeOfOneArea < miniCount){
                    	maxSizeOfOneArea = miniCount;   	
                }
                }
            }
        }
       
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

}
