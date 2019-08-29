package kr.green.chat2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {
	private Socket socket;
	public SendThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			while (true) {
				System.out.print("보낼 내용입력: ");
				String message = sc.nextLine();
				if (message.equalsIgnoreCase("bye")) break;
				pw.write(message + "\n");
				pw.flush();
			}
			pw.close();
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
