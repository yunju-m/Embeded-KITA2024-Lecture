package javabasic.oop.score;

public class StudentScoreMain {

	public static void main(String[] args) {

		StudentScore ss1 = new StudentScore("홍길동", 100, 90, 80);
		StudentScore ss2 = new StudentScore("강감찬", 90, 80, 70);
		StudentScore ss3 = new StudentScore("이순신", 80, 70, 60);

		int hongSum = sumOfStudnetScore(ss1);
		int kangSum = sumOfStudnetScore(ss2);
		int leeSum = sumOfStudnetScore(ss3);

		StudentScore[] ssArray = new StudentScore[3];
		ssArray[0] = ss1;
		ssArray[1] = ss2;
		ssArray[2] = ss3;

		int[] subSumArray = sumOfSubjectScore(ssArray);

		System.out.println("이름" + "\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" + "학생총점" + "\t" + "학생평균");
		System.out.println(ss1 + "\t" + hongSum + "\t" + hongSum/3);
		System.out.println(ss2 + "\t" + kangSum + "\t" + kangSum/3);
		System.out.println(ss3 + "\t" + leeSum + "\t" + leeSum/3);
		System.out.println("과목총점\t" + subSumArray[0] + "\t" + subSumArray[1] + "\t" + subSumArray[2]);
		System.out.println("과목평균\t" + subSumArray[0]/3 + "\t" + subSumArray[1]/3 + "\t" + subSumArray[2]/3);

	}	// main

	// 1. 학생별 총점 메소드
	static int sumOfStudnetScore(StudentScore ss) {
		return ss.kor + ss.eng + ss.math;
	}

	// 2. 과목별 총점 메소드
	static int[] sumOfSubjectScore(StudentScore[] ssArray) {
		int[] sumArray = new int[3];
		for (StudentScore ss : ssArray) {
			sumArray[0] += ss.kor;
			sumArray[1] += ss.eng;
			sumArray[2] += ss.math;
		}
		return sumArray;
	}

}	// class