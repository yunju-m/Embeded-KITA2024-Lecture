package javabasic.oop.lotto;

import java.util.List;
import java.util.Scanner;

public abstract class AbstractLotto implements ILotto {

	Scanner scn = new Scanner(System.in);

	public static final int SIZE = 7;
	public static final int START_RANGE = 1;
	public static final int END_RANGE = 45;

	public static final String WRONG_TYPE_ERROR =  "숫자를 입력해주세요!";
	public static final String WRONG_SIZE_ERROR =  "로또번호 7개를 입력해 주세요!";
	public static final String WRONG_DUPLICATE_NUMBER_ERROR =  "중복 숫자가 있습니다. 다시 입력해 주세요!";
	public static final String WRONG_RANGE_ERROR =  "로또번호 1부터 45사이에 번호를 입력해주세요!";

	List<Integer> userLottoList;
	List<Integer> computerLottoList;
	String userLottoNumber;
	String lottoRank;
	int lottoCount;

	@Override
	public List<Integer> inputUserLotto() {
		userLottoNumber = scn.nextLine();
		userLottoList = transArrayToList(transStringToInt(userLottoNumber.split(" ")));
		validate(userLottoList);
		return userLottoList;
	}

	@Override
	public List<Integer> inputComputerLotto() {
		int randomNumber;
		for (int i = 0; i < SIZE; i++) {
			randomNumber = (int)(Math.random() * 45) + 1;
			if (computerLottoList.contains(randomNumber)) i--;
			else computerLottoList.add(randomNumber);

		}
		return computerLottoList;
	}

	@Override
	public void evaluateLottoRank() {
		lottoCount = countSameLottoNumbers();
		calculateLottoRank();
	}

	@Override
	public String getLottoRank() {
		return lottoRank;
	}

	@Override
	public int[] transStringToInt(String[] userLottoStringArray) {
		return null;
	}

	@Override
	public List<Integer> transArrayToList(int[] userLottoArray){
		return userLottoList;
	}
	
	@Override
	public int countSameLottoNumbers() {
		return lottoCount;
	}

	@Override
	public boolean sameLastLottoNumber() {
		return false;
	}

	@Override
	public void calculateLottoRank() {
	}



}
