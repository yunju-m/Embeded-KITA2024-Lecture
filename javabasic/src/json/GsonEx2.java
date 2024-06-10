package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonEx2 {

	public static void main(String[] args) {
		
		// 1. Person 객체를 Json 문자열로 변환 후 출력
		Person person1 = new Person("손흥민", 30);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String personStr = gson.toJson(person1);
		System.out.println(personStr);
		
		// 2. Json 문자열을 Person 객체로 변환 후 출력
		Person person2 = gson.fromJson(personStr, Person.class);
		System.out.println(person2);
		
		// 3. Map 객체를 Json 문자열로 변환 후 출력
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("국어", 100);
		map.put("영어", 90);
		map.put("수학", 80);
		String mapStr = gson.toJson(map);
		System.out.println(mapStr);
		
		// 4. Json 문자열을 Map 객체로 변환 후 출력
		Map<String, Integer> map2 = gson.fromJson(mapStr, Map.class);
		System.out.println(map2);
		
		// 5. List 객체를 Json 문자열로 변환 후 출력
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("이대호", 30));
		personList.add(new Person("이승엽", 40));
		personList.add(new Person("선동열", 50));
		String personListStr = gson.toJson(personList);
		System.out.println(personListStr);
		
		// 6. Json 문자열을 List 객체로 변환 후 출력
		List<Person> personList2 = gson.fromJson(personListStr, List.class);
		System.out.println(personList2);
	}
}
