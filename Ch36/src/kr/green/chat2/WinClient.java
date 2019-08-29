package kr.green.chat2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WinClient extends JFrame implements ActionListener, Runnable {
	private static final long serialVersionUID = -5511023168591956262L;
	JTextArea ta;
	JTextField tf;
	JButton sendBtn;
	Socket socket;
	PrintWriter printWriter;
	
	public WinClient() {
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
		WinClient client = new WinClient();
		try {
//			client.socket = new Socket("192.168.0.123", 9999);
			client.socket = new Socket("localhost", 9999);
			client.ta.append("localhost 서버의 9999포트에 접속합니다.\n");
			client.ta.append("서버에 접속했습니다.\n");
			client.printWriter = new PrintWriter(client.socket.getOutputStream());
			Thread thread = new Thread(client);
			thread.setDaemon(true);
			thread.start();
			client.tf.requestFocus();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
