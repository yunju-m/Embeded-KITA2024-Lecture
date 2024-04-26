package javabasic;

import java.util.ArrayList;
import java.util.List;

public class Roof {

	public static void main(String[] args) {

		for (int i = 1; i < 11; i++) {
			System.out.println(i);
		}

		// 실습 1) 11부터 33까지 반복해서 출력
		for (int i = 11; i <= 33; i++) {
			System.out.println(i);
		}

		// 실습 2) 15부터 30까지 홀수만 출력
		for (int i = 15; i <= 30; i+=2) {
			System.out.println(i);
		}

		// 실습 3) 1부터 100까지 3의 배수만 출력
		for (int i = 3; i <= 100; i+=3) {
			System.out.println(i);
		}

		// 실습 4) 1부터 1000까지 정수 중에서 5나 7로 나누어 떨어지는 수 출력
		for (int i = 1; i <= 1000; i++) {
			if (i % 5 == 0 || i % 7 == 0) {
				System.out.println(i);
			}
		}

		// 실습 5) 1부터 1000까지 소수(1과 자기자신만으로만 나누어 떨어지는 수)만 출력
		// 1) 1일때는 1이 소수이므로 출력
		// 2) 1이 아닌 경우는 현재수부터 마지막수까지 나눠본다
		// 3) 나누어 떨어지는 수의 개수가 1개이면 소수 그렇지 않으면 소수가 아니다
		boolean dec;
		for (int i = 1; i <= 1000; i++) {
			dec = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					dec = false;
					break;
				}
			}
			if (dec) {
				System.out.println(i);
			}
		}

		// 메소드를 이용한 소수 알고리즘
		for (int i = 1; i < 1001; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}

		// enhanced for 
		int[] intArray = {10, 20, 30, 40};
		for (int i : intArray) {
			System.out.println(i);
		}
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}

		List<String> strList = new ArrayList<String>();
		strList.add("홍길동");
		strList.add("강감찬");
		strList.add("유관순");

		for (String str : strList) {
			System.out.println(str);
		}
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}

		int k = 10;
		while(k < 100) {
			System.out.println(k);
			k++;
		}

		int l = 1;
		while(l < 100) {
			if (l==50) break;
			l++;
			if (l%2==0) continue;
			System.out.println(l);
		}

		// 실습 1) while문을 사용하여 10부터 100까지의 정수 중에서 3의 배수만 출력
		int num = 10;
		while(num <= 100) {
			if (num % 3 == 0) System.out.println(num);
			num++;
		}

		// 실습 2) while문을 사용하여 10부터 100까지의 정수 중에서 3의 배수이지만 
		// 		  6의 배수는 아닌 수들만 출력
		int num2 = 10;
		while(num2 <= 100) {
			if (num2 % 3 == 0 && num2 % 6 != 0) {
				System.out.println(num2);
			}
			num2++;
		}

		// 실습 3) while문을 사용해서 10부터 100까지의 정수 중에서 3의 배수가 아닌 것들 출력
		int num3 = 9;
		while(num3 <= 100) {
			num3++;
			if (num3 % 3 == 0) continue;
			System.out.println(num3);
		}

		// do-while문
		int i = 1;
		do {
			System.out.println(i);
			i++;
		} while(i<=10);

	} //main

	// 소수 판별 메소드
	static boolean isPrime(int n) {
		if (n == 1) return true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

} // class