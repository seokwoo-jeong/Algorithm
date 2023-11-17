package codingtest.sk220312;

/*
 * n=5
 * clockwise = true
 * result = {{1,2,3,4,1},
 *           {4,5,6,5,2},
 *           {3,6,7,6,3},
 *           {2,5,6,5,4},
 *           {1,4,3,2,1}}
 * 
 * n=6
 * clockwise = false
 * result = {{1,5,4,3,2,1},{2,6,8,7,6,5},{3,7,9,9,8,4},{4,8,9,9,7,3},{5,6,7,8,6,2},{1,2,3,4,5,1}}
 * 
 */

public class SK2 {
	public int[][] solution(int n, boolean clockwise) {
		int[][] clockWise;
		int[][] clockWises = {{0,1},{1,0},{0,-1},{-1,0}};
		int[][] counterClockWises = {{1,0},{0,1},{-1,0},{0,-1}};
		if(clockwise) {	//�ð���� or �ݽð� ����
			clockWise = clockWises;
		}else {
			clockWise = counterClockWises;
		}
		
		int endPoint = n-1;
		int[][] result = new int[n][n];
		int[] startPoint = {0,0};
		int count = n/2;	//����� ��� ����
		int num = 1;
		int tempNum = 0;
		for (int i = 1; i<= count; i++) { //����� ��� ����
			for(int z = 0; z<4; z++) {	//����� �ϳ��� 4�� ���ƾ� ��
				tempNum = num; // �� ����⿡ ������ ������ ������
				for (int k = 1; k<=endPoint; k++) {		//�� ������� �� �ҿ뵹�̰� ��� ���ƾ� �ϴ���
					result[startPoint[0]][startPoint[1]] = tempNum;
					startPoint[0] += clockWise[z][0];
					startPoint[1] += clockWise[z][1];
					tempNum ++;
				}
				
				
			}
			endPoint -=2;	//�� ����� �� ���� ���� �� �ٲ� ��
			num = tempNum;
			startPoint[0] ++;
			startPoint[1] ++;
		}
		
		if(n%2 != 0) {		//Ȧ���� ��� �߾Ӱ� �߰�
			result[count][count] = num;
		}
		/*
		for(int i = 0; i<n; i++) {
			for(int z = 0; z<n; z++) {
				System.out.print(result[i][z] + " ");
			}
			System.out.println("");
		}
		*/
		return result;
	}
}
