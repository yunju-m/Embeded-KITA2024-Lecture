package javabasic.oop.lotto;

import java.util.List;

public interface ILottoList {

	public int[] transStringToInt(String[] userLottoStringArray);
	public List<Integer> transArrayToList(int[] userLottoArray);
	
}
