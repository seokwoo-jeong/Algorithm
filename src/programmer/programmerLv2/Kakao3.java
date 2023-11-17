package programmer.programmerLv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/17686
// [3��] ���ϸ� ����

/*
 * 	�Է�: ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
 *  ���: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
 *
 *	�Է�: ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]
 *	���: ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
 */


class File{
	public String head;
	public int num;
	public String originFileName;
	
	public File(String fileName) {
		this.originFileName = fileName;
		int finishHeadIndex = getFinishHeadIndex();
		int finishNumIndex = getFinishNumIndex(finishHeadIndex);

		this.head = this.originFileName.substring(0,finishHeadIndex).toLowerCase();
		
		if(finishHeadIndex == finishNumIndex) {
			this.num = Character.getNumericValue(this.originFileName.toCharArray()[finishHeadIndex]);
		}else {
			this.num = Integer.parseInt(this.originFileName.substring(finishHeadIndex, finishNumIndex+1));
		}
	}
	
	public int getFinishHeadIndex() {
		char[] originFileName = this.originFileName.toCharArray();
		int finishHeadIndex = 0;
		
		for(int i = 0; i<originFileName.length; i++) {
			if(originFileName[i] >=48 && originFileName[i] <= 57) {	
				finishHeadIndex = i;
				break;
			}
		}
		return finishHeadIndex;
	}
	
	public int getFinishNumIndex(int finishHeadIndex) {
		char[] originFileName = this.originFileName.toCharArray();
		int finishNumIndex = 0;
		for(int i = finishHeadIndex; i<originFileName.length; i++) {
			if(originFileName[i] >=48 && originFileName[i] <= 57) {	
				finishNumIndex = i;
			}else {
				break;
			}
		}
		return finishNumIndex;
	}

}

public class Kakao3 {

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> fileArr = new ArrayList<>();
        
        for(String fileNm: files) {
        	fileArr.add(new File(fileNm));
        }
        
        
        fileArr.sort(new Comparator<File>() {	//model class type ������ ���� comparator ����
			@Override
			public int compare(File o1, File o2) {
				int compare = o1.head.compareTo(o2.head);
				if(compare != 0 ) {
					return compare;
				}
				if(o1.num > o2.num) {
					return 1;
				}else if(o1.num < o2.num) {
					return -1;
				}
				
				return compare;
			}
        	
        });
        
        for (int i = 0; i<files.length; i++) {
        	answer[i] = fileArr.get(i).originFileName;
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
}