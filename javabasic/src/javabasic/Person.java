package javabasic;

public class Person {

	String name;
	int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	// Object클래스의 equals를 오버라이딩하여 name, age를 기준으로 비교
	// Object.eqauls : 참조값을 대상으로 비교
	@Override
	public boolean equals(Object obj) {
		Person p = (Person)obj;
		return this.name.equals(p.name) && this.age == p.age;
	}

	@Override
	public String toString() {
		return this.name + "님은 " + this.age + "살 입니다!";
	}
	
}
