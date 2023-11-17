package programmer.programmerLv3;
import java.util.*;
// https://school.programmers.co.kr/learn/courses/30/lessons/72413
// 합승 택시 요금


/* 
 * int n = 6;		지점 개수
 * int s = 4;		출발지점
 * int a = 6;		도착지점a
 * int b = 2;		도착지점b
 * {4, 1, 10}, 
 * {3, 5, 24}, 
 * {5, 6, 2}, 
 * {3, 1, 41}, 
 * {5, 1, 24}, 
 * {4, 6, 50}, 
 * {2, 4, 66}, 
 * {2, 3, 22}, 
 * {1, 6, 25};
 */

//다익스트라 알고리즘을 이용한 문제 풀이(어려움...)
public class Kakao5 {
	private static int INF = 20000001;
	int[][] graph;
	int n;
	public int solution(int n, int s, int a, int b, int[][] fares) {
		this.graph = new int[n][n];
		
		this.n = n;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(i == j) {
					this.graph[i][j] = 0;
				}else {
					this.graph[i][j] = INF;
				}
				
			}
		}
		for(int i = 0; i<fares.length; i++) {	
			graph[fares[i][0]-1][fares[i][1]-1] = graph[fares[i][1]-1][fares[i][0]-1] = fares[i][2];
		}
		
		int[] dis1 = dijkstra(s-1);
		int[] dis2 = dijkstra(a-1);
		int[] dis3 = dijkstra(b-1);
		
		int answer = Integer.MAX_VALUE;
		for(int i = 0; i<n; i++) { //(s -> k) +  (k -> a) + (k-> b)의 최소값
			answer = Math.min(answer, dis1[i]+dis2[i]+dis3[i]);
		}
		
		//System.out.println(answer);
		
		
		return answer;
	}

	private int[] dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] isVisit = new boolean[n];
		int[] distance = new int[n];
		for(int i = 0; i<n; i++) {
			distance[i] = INF;
		}
		distance[start] = 0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			
			for(int i = 0; i<n; i++) {
				if(!isVisit[i] && cur.weight + graph[cur.index][i]<distance[i]) {
					distance[i] = cur.weight + graph[cur.index][i];
					pq.add(new Node(i, distance[i]));
				}
			}
			isVisit[cur.index] = true;
		}
		return distance;
	}
	private class Node implements Comparable<Node>{
		int index;
		int weight;
		
		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
			
		}
		
		@Override
		public int compareTo(Node node) {
			return this.weight - node.weight;
		}
	}
}