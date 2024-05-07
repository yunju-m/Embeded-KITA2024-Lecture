package javabasic;

public class ContactAccidentException extends Exception{

	@Override
	public String getMessage() {
		return "사고 발생! 보험가입자와 전화상담바랍니다.";
	}
	
}
