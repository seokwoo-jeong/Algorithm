package backjon.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// https://www.acmicpc.net/problem/2290
// LCD Test
public class Implement9 {
	static String[][] matrix;
	static int s;
	static int totalHeight;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] def = br.readLine().split(" ");
		
		s = Integer.parseInt(def[0]);
		char[] numArray = def[1].toCharArray();
		int numSize = numArray.length;
		int totalWidth = (s+2)*numSize + numSize-1;	//각숫자사이즈 + 공백개수
		totalHeight =  2*s + 3;	//숫자 세로 사이즈
		matrix = new String[totalHeight][totalWidth];
		
		for(int i = 0; i<numSize; i++) {
			drawNum(i, numArray[i]);
		}
		for(int i = 0; i<totalHeight; i++) {
			for(int j= 0; j<totalWidth; j++) {
				if(matrix[i][j] == null) {
					matrix[i][j] = " ";
				}
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
	}
	
	private static void drawWidth(int currentWidth, int currentHeight) {
		for(int i = 1; i<s+1; i++) {
			matrix[currentHeight][currentWidth+i] = "-";
		}
	}
	private static void drawHeight(int currentWidth, int currentHeight) {
		for(int i = 1; i<s+1; i++) {
			matrix[currentHeight+i][currentWidth] = "|";
		}
		
	}
	
	private static void drawNum(int index, char num) {
		int widthIndex = ((s+2)+1)*index;
		int halfHeight = totalHeight /2;
		switch(num) {
		case '0':
			drawWidth(widthIndex,0);
			drawHeight(widthIndex,0);
			drawHeight(widthIndex+s+1,0);
			drawHeight(widthIndex,halfHeight);
			drawHeight(widthIndex+s+1,halfHeight);
			drawWidth(widthIndex,totalHeight-1);
			break;
		case '1':
			drawHeight(widthIndex+s+1,0);
			drawHeight(widthIndex+s+1,0);
			drawHeight(widthIndex+s+1,halfHeight);
			break;
		case '2':
			drawWidth(widthIndex,0);
			drawHeight(widthIndex+s+1,0);
			drawWidth(widthIndex,halfHeight);
			drawHeight(widthIndex,halfHeight);
			drawWidth(widthIndex,totalHeight-1);
			break;
		case '3':
			drawWidth(widthIndex,0);
			drawHeight(widthIndex+s+1,0);
			drawWidth(widthIndex,halfHeight);
			drawHeight(widthIndex+s+1,halfHeight);
			drawWidth(widthIndex,totalHeight-1);
			break;
		case '4':
			drawHeight(widthIndex,0);				//뚜껑왼쪽
			drawHeight(widthIndex+s+1,0);				//뚜껑오른쪽
			drawWidth(widthIndex,halfHeight); 		//가운데
			drawHeight(widthIndex+s+1,halfHeight);	//가운데오른쪽
			break;
		case '5':
			drawWidth(widthIndex,0);				//뚜껑
			drawHeight(widthIndex,0);				//뚜껑왼쪽
			drawWidth(widthIndex,halfHeight); 		//가운데
			drawHeight(widthIndex+s+1,halfHeight);	//가운데오른쪽
			drawWidth(widthIndex,totalHeight-1);	//맨밑
			break;
		case '6':
			drawWidth(widthIndex,0);				//뚜껑
			drawHeight(widthIndex,0);				//뚜껑왼쪽
			drawWidth(widthIndex,halfHeight); 		//가운데
			drawHeight(widthIndex,halfHeight);		//가운데왼쪽
			drawHeight(widthIndex+s+1,halfHeight);	//가운데오른쪽
			drawWidth(widthIndex,totalHeight-1);	//맨밑
			break;
		case '7':
			drawWidth(widthIndex,0);				//뚜껑
			drawHeight(widthIndex+s+1,0);				//뚜껑오른쪽
			drawHeight(widthIndex+s+1,halfHeight);	//가운데오른쪽
			break;
		case '8':
			drawWidth(widthIndex,0);				//뚜껑
			drawHeight(widthIndex,0);				//뚜껑왼쪽
			drawHeight(widthIndex+s+1,0);				//뚜껑오른쪽
			drawWidth(widthIndex,halfHeight); 		//가운데
			drawHeight(widthIndex,halfHeight);		//가운데왼쪽
			drawHeight(widthIndex+s+1,halfHeight);	//가운데오른쪽
			drawWidth(widthIndex,totalHeight-1);	//맨밑
			break;
		case '9':
			drawWidth(widthIndex,0);				//뚜껑
			drawHeight(widthIndex,0);				//뚜껑왼쪽
			drawHeight(widthIndex+s+1,0);				//뚜껑오른쪽
			drawWidth(widthIndex,halfHeight); 		//가운데
			drawHeight(widthIndex+s+1,halfHeight);	//가운데오른쪽
			drawWidth(widthIndex,totalHeight-1);	//맨밑
			break;
		}
		
	}


}
