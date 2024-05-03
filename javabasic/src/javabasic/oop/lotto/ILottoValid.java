package javabasic.oop.lotto;

import java.util.List;

public interface ILottoValid {

	public abstract void validate(String userLottoNumber);
	public void validate(List<Integer> userLottoList);
	
}
