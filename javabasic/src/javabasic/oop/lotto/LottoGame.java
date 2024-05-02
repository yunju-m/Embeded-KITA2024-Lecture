package javabasic.oop.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LottoGame {

	public static final int SIZE = 7;
	public static final int START_RANGE = 1;
	public static final int END_RANGE = 45;

	public static final String WRONG_TYPE_ERROR =  "숫자를 입력해주세요!";
	public static final String WRONG_SIZE_ERROR =  "로또번호 7개를 입력해 주세요!";
	public static final String WRONG_DUPLICATE_NUMBER_ERROR =  "중복 숫자가 있습니다. 다시 입력해 주세요!";
	public static final String WRONG_RANGE_ERROR =  "로또번호 1부터 45사이에 번호를 입력해주세요!";

	Scanner scn = new Scanner(System.in);

	List<Integer> inputUserLotto() {
		List<Integer> userLottoList = new ArrayList<>();
		boolean restart = true;
		while(restart) {
			try {
				String userLottoNumber = scn.nextLine();
				validate(userLottoNumber);
				userLottoList = transArrayToList(transStringToInt(userLottoNumber.split(" ")));
				validate(userLottoList);
				restart = false;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}	
		}
		return userLottoList;
	}

	List<Integer> inputComputerLotto() {
		int randomNumber;
		List<Integer> computerLottoList = new ArrayList<>();
		for (int i = 0; i < SIZE; i++) {
			randomNumber = (int)(Math.random() * 45) + 1;
			if (computerLottoList.contains(randomNumber)) i--;
			else computerLottoList.add(randomNumber);

		}
		return computerLottoList;
	}

	private void validate(String userLottoNumber) {
		if (userLottoNumber.matches("\\d+")) {
			throw new IllegalArgumentException(WRONG_TYPE_ERROR);
		} 
	}

	private void validate(List<Integer> userLottoList) {
		if(!isTrueSize(userLottoList)) {
			throw new IllegalArgumentException(WRONG_SIZE_ERROR);
		} else if(!isDuplicate(userLottoList)) {
			throw new IllegalArgumentException(WRONG_DUPLICATE_NUMBER_ERROR);
		} else if(!isWithinRange(userLottoList)) {
			throw new IllegalArgumentException(WRONG_RANGE_ERROR);
		}
	}

	private int[] transStringToInt(String[] userLottoStringArray) {
		return Arrays.stream(userLottoStringArray)
				.mapToInt(Integer::parseInt)
				.toArray();
	}

	private List<Integer> transArrayToList(int[] userLottoArray){
		List<Integer> userLottoList = new ArrayList<>();
		for (int lottoNum : userLottoArray)
			userLottoList.add(lottoNum);
		return userLottoList;
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
