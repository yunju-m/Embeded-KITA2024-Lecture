/*
 * IO 실습 1)
 * 
 * asset 폴더에 이미지파일 하나, 문자파일 하나를 준비
 * 
 * 1. 사용자에게 1 또는 2를 입력받는다.
 * 2. 사용자가 1를 입력하면 이미지파일을 복사해서 assets에 저장
 * 3. 사용자가 2를 입력하면 문자파일을 복사해서 assets에 저장
 * * 파일명이 image.jpg > 복사한 파일명은 image_copy.jpg
 * * 파일명이 text.txt > 복사한 파일명은 text_copy.txt
 * 
 */

package javabasic.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyer {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String inputValue;
		boolean restart = true;

		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileReader fr = null;
		FileWriter fw = null;

		System.out.println("원하는 목록 번호를 입력해주세요.");
		System.out.println("1 : 이미지 파일 복사");
		System.out.println("2 : 텍스트 파일 복사");

		while(restart) {
			System.out.print("입력할 번호 : ");
			inputValue = scn.next();
			if (inputValue.equals("1")) {
				// 이미지 파일 복사
				try {
					fis = new FileInputStream(
							"C:\\Users\\Administrator\\git\\Embeded-KITA2024-Lecture\\javabasic\\src\\assets\\cat.jpg");
					fos = new FileOutputStream(
							"C:\\Users\\Administrator\\git\\Embeded-KITA2024-Lecture\\javabasic\\src\\assets\\cat_copy.jpg");

					byte[] readBytesArr = new byte[1024];
					int readBytesLen = readBytesArr.length;
					while (true) {
						int readByteCount = fis.read(readBytesArr);
						fos.write(readBytesArr);
						if (readByteCount < readBytesLen) break;
					}
					restart = false;
				} catch (FileNotFoundException fnfe) {
					fnfe.printStackTrace();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} finally {
					try {
						fos.close();
						fis.close();					
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}

			} else if (inputValue.equals("2")) {
				// 텍스트 파일 복사
				try {
					fr = new FileReader("C:\\Users\\Administrator\\git\\Embeded-KITA2024-Lecture\\javabasic\\src\\assets\\catDirctory.txt");
					fw = new FileWriter("C:\\Users\\Administrator\\git\\Embeded-KITA2024-Lecture\\javabasic\\src\\assets\\catDirctory_copy.txt");

					char[] readCharsArr = new char[8];
					int readCharsLen = readCharsArr.length;
					int readCount = 0;

					while ((readCount = fr.read(readCharsArr, 0, readCharsLen)) > -1) {
						fw.write(readCharsArr, 0, readCount);
					}
					fw.flush();
					restart = false;
				} catch (FileNotFoundException fnfe) {
					fnfe.printStackTrace();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} finally {
					try {
						fw.close();
						fr.close();
					} catch(IOException ioe) {
						ioe.printStackTrace();
					}
				}
			} else {
				System.out.println("1 또는 2를 입력해주세요!");
			}
		}
		scn.close();
	}

}
