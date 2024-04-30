package javabasic.oop;

public class Student {

	static int objCount = 0;	// static은 초기화 해주는 것이 좋다.

	String name;		// 이름 (""으로 초기화)
	int age;			// 나이 (0으로 초기화)
	String phoneNumber;	// 전화번호 (""으로 초기화)

	static int getObjCount() {
		return objCount;
	}

	void study() {
		System.out.println(this.name + "님이 공부한다.");
	}

	void exercise() {
		System.out.println(this.name + "님이 운동한다.");
	}

	void sleep() {
		System.out.println(this.name + "님이 잠을잔다.");
	}

	void call() {
		System.out.println(this.name + "님이 전화한다.");
	}

}
