package kr.green.chat1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
	public static void main(String[] args) {
		Socket socket = null;
		PrintWriter pw = null;
		Scanner sc1 = null;
		Scanner sc2 = new Scanner(System.in);
		
		try {
			System.out.println("서버에 접속합니다.");
			socket = new Socket("localhost", 9999);
			System.out.println("접속 성공: " + socket);
			pw = new PrintWriter(socket.getOutputStream());
			sc1 = new Scanner(socket.getInputStream());
			String message = "";
			do {
				message = sc1.nextLine();
				System.out.println("받은내용: " + message);
				if (message.equalsIgnoreCase("Exit")) continue;
				System.out.print("보낼 내용 입력: ");
				message = sc2.nextLine();
				pw.write(message + "\n");
				pw.flush();
			} while (message.equalsIgnoreCase("Exit"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sc1.close();
			pw.close();
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		sc2.close();
	}
}
