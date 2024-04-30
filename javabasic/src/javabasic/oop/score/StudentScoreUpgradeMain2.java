package javabasic.oop.score;

import java.util.ArrayList;
import java.util.List;

public class StudentScoreUpgradeMain2 {

	public static void main(String[] args) {

		List<StudentScoreUpgrade> ssList = new ArrayList<StudentScoreUpgrade>();
		ssList.add(new StudentScoreUpgrade("홍길동", 100, 90, 80));
		ssList.add(new StudentScoreUpgrade("강감찬", 90, 80, 70));
		ssList.add(new StudentScoreUpgrade("이순신", 80, 70, 60));

		System.out.println("이름" + "\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" + "학생총점" + "\t" + "학생평균");
		for (StudentScoreUpgrade ss : ssList) {
			System.out.println(ss);
		}

		List<Integer> subSumList = sumOfSubjectScore(ssList);
		System.out.println("과목총점\t" + subSumList.get(0) + "\t" + subSumList.get(1) + "\t" + subSumList.get(2));
		System.out.println("과목평균\t" + subSumList.get(0)/3 + "\t" + subSumList.get(1)/3 + "\t" + subSumList.get(2)/3);

	} // main

	static List<Integer> sumOfSubjectScore(List<StudentScoreUpgrade> ssList){
		List<Integer> sumList = new ArrayList<>();
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;

		for (StudentScoreUpgrade ss : ssList) {
			korSum += ss.kor;
			engSum += ss.eng;
			mathSum += ss.math;
		}
		sumList.add(0, korSum);
		sumList.add(1, engSum);
		sumList.add(2, mathSum);

		return sumList;

	}
} // class
