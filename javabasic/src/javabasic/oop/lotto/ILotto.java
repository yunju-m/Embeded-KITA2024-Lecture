package javabasic.oop.lotto;

import java.util.List;

public interface ILotto {

	public abstract List<Integer> inputUserLotto();
	public abstract List<Integer> inputComputerLotto();
	public void evaluateLottoRank();
	public int[] transStringToInt(String[] userLottoStringArray);
	public List<Integer> transArrayToList(int[] userLottoArray);
	public abstract String getLottoRank();
	public int countSameLottoNumbers();
	public boolean sameLastLottoNumber();
	public void calculateLottoRank();
	public abstract void validate(String userLottoNumber);
	public void validate(List<Integer> userLottoList);
	
}
