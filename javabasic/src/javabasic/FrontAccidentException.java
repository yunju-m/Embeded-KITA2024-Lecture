package javabasic;

public class FrontAccidentException extends Exception{

	@Override
	public String getMessage() {
		return "사고 발생! 경찰서와 119구급대에 연락바랍니다.";
	}
	
}
