package kr.green.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	public static void main(String[] args) {
		ServerSocket server = null; // 서버소켓
		Socket client = null; // 클라이언트 소켓
		PrintWriter pw = null; // 출력
		Scanner sc = null;
		/*
		 * 서버는 소켓을 열어 클라이언트의 접속을 기다리고
		 * 접속하면 클라이언트 소켓을 리턴한다.
		 * 통신은 클라이언트 소켓끼리 통신한다.
		 */
		try {
			System.out.println("127.0.0.1의 1004번 포트를 열어 서버를 시작합니다.");
			server = new ServerSocket(1004);
			// 클라이언트의 접속을 무한대기
			client = server.accept();
			// 연결되면 통신
			System.out.println("연결 성공 : " + client);
			// 클라이언트로 문자를 전송해 보자
			pw = new PrintWriter(client.getOutputStream());
			pw.write("안녕하세요\n");
			pw.flush();
			sc = new Scanner(client.getInputStream());
			String data = sc.nextLine();
			System.out.println("받은 내용: " + data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sc.close();
				if (pw != null) pw.close();
				if (client != null) client.close();
				if (server != null) server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
