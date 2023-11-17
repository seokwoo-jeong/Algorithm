package codingtest.summerCodingTest220508;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* 동일한 방에는 한 사람을 기준으로 여러개의 지정좌석x
 * 1.해당 방에 이미 지정 자리가 있는 직원은 제외합니다.
   2.지정 자리가 제일 적은 직원의 우선순위가 가장 높습니다.
   3.지정 자리의 개수가 동일한 사람들끼리는 새 자리가 생긴 방에서 가장 가까운 방에 지정 자리가 있는 직원이 우선순위가 더 높습니다.
   4.한 사람의 지정 자리가 여러 개인 경우, 지정 자리가 있는 방 중에서 새 자리가 생긴 방과 가장 가까운 방을 기준으로 선정합니다.
   5.방과 방 사이의 거리는 두 방의 호수 차이의 절댓값으로 정의합니다.
   예를 들어 303호와 405호의 거리는 |303 - 405| = 102입니다.
   6.지정 자리 수와 새 자리가 생긴 방까지의 거리도 동일한 경우, 
   7.이름이 사전 순으로 빠른 사람이 더 높은 우선순위를 갖습니다. 단 사전 순은 대문자가 소문자 보다 사전 순으로 앞섭니다. 
   예를 들어, A~Z, a~z까지 알파벳을 사전 순으로 정렬한 결과는 [A, B, ... Z, a, b, ... , z]입니다
   String[] a = {"[403]James", "[404]Azad,Louis,Andy", "[101]Azad,Guard"};
   int target = 403;
 */
public class SummerCoding2 {
	ArrayList<Person> personArray;
	int targetRoomNo;
	String[] answer;
	public  String[] solution (String[] rooms, int target) {
		this.targetRoomNo = target;
		this.personArray = new ArrayList<>();
		for(int i = 0; i<rooms.length; i++) {
			String[] def = rooms[i].split("]");
			String roomNo = def[0].replace("[","");
			String[] nameArray = def[1].split(",");
			insertPersonArray(nameArray,roomNo);
		}
		Collections.sort(this.personArray);

		answer = new String[this.personArray.size()];
		for(int i = 0; i<this.personArray.size(); i++) {
			answer[i] = this.personArray.get(i).name;
		//	System.out.println(answer[i]);
		}
		
		
		return answer;
	}

	private void insertPersonArray(String[] nameArray,String roomNo) {
		if(targetRoomNo == Integer.parseInt(roomNo)) {
			return;
		}
		
		if(personArray.isEmpty()) {
			for(String name: nameArray) {
				createPerson(name,roomNo);
			}
		}else {
			int size = personArray.size();
			for(int i = 0; i<nameArray.length; i++) {
				insertPerson(nameArray[i],size,roomNo);
				
			}
		}
	}
	private void createPerson(String name, String roomNo) {
		Person person = new Person(name);
		person.addRoom(roomNo);
		personArray.add(person);
	}
	
	private void insertPerson(String name, int size, String roomNo) {
		boolean flag = false;
		for(int i = 0; i<size; i++) {
			if(this.personArray.get(i).name.equals(name)) {
				flag = true;
				this.personArray.get(i).addRoom(roomNo);
				break;	
			}
		}
		if(!flag) {
			createPerson(name, roomNo);
		}
		
	}

	public class Person implements Comparable<Person>{
		String name;
		ArrayList<String> roomNoArray;
		public Person(String name) {
			this.name = name;
			this.roomNoArray = new ArrayList<>();
		}
		
		public void addRoom(String roomNo) {
			this.roomNoArray.add(roomNo);
		}

		@Override
		public int compareTo(Person o) {
			int temp = 0;
			if(this.roomNoArray.size() < o.roomNoArray.size()) {		//방번호 적은놈들
				temp =  -1;
			}else if(this.roomNoArray.size() > o.roomNoArray.size()) {
				temp =  1;
			}else {	//방번호 같으면 인접한 방번호 비교해서 정렬
				int absRoomNo1 = 999;
				int absRoomNo2 = 999;
				for(int i = 0; i<this.roomNoArray.size(); i++) {
					absRoomNo1 = Math.min(absRoomNo1,Math.abs(Integer.parseInt(this.roomNoArray.get(i)) - targetRoomNo));
				}
				for(int i = 0; i<o.roomNoArray.size(); i++) {
					absRoomNo2 = Math.min(absRoomNo2,Math.abs(Integer.parseInt(o.roomNoArray.get(i)) - targetRoomNo));
				}
				if(absRoomNo1 < absRoomNo2) {//절대값 최고값끼리 비교
					temp = -1;
				}else if(absRoomNo1 > absRoomNo2) {//절대값 끼리 비고
					temp = 1;
				}else {	
					temp = this.name.compareTo(o.name);	//인접한 방번호 같으면 이름순으로 정렬해라
				}
			}
			return temp;
		}
	}
}

