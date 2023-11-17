package backjon.bfs2;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/16948
//데스 나이트

public class BFS2 {
    static int[][] matrix;
    static boolean[][] isVisit;
    static int[] dx = {-2,-2,0,0,2,2};
    static int[] dy = {-1,1,-2,2,-1,1};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        isVisit = new boolean[n][n];

        String[] def = br.readLine().split(" ");
        int startX = Integer.parseInt(def[0]);
        int startY = Integer.parseInt(def[1]);
        int finishX = Integer.parseInt(def[2]);
        int finishY = Integer.parseInt(def[3]);

        bfs(startX, startY);

        if(matrix[finishX][finishY] == 0) {
        	System.out.println(-1);
        }else {
        	System.out.println(matrix[finishX][finishY]);
        }
        
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            int currentX = xy[0];
            int currentY = xy[1];

            for(int i = 0; i<dx.length; i++){
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];
                if(isContains(newX,newY)){
                    if(!isVisit[newX][newY] || matrix[currentX][currentY] + 1 < matrix[newX][newY]){
                        matrix[newX][newY] = matrix[currentX][currentY] + 1;
                        isVisit[newX][newY] = true;
                        queue.add(new int[] {newX,newY});
                    }
                }
            }
        }
    }

    public static boolean isContains(int x, int y){
        boolean flag = false;
        if(0<=x && x < n && 0<=y && y<n){
            flag = true;
        }
        return flag;
    }
}
