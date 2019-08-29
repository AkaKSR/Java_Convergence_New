package kr.green.chat2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WinServer extends JFrame implements ActionListener, Runnable {
	private static final long serialVersionUID = 5698598237384336141L;
	JTextArea ta;
	JTextField tf;
	JButton sendBtn;
	Socket socket;
	PrintWriter printWriter;
	
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
		
		tf = new JTextField(38); // 입력 영역
		JPanel bottomPane = new JPanel(); // 하단 판떼기
		bottomPane.add(tf); // 하단 영역에 텍스트필드 붙이고
		tf.addActionListener(this);

		sendBtn = new JButton("전송"); // 버튼 만들고
		sendBtn.addActionListener(this); // 리스너 지정하고
		
		bottomPane.add(sendBtn); // 하단 영역에 버튼 붙이고
		
		// 하단 윈도우 메인 영역에 붙이기
		add(bottomPane, BorderLayout.SOUTH);
		
		// 커서를 텍스트필드로
		setVisible(true);
	}
	
	public static void main(String[] args) {
		WinServer server = new WinServer();
		
		// 클라이언트가 접속할때까지 사용 불가능
		server.tf.setEnabled(false);
		server.sendBtn.setEnabled(false);
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9999);
			server.ta.append("1004번 포트를 열어서 서버를 시작합니다.\n");
			server.ta.append("클라이언트의 접속을 기다리는 중...\n");
			server.socket = serverSocket.accept();
			server.ta.append("접속 성공: " + server.socket + "\n");
			server.printWriter = new PrintWriter(server.socket.getOutputStream()); // 출력 객체 생성
			
			// 접속에 성공하면 받는 스레드 시작
			Thread thread = new Thread(server);
			thread.setDaemon(true); // 데몬 스레드로 만든다.
			thread.start();
			
			// 입력이 가능하도록 해제한다.
			server.tf.setEnabled(true);
			server.sendBtn.setEnabled(true);
			
			// 실행과 동시에 입력칸인 tf에 포커스를 설정
			server.tf.requestFocus();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void run() {
		// 내용을 받아서 출력한다
		try {
			Scanner sc = new Scanner(socket.getInputStream());
			while (true) {
				String message = sc.nextLine();
				if (message==null) break;
				ta.append("상대방> " + message + "\n");
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 입력된 내용을 보낸다
		String message = tf.getText();
		if (message.equalsIgnoreCase("/exit")) {
			System.exit(0);
		}
		if (message.trim().length() > 0) {
			ta.append("나 > " + message.trim() + "\n");
			printWriter.write(message.trim() + "\n");
			printWriter.flush();
		}
		tf.setText("");
		tf.requestFocus();
	}
}
