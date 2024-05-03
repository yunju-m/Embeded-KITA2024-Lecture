package javabasic.oop.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto2 extends AbstractLottoValid {

	Lotto2() {
		userLottoList = new ArrayList<>();
		computerLottoList = new ArrayList<>();
	}
	
	Lotto2(List<Integer> userLottoList, List<Integer> computerLottoList) {
		this.userLottoList = userLottoList;
		this.computerLottoList = computerLottoList;
		lottoCount = 0;
		lottoRank =  "미정";
	}

}
