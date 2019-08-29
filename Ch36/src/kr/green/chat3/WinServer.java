package kr.green.chat3;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WinServer extends JFrame {
	private static final long serialVersionUID = 9155792072058265985L;
	JTextArea ta;
	
	public WinServer() {
		setSize(500, 800);
		setTitle("허접한 채팅");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false); // 사이즈 변경 불가
		
		ta = new JTextArea(20, 40); // 텍스트 영역 생성
		ta.setEditable(false); // 에딧 불가능
		JScrollPane centerPane = new JScrollPane(ta); // 텍스트 영역에 스크롤바 만들기
		add(centerPane, BorderLayout.CENTER); // 중앙에 붙이기
		// 커서를 텍스트필드로
		setVisible(true);
	}
	
	public static void main(String[] args) {
		WinServer server = new WinServer();
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9999);
			server.ta.append("9999번 포트를 열어서 서버를 시작했습니다.\n");
			while (true) { // 모든 접속을 다 받아 줄 것이다.
				Socket socket = serverSocket.accept();
				server.ta.append("접속 성공: " + socket + "\n");
				PerClientThread thread = new PerClientThread(socket);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
