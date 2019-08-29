package kr.green.chat2;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
	public static void main(String[] args) {
		Socket socket = null;
		Scanner sc = null;
		
		try {
			socket = new Socket("localhost", 9999);
//			socket = new Socket("192.168.0.123", 9999);
			ReceiverThread receiverThread = new ReceiverThread(socket);
			SendThread sendThread = new SendThread(socket);
			receiverThread.start();
			sendThread.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
