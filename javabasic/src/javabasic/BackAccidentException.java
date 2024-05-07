package javabasic;

public class BackAccidentException extends Exception{

	@Override
	public String getMessage() {
		return "사고 발생! 보험직원을 파견하십시오.";
	}
	
}
