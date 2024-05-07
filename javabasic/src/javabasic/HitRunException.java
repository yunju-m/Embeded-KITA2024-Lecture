package javabasic;

public class HitRunException extends Exception {

	@Override
	public String getMessage() {
		return "사고 발생! 경찰서에 대리전화바랍니다.";
	}
}
