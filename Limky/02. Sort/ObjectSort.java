package EscapeStudy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ObjectSort {

	public static void main(String[] args) {
		/*
		 * 문제5. Java를 이용하여 문제를 해결하시오. 신한데이타시스템 11기 7명은 첫 월급을 기념하기 위해 배를타고 미국여행을
		 * 가기로 하였다. 하지만 여행도중 예기치 않은 폭풍우를 만나 배가 전복될 위기에 처했다. 아래의 우선순위에 알맞게 11기
		 * 동기들을 탈출 시키자! 
		 * 
		 * 우선순위 1. 이직동아리를 최우선으로 구출하라 
		 * 우선순위 2. 남자보다 여자를 먼저 구출하라 
		 * 우선순위 3. 나이가 어린 사람을 먼저 구출하라 
		 * 우선순위 4. 모든 경우가 같다면 이름순으로 구출하라 
		 * 우선순위는 1>2>3>4 순이며 각 우선순위에서의 순위가 같다면 다음 우선순위를 적용하여 구출하라. 
		 * 입력의 가장 첫줄은 총 인원이 들어가며 다음 줄부터 각 인원의 정보가 입력된다. 
		 * 
		 * 입력 예시) 7 27 이정수 남 Y 29 김지민 남 N 28 권완빈 남 Y 28 설인호 남 Y 27 최한아 여 N 26 성연진 여 N 29 이종민 남 N
		 * 출력 예시) 이정수 권완빈 설인호 성연진 최한아 김지민 이종민 컬렉션은 이용해도 무방하나 Comparator는 사용 금지
		 */
		/*
		 * Limky Solution
		 * 동아리 : 50점 / 이름 : 첫글자 / 여자 : 30 / 나이 : 100-나이
			27 이정수 남 Y   73 + ㅇ + 0 + 50 = 123 ㅇ
			29 김지민 남 N   71 + ㄱ + 0 + 0  = 71   ㄱ
			28 권완빈 남 Y   72 + ㄱ + 0 + 50 = 122 ㄱ
			28 설인호 남 Y   72 + ㅅ + 0 + 50 = 122 ㅅ 
			27 최한아 여 N   73 + ㅊ + 30 + 0 = 103 ㅊ
			26 성연진 여 N   74 + ㅅ + 30 + 0 = 104 ㅅ
			29 이종민 남 N   71 + ㅇ + 0 + 0  = 71   ㅇ

		 */
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Person> list = new ArrayList<>();
		
		for(int i=0; i<n; i++){
			Person p = new Person();
			p.setAge(sc.nextInt());
			p.setName(sc.next());
			p.setGender(sc.next());
			p.setStudy(sc.next());
			list.add(p);
		}
		
//			printList(list);

		
		solution(list);

	}

	//동아리 : 50점 / 이름 : 첫글자 / 여자 : 30 / 나이 : 100-나이
	private static void solution(ArrayList<Person> list) {
		
		//int score[] = new int[list.size()];
		//동아리 : 500점
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getStudy().equals("Y")){
				list.get(i).setScore(list.get(i).getScore()+50);
			}
		}
		//여자 : 30
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getGender().equals("여")){
				list.get(i).setScore(list.get(i).getScore()+30);
			}
		}
		//나이 : 100-나이
		for(int i=0; i<list.size(); i++){
			list.get(i).setScore(list.get(i).getScore()+(100-(list.get(i).getAge()*2)));
		}
	
		//이름 순
		for(int i=0; i<list.size(); i++){
			String str = list.get(i).getName();
			for(int j=0; j<list.size();j++){
				if(j!=i && list.get(i).getScore() == list.get(j).getScore()){
					if(1 > str.compareTo(list.get(j).getName())){
						//음수 str이 사전상 먼저
						list.get(i).setScore(list.get(i).getScore()+1);
					}
				}
			}
		}
		
		//printList(list);
		
		//Score 합산 결과 출력
		Person p;
		int index = 0;
		while(!list.isEmpty()){
			index = 0;
			for(int j=0; j<list.size(); j++){
				if(list.get(index).getScore() < list.get(j).getScore()){
					index = j;
				}
			}
			System.out.print(list.get(index).getName()+" ");
			list.remove(index);
		}


		
	
	}

//	private static void printList(ArrayList<Person> list) {
//		for(Person p : list){
//			System.out.println(p.toString());
//		}
		
//	}

}

class Person {
	private String name;
	private int age;
	private String gender;
	private String study;
	private int score;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStudy() {
		return study;
	}

	public void setStudy(String study) {
		this.study = study;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", study=" + study + ", score=" + score
				+ "]";
	}



}
