package javabasic.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattingServer {

	public static final int SERVERSOCKET_PORT = 9999;

	public static void main(String[] args) {

		ServerSocket ss = null;

		try {
			ss = new ServerSocket(SERVERSOCKET_PORT);
			if (ss!=null) {
				System.out.println("ServerSocket 생성됨!");
			}
			while(true) {
				Socket svSocket = ss.accept();	// 블로킹 메소드
				if (svSocket!= null) {
					System.out.println("서버 측 Socket 생섬됨! : " + svSocket);
				}
				InputStream is = svSocket.getInputStream();	// 클라이언트의 메시지 수신
				BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
				System.out.println(br.readLine());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}