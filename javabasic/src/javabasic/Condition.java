package javabasic;

import java.util.Scanner;

public class Condition {

	public static void main(String[] args) {

		int i = 15;

		if (i<10) {
			System.out.println("i가 10보다 작습니다!");
		} else if (i==15) {
			System.out.println("i가 15입니다!");
		} else {
			System.out.println("i가 10보다 작지 않고 15가 아닙니다!");
		}

		int j = 1;

		switch (j) {
		case 1:
			System.out.println("남성입니다!");
			break;
		case 2:
			System.out.println("여성입니다!");
			break;
		default:
			System.out.println("남성도 여성도 아닙니다!");
		}

		// switch문을 if문으로 전환
		if (j==1) {
			System.out.println("남성입니다!");
		} else if (j==2) {
			System.out.println("여성입니다!");
		} else {
			System.out.println("남성도 여성도 아닙니다!");
		}

		// 실습 1)
		// 두 개의 int변수를 만들어 각각 5와 10의 값을 대입하고
		// 두 변수의 합을 sum이라는 byte 변수에 저장한 후 
		// 값이 10보다 큰지 비교하여 출력
		int num1 = 5, num2 = 10;
		byte sum = (byte)(num1 + num2);

		if (sum > 10) {
			System.out.println("sum은 10보다 크다!");
		} else {
			System.out.println("sum은 10보다 작거나 같다!");
		}

		// 실습 2)
		// num3이라는 int변수에는 5를 대입하고
		// num4이라는 int변수에는 10을 대입하고
		// sum2에는 int변수에는 두 변수의 합을 대입하고
		// mul에는 int변수에는 두 변수의 곱을 대입하고
		// 두 변수의 곱에서 두 변수의 합을 뺀 값을 result라는 short변수에 저장
		// result가 0~10사이에 있는지, 11~20사이에 있는지
		// 21~30사이에 있는지, 31~40사이에 있는지 출력
		int num3 = 5, num4 = 10;
		int sum2 = num3 + num4;
		int mul = num3 * num4;
		short result = (short)(mul - sum2);

		if (result >= 0 && result <= 10) {
			System.out.println(result + "는 0부터 10사이에 수 입니다.");
		} else if (result >= 11 && result <= 20) {
			System.out.println(result + "는 11부터 20사이에 수 입니다.");
		} else if (result >= 21 && result <= 30) {
			System.out.println(result + "는 21부터 30사이에 수 입니다.");
		} else if (result >= 31 && result <= 40) {
			System.out.println(result + "는 31부터 40사이에 수 입니다.");
		}


		// 실습 3)
		// 키보드에서 숫자를 하나 입력받아서 입력받은 숫자를 5로 나눈 나머지를 출력
		Scanner scn = new Scanner(System.in);

		System.out.print("숫자 하나를 입력해주세요. ");
		int number = scn.nextInt();
		System.out.println(number + "를 5로 나눈 나머지 : " + number % 5);

		// 실습 4)
		// 키보드에서 숫자를 두개 입력받아서 입력받은 두 수의 합을 출력
		int number1, number2;

		System.out.print("숫자 두개를 입력해주세요. ");
		number1 = scn.nextInt();
		number2 = scn.nextInt();
		System.out.println("두 수의 합 : " + (number1 + number2));

		// 실습 5)
		// 키보드에서 0~6까지의 숫자를 입력받아서 0이면 일요일 1이면 월요일 ... 출력
		System.out.print("0~6까지의 숫자 한개를 입력해주세요. ");
		int day = scn.nextInt();

		switch(day) {
		case 0: System.out.println("일요일"); break;
		case 1: System.out.println("월요일"); break;
		case 2: System.out.println("화요일"); break;
		case 3: System.out.println("수요일"); break;
		case 4: System.out.println("목요일"); break;
		case 5: System.out.println("금요일"); break;
		case 6: System.out.println("토요일"); break;
		default: System.out.println("범위가 올바르지 않습니다. 0~6까지의 숫자를 입력해주세요.");
		}

		scn.close();

	} // main

} // class