package javabasic.oop.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractLottoValid extends AbstractLotto {

	@Override
	public void validate(String userLottoNumber) {
		if (userLottoNumber.matches("\\d+")) {
			throw new IllegalArgumentException(WRONG_TYPE_ERROR);
		} 
	}

	@Override
	public void validate(List<Integer> userLottoList) {
		if(!isTrueSize(userLottoList)) {
			throw new IllegalArgumentException(WRONG_SIZE_ERROR);
		} else if(!isDuplicate(userLottoList)) {
			throw new IllegalArgumentException(WRONG_DUPLICATE_NUMBER_ERROR);
		} else if(!isWithinRange(userLottoList)) {
			throw new IllegalArgumentException(WRONG_RANGE_ERROR);
		}
	}
	
	private boolean isTrueSize(List<Integer> userLottoList) {
		return userLottoList.size() == SIZE;
	}

	private boolean isDuplicate(List<Integer> userLottoList) {
		Set<Integer> userLottoSet = new HashSet<>(userLottoList); 
		return userLottoSet.size() == userLottoList.size();
	}

	private boolean isWithinRange(List<Integer> userLottoList) {
		boolean rangeResult = true;
		for (int lottoNum : userLottoList) {
			if (lottoNum < START_RANGE || lottoNum > END_RANGE) {
				rangeResult = false;
				break;
			}
		}
		return rangeResult;
	}

}
