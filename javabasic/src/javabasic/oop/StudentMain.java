package javabasic.oop;

public class StudentMain {

	public static void main(String[] args) {

		// Student타입 객체 3개 생성
		Student std1 = new Student();
		Student.objCount++;
		Student std2 = new Student();
		Student.objCount++;
		Student std3 = new Student();
		Student.objCount++;
		
		// 객체 데이터 설정
		std1.name = "퉁퉁이";
		std1.age = 13;
		std1.phoneNumber = "010-1234-5678";
		
		std2.name = "이슬이";
		std2.age = 17;
		std2.phoneNumber = "010-9876-5432";
		
		std3.name = "노진구";
		std3.age = 15;
		std3.phoneNumber = "010-1111-1111";
		
		// 객체 데이터 출력
		System.out.println(std1.name + "님은 " + std1.age + "세이고, 전화번호는 " + std1.phoneNumber);
		System.out.println(std2.name + "님은 " + std2.age + "세이고, 전화번호는 " + std2.phoneNumber);
		System.out.println(std3.name + "님은 " + std3.age + "세이고, 전화번호는 " + std3.phoneNumber);
		
		// 객체 메서드 호출
		std1.study();
		std2.sleep();
		std3.exercise();
		std3.call();
		
		// 생성된 객체 수
		System.out.println("총 " + Student.objCount + "개의 객체 생성!!");
		System.out.println("총 " + Student.getObjCount() + "개의 객체 생성!!");
		
	} // main

} // class