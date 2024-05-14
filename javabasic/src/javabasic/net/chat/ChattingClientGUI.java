package javabasic.net.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

// 전체 창 (JFrame) : JFrame을 상속받으면 JFrame
public class ChattingClientGUI extends JFrame {

	public static final long serialVersionUID = 4238230498209348L;
	public static final int SERVERSOCKET_PORT = 5000;

	private JTextArea messageArea;
	private JTextField textField;
	private JButton exitButton;
	private ChattingClient client;

	public ChattingClientGUI() {
		super(":: Java Chatting ::"); // 제목
		setSize(400, 500); // 창 크기
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x버튼 누르면 프로그램 종료(닫힘 옵션)
		Color backgroundColor = new Color(240, 240, 240); // 배경색
		Color buttonColor = new Color(75, 75, 75); // 버튼 색깔
		Color textColor = new Color(50, 50, 50); // 텍스트 색깔
		Font textFont = new Font("Malgun Gothic", Font.PLAIN, 14); // 텍스트 폰트 (글자체, 스타일, 크기)
		Font buttonFont = new Font("Malgun Gothic", Font.BOLD, 12); // 버튼 텍스트 폰트

		messageArea = new JTextArea(); // 채팅메세지 목록 영역 생성
		messageArea.setEditable(false); // 편집 불가하도록
		messageArea.setBackground(backgroundColor); // 배경색
		messageArea.setForeground(textColor); // 글자색
		messageArea.setFont(textFont); // 폰트

		// 스크롤바가 붙어있는 창 : 채팅메세지 목록 창에 스크롤바 적용
		JScrollPane scrollPane = new JScrollPane(messageArea);
		// JFrame의 중앙에 스크롤창을 붙임
		// BorderLayout : 컴포넌트들을 NORTH(북), EAST(동), SOUTH(남), WEST(서), CENTER(중앙) 배치하는
		// 레이아웃
		add(scrollPane, BorderLayout.CENTER);

		// 시작하면 아이디 입력하도록 창 띄우기
		String name = JOptionPane.showInputDialog(this, "아이디를 입력하세요:", "아이디 입력", JOptionPane.PLAIN_MESSAGE);

		// JFrame 제목을 수정
		this.setTitle("접속자 아이디:" + name);

		// 사용자의 메세지 입력창
		textField = new JTextField();
		textField.setFont(textFont);
		textField.setForeground(textColor);
		textField.setBackground(backgroundColor);

		// 사용자가 한 줄 메세지를 입력하고 엔터치면 ActionEvent 발생
		// ActionEvent를 처리하는 addActionListener
		// ActionListener인터페이스를 구현한 익명내부클래스 구현
		textField.addActionListener(new ActionListener() {
			@Override
			// ActionEvent가 발생하면(즉, 사용자가 메세지 입력하고 엔터치면)
			public void actionPerformed(ActionEvent e) {
				// 메세지 생성
				String message = "[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "]" + name + ":"
						+ textField.getText();
				// 클라이언트에게 메세지 전송
				client.sendMessage(message);
				// 메세지 창 초기화
				textField.setText("");
			}
		});

		// 나가기 버튼
		exitButton = new JButton("나가기");
		exitButton.setFont(buttonFont);
		exitButton.setBackground(buttonColor);
		exitButton.setForeground(Color.WHITE);

		// 나가기 버튼을 클릭하면 ActionEvent가 발생 => ActionListener에서 처리
		// e : 발생한 ActionEvent
		exitButton.addActionListener(e -> {
			// 다른 클라이언트들에게 보내줄 메세지
			String departureMessage = name + "님이 채팅방을 나갔습니다.";
			// 메세지 전송
			client.sendMessage(departureMessage);
			// 클라이언트의 쓰레드를 중지시키기 위해서 일정 슬립타임을 부여
			// 클라이언트가 나가기 버튼을 클릭하면 쓰레드를 인터럽트해서 InterruptedException을 발생시킴
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}
			System.exit(0); // 정상적인 프로그램 종료
		});

		// JFrame 하단의 메시지 입력창과 나가기 버튼을 넣을 창
		// JPanel 자체의 레이아웃을 BorderLayout으로 설정
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.setBackground(backgroundColor);
		bottomPanel.add(textField, BorderLayout.CENTER);
		bottomPanel.add(exitButton, BorderLayout.EAST);
		
		// JFrame 하단에 bottomPanel 붙임
		add(bottomPanel, BorderLayout.SOUTH);

		try {
			// 채팅클라이언트 생성
			this.client = new ChattingClient("127.0.0.1", SERVERSOCKET_PORT, this::onMessageReceived);
			// 클라이언트 시작
			client.startClient();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			JOptionPane.showMessageDialog(this, "서버 접속 중 오류발생!", "접속 오류", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

	} // ChattingClientGUI()

	// ChattingClient의 Consumer
	private void onMessageReceived(String message) {
		// SwingUtilities.invokeLater : 실행시점을 최대한 늦추는 메소드(메모리 절약)
		SwingUtilities.invokeLater(() -> messageArea.append(message + "\n"));
	}

	public static void main(String[] args) {
		// 객체 생성해서 화면에 보이도록 설정
		SwingUtilities.invokeLater(() -> new ChattingClientGUI().setVisible(true));	
	}

}
