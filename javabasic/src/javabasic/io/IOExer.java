/*
 * IO 실습 2)
 * 
 * 1. StudentScore 데이터클래스 생성 (int sno, String name, int kor, int eng, int math, int total)
 * 2. IOExer에서 5개의 StudentScore 객체 생성 후 assets/studentscore.dat에 직렬화
 * 3. 직렬화된 객체를 역직렬화하여 학생 성적데이터 출력
 */

package javabasic.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IOExer {

	public static void main(String[] args) {

		List<StudentScore> ssList = new ArrayList<StudentScore>();
		ssList.add(new StudentScore(1, "홍길동", 90, 80, 70));
		ssList.add(new StudentScore(2, "김길동", 80, 70, 60));
		ssList.add(new StudentScore(3, "박길동", 90, 70, 50));
		ssList.add(new StudentScore(4, "이길동", 40, 80, 70));
		ssList.add(new StudentScore(5, "장길동", 100, 90, 95));

		File file = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			file = new File("C:\\Users\\Administrator\\git\\Embeded-KITA2024-Lecture\\javabasic\\src\\assets\\studentsocre.dat");
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(ssList);	// 직렬화

			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);

			List<Integer> sbjTotal = new ArrayList<Integer>();
			sbjTotal.add(0, 0);
			sbjTotal.add(1, 0);
			sbjTotal.add(2, 0);

			List<StudentScore> readSsList = (ArrayList<StudentScore>)ois.readObject();
			for (StudentScore ss : readSsList) {
				sbjTotal.set(0, sbjTotal.get(0) + ss.getKor());
				sbjTotal.set(1, sbjTotal.get(1) + ss.getEng());
				sbjTotal.set(2, sbjTotal.get(2) + ss.getMath());
				System.out.println(ss);
			}
			System.out.println("국어총점:" + sbjTotal.get(0) + ", 영어총점:" + sbjTotal.get(1) + ", 수학총점:" +sbjTotal.get(2));
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				ois.close();
				oos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}

}
