package javabasic.oop.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractLottoList implements ILottoList {

	@Override
	public int[] transStringToInt(String[] userLottoStringArray) {
		return Arrays.stream(userLottoStringArray)
				.mapToInt(Integer::parseInt)
				.toArray();
	}

	@Override
	public List<Integer> transArrayToList(int[] userLottoArray) {
		List<Integer> userLottoList = new ArrayList<>();
		for (int lottoNum : userLottoArray)
			userLottoList.add(lottoNum);
		return userLottoList;
	}

}
