/*
 * 예외처리 실습
 * 
 * 보험사고 발생시에 사고별 대응하는 프로그램
 * 1. 사고유형 : 정면충돌사고, 후면충돌사고, 접촉사고
 * 2. 정면충돌사고시에는 경찰서와 119구급대에 연락
 * 3. 후면충돌사고시에는 보험직원을 파견
 * 4. 접촉사고시에는 보험가입자와 전화상담
 * 정면충돌사고:후면충돌사고:접촉사고 비율은 1:3:6
 * (Math.random으로 1~10 이용, 1:정면, 2~4:후면, 5~10:접촉) 
 * 5. 뺑소니사고시에는 경찰서에 대리전화 : 11
 * 사용자정의예외를 생성해서 예외처리를 통해서 구현
 * 
 */

package javabasic;

public class ExceptionExer {

	public static final String FRONT_ACC = "정면충돌";
	public static final String BACK_ACC = "후면충돌";
	public static final String CONT_ACC = "접촉";
	public static final String RUN_ACC = "뺑소니";

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			int accidentNum = (int)(Math.random() * 11) + 1;
			System.out.println(accidentNum);

			//			if (accidentNum == 1) {
			//				try {
			//					throw new FrontAccidentException();
			//				} catch (FrontAccidentException fe) {
			//					System.out.println(fe.getMessage());
			//				}
			//			} else if (accidentNum >=2 && accidentNum <= 4) {
			//				try {
			//					throw new BackAccidentException();
			//				} catch (BackAccidentException be) {
			//					System.out.println(be.getMessage());
			//				} 
			//			} else if (accidentNum >= 5 && accidentNum <= 10){
			//				try {
			//					throw new ContactAccidentException();
			//				} catch (ContactAccidentException ce) {
			//					System.out.println(ce.getMessage());
			//				}
			//			} else {
			//				try {
			//					throw new HitRunException();
			//				} catch (HitRunException he) {
			//					System.out.println(he.getMessage());
			//				}
			//			}

			try {
				if (accidentNum == 1) {
					throw new FrontAccidentException();
				} else if (accidentNum >=2 && accidentNum <= 4) {
					throw new BackAccidentException();
				} else if (accidentNum >= 5 && accidentNum <= 10){
					throw new ContactAccidentException();
				} else {
					throw new HitRunException();
				}
			} catch (Exception ex) {
				String msg = "";
				if (ex instanceof FrontAccidentException) {
					msg = FRONT_ACC;
				} else if (ex instanceof BackAccidentException) {
					msg = BACK_ACC;
				} else if (ex instanceof ContactAccidentException) {
					msg = CONT_ACC;
				} else if (ex instanceof HitRunException) {
					msg = RUN_ACC;
				}
				System.out.println(msg + ex.getMessage());
			} 

		}

	}

}
