package kr.green.chat2;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ReceiverThread extends Thread {
	private Socket socket;
	
	public ReceiverThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// 데이터가 있으면 받아서 출력을 한다.
		try {
			Scanner sc = new Scanner(socket.getInputStream());
			while (true) {
				String message = sc.nextLine();
				if (message == null) break;
				System.out.println("받은 내용: " + message);
			}
			sc.close();
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}
}
