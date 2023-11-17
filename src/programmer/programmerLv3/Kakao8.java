package programmer.programmerLv3;
import java.util.*;

public class Kakao8 {
	Stack<Integer> stack;
	StringBuilder sb;
	//"D 2","C","U 3","C","D 4","C","U 2","Z","Z"
	public String solution(int n, int k, String[] cmd) {
		this.stack = new Stack<>();
		this.sb = setStringBuilder(n);
		
		int curIndex = k;
		int curSize = n;
		for (int i = 0; i < cmd.length; i++) {
			
			String[] pick = cmd[i].split(" ");

			switch (pick[0]) {
			case "U":
				curIndex = curIndex - Integer.parseInt(pick[1]);
				break;
			case "D":
				curIndex = curIndex + Integer.parseInt(pick[1]);
				break;
			case "C":
				this.sb.setCharAt(curIndex, 'X');
				this.stack.add(curIndex);
				curSize--;
				if(curSize == curIndex) {
					curIndex--;
				}
				break;
			case "Z":
                int restore = this.stack.pop();
                
                if(restore <= curIndex){
                    curIndex++;
                }
                this.sb.setCharAt(restore, 'O');
				
				break;
			}

		}
		return sb.toString();
	}
	private StringBuilder setStringBuilder(int size) {
		StringBuilder temp = new StringBuilder(size);
		for(int i = 0; i<size; i++) {
			temp.append('O');
		}
		return temp;
	}

}