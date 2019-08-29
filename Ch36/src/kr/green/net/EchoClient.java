package kr.green.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) {
		Socket client = null;
		Scanner sc = null;
		PrintWriter pw = null;
		// 서버에 접속한다.
		try {
//			client = new Socket("192.168.0.123", 1004);
			client = new Socket("localhost", 1004);
			// 통신한다.
			System.out.println("접속 성공 : " + client);
			sc = new Scanner(client.getInputStream());
			String data = sc.nextLine();
			System.out.println("받은 내용: " + data);
			pw = new PrintWriter(client.getOutputStream());
			pw.write("안녕하세요\n");
			pw.flush();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pw != null) pw.close();
				sc.close();
				if (client != null) client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
