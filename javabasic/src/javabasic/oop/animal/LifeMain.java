package javabasic.oop.animal;

public class LifeMain {

	public static void main(String[] args) {

		ILife dog = new Dog("말티즈");
		ILife cat = new Cat("러시안고양이");

		ILife rose = new Rose("백장미");
		ILife lily = new Lily("홍백합");

		// 개가 숨쉰다.
		dog.breathe();
		
		// 장미는 광합성한다.
		// 방법 1: 형변환 이용
		// ((IPlant)rose).light();
		// 방법 2: 인터페이스 분리 이용
		rose.light();
		
		cat.breathe();
		
		lily.light();
		
	}

}
