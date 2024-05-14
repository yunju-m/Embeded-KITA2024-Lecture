package javabasic.net;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChattingClient {

	public static final int SERVERSOCKET_PORT = 9999;

	public static void main(String[] args) {

		Socket s = null;

		try {
			// s = new Socket("localhost", SERVERSOCKET_PORT);	// (도메인 이름, 포트번호)
			// s = new Socket("192.168.8.13", SERVERSOCKET_PORT); // (ip주소, 포트번호)
			// s = new Socket("127.0.0.1", SERVERSOCKET_PORT);
			s = new Socket("192.168.8.12", 4444);	// 외부 서버 접속
			if (s!=null) {
				System.out.println("채팅서버에 연결되었습니다! " + s);
			}
		} catch (UnknownHostException ukhe) {
			ukhe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
