package javabasic.oop;

class Human {

	private String name;
	private int age;

	Human(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// getter (get + 변수명대문자시작)
	public String getName() {
		return name;
	}

	// setter (set + 변수명대문자시작)
	public void setName(String name) {
		this.name = name;
	}

	// age getter/setter 생성
	public int getAge() {
		return age + 15;
	}

	public void setAge(int age) {
		this.age = age;
	}

}