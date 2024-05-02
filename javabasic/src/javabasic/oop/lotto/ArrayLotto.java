/*
 * 개인과제
 * 과제명 : 배열로또
 * 제출마감일 : 5/6(화)
 * 과제설명 : 배열을 이용해서 로또645 프로그램을 작성하세요.
 * 프로세스
 * 1. 프로그램 시작 시 사용자에게 7개의 서로 다른 1~45사이의 숫자를 입력 받는다.
 * 2. 프로그램에서 랜덤한 숫자를 순서대로 7개 추출
 * 3. 등수 산정
 *   - 프로그램에서 추출한 앞 숫자 6개와 사용자가 입력한 순서대로 6개가 일치하면 1등
 *   - 프로그램에서 추출한 앞 숫자 6개와 사용자가 입력한 5개가 일치하고 보너스 숫자(맨 마지막 입력)가 일치하면 2등
 *   - 프로그램에서 추출한 숫자 5개와 사용자가 입력한 5개가 일치하면 3등 
 *   - 프로그램에서 추출한 숫자 4개와 사용자가 입력한 4개가 일치하면 4등
 *   - 프로그램에서 추출한 숫자 3개와 사용자가 입력한 3개가 일치하면 3등
 *   - 나머지는 "꽝~! 다음기회에" *
 *   
 * 4. 예시
 *   - 사용자가 1 1 2 3 4 5 6 입력 시 => 중복 숫자가 있습니다. 다시 입력해 주세요!
 *   - 사용자가 1 2 3 4 5 6 7 입력하고 프로그램에서 랜덤 추출한 숫자가 1 2 3 4 5 6 45 => 1등
 *   - 사용자가 1 2 3 4 5 6 7 입력하고 프로그램에서 랜덤 추출한 숫자가 1 2 3 4 5 45 7=> 2등
 *   - 사용자가 1 2 3 4 5 6 7 입력하고 프로그램에서 랜덤 추출한 숫자가 1 2 3 4 5 33 44=> 3등
 *   - 사용자가 1 2 3 4 5 6 7 입력하고 프로그램에서 랜덤 추출한 숫자가 1 2 3 4 22 33 44=> 4등
 *   - 사용자가 1 2 3 4 5 6 7 입력하고 프로그램에서 랜덤 추출한 숫자가 1 2 3 11 22 33 44=> 5등
 *   - 사용자가 1 2 3 4 5 6 7 입력하고 프로그램에서 랜덤 추출한 숫자가 10 11 12 13 14 15 16 => 꽝
 *   
 *  5. 주요 고려사항
 *   - 사용자가 입력한 7개의 숫자에 중복이 있는지 체크. 중복이 있다면 다시 입력받도록
 *   - 프로그램에서 랜덤하게 생성한 7개의 숫자에 중복이 없어야 한다.
 *   - 사용자 입력 수와 랜덤 수와 비교해서 등수 연산 후 출력
 *   
 *  6. 과제 제출 방법
 *   - 소스코드(java파일)와 실행결과 캡춰이미지 압축해서 realchoky@naver.com으로 이름써서 제출
 */

package javabasic.oop.lotto;

import java.util.List;

public class ArrayLotto {

	public static void main(String[] args) {

		LottoGame lottoGame = new LottoGame();
		List<Integer> userLottoList, computerLottoList;

		userLottoList = lottoGame.inputUserLotto();
		computerLottoList = lottoGame.inputComputerLotto();

		for (int comLottoNum : computerLottoList) {
			System.out.print(comLottoNum + " ");
		}

		Lotto lotto = new Lotto(userLottoList, computerLottoList);
		lotto.evaluateLottoRank();
		System.out.println("\n로또 결과: " + lotto.getLottoRank());

	}

}