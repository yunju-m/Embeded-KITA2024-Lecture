package javabasic.oop.lotto;

import java.util.List;

public abstract class AbstractLottoRank implements ILottoRank {

	List<Integer> userLottoList;
	List<Integer> computerLottoList;
	String userLottoNumber;
	String lottoRank;
	int lottoCount;

	@Override
	public String getLottoRank() {
		return lottoRank;
	}

	@Override
	public int countSameLottoNumbers() {
		for (int lottoNum : userLottoList) {
			if (computerLottoList.contains(lottoNum)) {
				lottoCount++;
			}
		}
		return lottoCount;
	}

	@Override
	public boolean sameLastLottoNumber() {
		int lastIndex = userLottoList.size()-1;
		return userLottoList.get(lastIndex) == computerLottoList.get(lastIndex);
	}

	@Override
	public void calculateLottoRank() {
		if (lottoCount == 7 || (lottoCount == 6 && !sameLastLottoNumber())) {
			lottoRank = "1등";
		} else if (lottoCount == 6 && sameLastLottoNumber()) {
			lottoRank = "2등";
		} else if (lottoCount == 5) {
			lottoRank = "3등";
		} else if (lottoCount == 4) {
			lottoRank = "4등";
		} else if (lottoCount == 3) {
			lottoRank = "5등";
		} else {
			lottoRank = "꽝~! 다음기회에";
		}

	}

}
