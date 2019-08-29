package kr.green.chat1;
import java.io.IOException;
import java.io.PrintWriter;
/*
 * 멍청한 채팅서버 만들기
 */
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		PrintWriter pw = null;
		Scanner sc1 = null; // 데이터를 받을 스캐너
		Scanner sc2 = new Scanner(System.in); // 내가 입력한 내용을 받을 스캐너
		
		try {
			System.out.println("서버를 시작했습니다.");
			serverSocket = new ServerSocket(9999);
			System.out.println("접속을 기다립니다.");
			socket = serverSocket.accept();
			System.out.println("접속 성공: " + socket);
			pw = new PrintWriter(socket.getOutputStream());
			sc1 = new Scanner(socket.getInputStream());
			String message = "";
			do {
				System.out.print("보낼내용 입력: ");
				message = sc2.nextLine();
				pw.write(message + "\n");
				pw.flush();
				if (message.equalsIgnoreCase("Exit")) {
					break;
				}
				message = sc1.nextLine();
				System.out.println("받은내용: " + message);
			} while (message.equalsIgnoreCase("Exit"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sc2.close();
			pw.close();
			try {
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
