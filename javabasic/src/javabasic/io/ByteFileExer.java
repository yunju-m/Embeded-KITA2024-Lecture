package javabasic.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteFileExer {

	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(
					"C:\\Users\\Administrator\\git\\Embeded-KITA2024-Lecture\\javabasic\\src\\assets\\dog.jpg");
			fos = new FileOutputStream(
					"C:\\Users\\Administrator\\git\\Embeded-KITA2024-Lecture\\javabasic\\src\\assets\\dog_copy.jpg"); // 새로운 파일명(dog_copy.jpg) 작성

			byte[] readBytesArr = new byte[1024]; // 1024byte 단위로 파일을 읽는다.
			while (true) {
				int readByteCount = fis.read(readBytesArr);
				fos.write(readBytesArr);
				int readBytesLen = readBytesArr.length;
				if (readByteCount < readBytesLen) break;
			}
		} catch (FileNotFoundException fnfe) { // 하위 예외처리 우선시
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fos.close(); // close 필수!
				fis.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main

} // class