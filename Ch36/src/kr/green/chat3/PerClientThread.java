package kr.green.chat3;
/*
 * 접속자마다 생길 스레드
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PerClientThread extends Thread {
	// 모든 접속자가 공유해야 되므로 static으로 선언
	static List<PrintWriter> list = Collections
			.synchronizedList(new ArrayList<PrintWriter>()); // 동기화가 가능한 리스트를 만든다.
	Socket socket;
	PrintWriter printWriter;
	String name;
	
	// 생성자
	public PerClientThread(Socket socket) {
		this.socket = socket;
		try {
			printWriter = new PrintWriter(this.socket.getOutputStream());
			list.add(printWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			Scanner sc = new Scanner(socket.getInputStream());
			// 첫번째 전송은 이름이다.
			name = sc.nextLine();
			sendAll("#" + name + "님이 들어오셨습니다.");
			// 다음부터는 메세지이다.
			while (true) {
				String message = sc.nextLine();
				if (message==null) break;
				sendAll(name + "> " + message);
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 모든 사용자에게 메세지 보내기
	private void sendAll(String message) {
		for (PrintWriter pw : list) {
			pw.write(message + "\n");
			pw.flush();
		}
	}
}
