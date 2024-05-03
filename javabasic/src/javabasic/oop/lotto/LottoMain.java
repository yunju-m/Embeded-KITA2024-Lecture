package javabasic.oop.lotto;

import java.util.List;

public class LottoMain {

	public static void main(String[] args) {

		ILotto lotto = new Lotto2();
		List<Integer> userLottoList, computerLottoList;
		boolean restart = true;

		while(restart) {
			try {
				userLottoList = lotto.inputUserLotto();
				computerLottoList = lotto.inputComputerLotto();

				for (int comLottoNum : computerLottoList) {
					System.out.print(comLottoNum + " ");
				}

				lotto = new Lotto2(userLottoList, computerLottoList);
				lotto.evaluateLottoRank();
				System.out.println("\n로또 결과: " + lotto.getLottoRank());
				restart = false;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}	
		}

	}

}
