package javabasic.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharFileExer {

	public static void main(String[] args) {

		FileWriter fw = null;
		FileWriter fw2 = null;
		FileReader fr = null;

		try {
			fw = new FileWriter("C:\\Users\\Administrator\\git\\Embeded-KITA2024-Lecture\\javabasic\\src\\assets\\diary.txt");
			fr = new FileReader("C:\\Users\\Administrator\\git\\Embeded-KITA2024-Lecture\\javabasic\\src\\assets\\diary.txt");
			fw2 = new FileWriter("C:\\Users\\Administrator\\git\\Embeded-KITA2024-Lecture\\javabasic\\src\\assets\\diary_copy.txt");
			fw.write("5월 10일 수업\n\n오늘은 Input, Output에 대해 공부했다.\n현재 Byte Stream과 Character Stream에 따라 읽기, 쓰기를 구현하고 있다.");
			fw.flush();

			char[] readCharsArr = new char[8];
			int readCharsLen = readCharsArr.length;
			int readCount = 0;

			while((readCount = fr.read(readCharsArr, 0, readCharsLen)) > -1) { // 다 읽으면 -1이 된다.
				fw2.write(readCharsArr, 0, readCount);
			}
			fw2.flush();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fw2.close();
				fr.close();
				fw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}

}
