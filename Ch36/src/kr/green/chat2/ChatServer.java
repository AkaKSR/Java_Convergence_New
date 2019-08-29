package kr.green.chat2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			System.out.println("서버 시작");
			serverSocket = new ServerSocket(9999);
			System.out.println("접속 대기");
			socket = serverSocket.accept();
			System.out.println("접속 성공");
			// 스레드 시작
			ReceiverThread receiverThread = new ReceiverThread(socket);
			SendThread sendThread = new SendThread(socket);
			receiverThread.start();
			sendThread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
