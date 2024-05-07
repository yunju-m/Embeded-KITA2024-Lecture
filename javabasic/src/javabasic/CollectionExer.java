// Collection 실습
// 3개의 반에 각각 3명의 국어, 영어, 수학 점수가 있다.
// 반별 각 학생의 국영수 총점을 산출해 반,이름,총점을 출력하는 프로그램을 만들어본다.

package javabasic;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CollectionExer {

	public static void main(String[] args) {

		Student st11 = new Student(1, 1,"홍길동", 90, 80, 70);
		Student st12 = new Student(1, 2, "강감찬", 80, 70, 60);
		Student st13 = new Student(1, 3, "유관순", 100, 95, 85);
		Student st21 = new Student(2, 1, "이슬이", 100, 80, 70);
		Student st22 = new Student(2, 2, "퉁퉁이", 80, 70, 50);
		Student st23 = new Student(2, 3, "노진구", 90, 95, 45);
		Student st31 = new Student(3, 1, "짱구", 90, 90, 70);
		Student st32 = new Student(3, 2, "맹구", 80, 80, 60);
		Student st33 = new Student(3, 3, "철수", 100, 55, 65);
		
		// Map<String, Student> stMap = new LinkedHashMap<String, Student>();
		Map<String, Student> stMap = new HashMap<String, Student>();
		stMap.put("st11", st11);
		stMap.put("st12", st12);
		stMap.put("st13", st13);
		stMap.put("st21", st21);
		stMap.put("st22", st22);
		stMap.put("st23", st23);
		stMap.put("st31", st31);
		stMap.put("st32", st32);
		stMap.put("st33", st33);

		Collection<Student> coll = stMap.values();
		coll.forEach(student -> System.out.println(student));

	}

}
