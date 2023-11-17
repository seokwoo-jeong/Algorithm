package codingtest.ssg202205;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ssg2 {
	static ArrayList<Student> studentArray;
	public String[] solution(String[] logs) {
		String[] answer = {};
		studentArray = new ArrayList<>();
		for(int i = 0; i<logs.length; i++) {
			String[] def = logs[i].split(" ");
			insertArray(def);
		}
		
		answer = findCheating();
//		for(int i = 0; i<answer.length; i++) {
//			System.out.print(answer[i] + "   ");
//		}
		return answer;
	}
	
	
	private String[] findCheating() {
		ArrayList<String> cheatingName = new ArrayList<>();
		
		for(int i = 0; i<studentArray.size(); i++) {
			Collections.sort(studentArray.get(i).questionArray);
		}
		
		for(int i = 0; i<studentArray.size()-1; i++) {
			ArrayList<Question> standardQuestionArray = studentArray.get(i).questionArray;
			for(int j = i+1; j<studentArray.size(); j++) {
				ArrayList<Question> questionArray = studentArray.get(j).questionArray;
				if(compareScore(standardQuestionArray, questionArray)) {//비교해서 치팅한 놈들이면
					if(!cheatingName.contains(studentArray.get(i).name)) {//결과 array에 이름 없으면 insert
						cheatingName.add(studentArray.get(i).name);
					}
					cheatingName.add(studentArray.get(j).name);//뒷놈은 무조건 처음 넣는 놈이니깐 결과에 이름 insert
					break;
				}
			}
		}
		
		String[] answer = new String[cheatingName.size()];
		for(int i = 0; i<cheatingName.size(); i++) {
			answer[i] = cheatingName.get(i);
		}
		Arrays.sort(answer);
		return answer;
	}
	
	private boolean compareScore(ArrayList<Question> standardQuestionArray, ArrayList<Question> questionArray) {
		boolean flag = false;
		int count = 0;
		for(int i = 0; i<standardQuestionArray.size(); i++) {
			for(int j = 0; j < questionArray.size(); j++) {
				if(standardQuestionArray.get(i).number.equals(questionArray.get(j).number)) {
					if(standardQuestionArray.get(i).score.equals(questionArray.get(j).score)) {
						count++;
					}
				}
			}
		}
		if(count >= 5) {
			flag = true;
		}
		return flag;
	}

	public void insertArray(String[] stringInfo) {	//처음
		if(studentArray.isEmpty() || !isExistStudent(stringInfo)) {	//학생 array가 비어있으면 학생 array에 insert
			insertStudent(stringInfo);
		}
	}
	
	public boolean isExistStudent(String[] stringInfo) {//학생 array에있는지 없는지
		String name = stringInfo[0];
		String number = stringInfo[1];
		String score = stringInfo[2];
		boolean flag = false;
		for(Student student: studentArray) {
			if(student.name.equals(name)) {//학생이 array에 이미 있는 경우
				Student currentStudent = student;
				
				if(!currentStudent.isExistNumber(number, score)) {	//학생이 이미 푼 문제가 아닌경우
					currentStudent.addInfo(number, score,-1);
				}
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public class Student{
		String name;
		ArrayList<Question> questionArray;
		Question question;
		
		public Student(String name) {
			this.name = name;		
			questionArray = new ArrayList<Question>();
		}
		
		public void addInfo(String number, String score, int index) {//문제번호와 점수 insert
			question = new Question();
			question.number = number;
			question.score = score;
			if(index == -1) {
				questionArray.add(question);	//해당 문제 한번도 안 푼 경우
			}else {
				questionArray.set(index, question);	//동일 문제 풀었는데, 더 높은 점수 들어온 경우 점수 change
			}
			
		}
		
		public boolean isExistNumber(String number, String score) {//푼 문제인지 아닌지 chk
			boolean flag = false;
			for(int i = 0; i<questionArray.size(); i++) {
				if(questionArray.get(i).number.equals(number)) {	//이미 푼 문제인 경우
					if(Integer.parseInt(questionArray.get(i).score) < Integer.parseInt(score)) {//현재 점수가 과거 점수보다 높은경우
						flag = true;
						addInfo(number,score,i);
						break;
					}
				}
			}
			return flag;
		}
	}
	
	
	public void insertStudent(String[] stringInfo) {
		String name = stringInfo[0];
		String number = stringInfo[1];
		String score = stringInfo[2];
		
		Student student = new Student(name);
		student.addInfo(number, score, -1);
		studentArray.add(student);		
	}
	
	public class Question implements Comparable<Question>{
		String number;
		String score;

		public Question(){
			this.number = null;
			this.score = null;
		}

		@Override
		public int compareTo(Question question) {
			if(Integer.parseInt(this.number) < Integer.parseInt(question.number)) {
				return -1;
			}else {
				return 1;
			}
		}
	}

}
