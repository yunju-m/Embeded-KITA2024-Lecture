package javabasic.oop.lotto;

import java.util.List;

public class Lotto {

	private List<Integer> userLottoList;		// 사용자 로또 번호들
	private List<Integer> computerLottoList;	// 컴퓨터 랜덤 로또 번호들
	private int lottoCount;						// 일치하는 로또 번호 개수
	private String lottoRank;					// 로또 등수

	Lotto(List<Integer> userLottoList, List<Integer> computerLottoList) {
		this.userLottoList = userLottoList;
		this.computerLottoList = computerLottoList;
		lottoCount = 0;
		lottoRank =  "미정";
	}

	public int getLottoCount() {
		return lottoCount;
	}

	public void setLottoCount(int lottoCount) {
		this.lottoCount = lottoCount;
	}

	public String getLottoRank() {
		return lottoRank;
	}

	public void setLottoRank(String lottoRank) {
		this.lottoRank = lottoRank;
	}

	public void evaluateLottoRank() {
		lottoCount = countSameLottoNumbers();
		calculateLottoRank();
	}

	private int countSameLottoNumbers() {
		for (int lottoNum : userLottoList) {
			if (computerLottoList.contains(lottoNum)) {
				lottoCount++;
			}
		}
		return lottoCount;
	}

	private boolean sameLastLottoNumber() {
		int lastIndex = userLottoList.size()-1;
		return userLottoList.get(lastIndex) == computerLottoList.get(lastIndex);
	}

	private void calculateLottoRank() {
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
