package javabasic.oop.lotto;

import java.util.List;

public interface ILotto extends ILottoRank, ILottoValid, ILottoList {

	public abstract List<Integer> inputUserLotto();
	public abstract List<Integer> inputComputerLotto();
	public void evaluateLottoRank();
	
}
