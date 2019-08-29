package kr.green.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 접속하는 컴퓨터에게 시간을 알려주는 서버
 */
public class TimeServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			// 서버 시작
			System.out.println("타임서버를 시작했습니다.");
			server = new ServerSocket(1004);
			// 모든 클라이언트의 접속을 받아 주어야 한다.
			while (true) {
				Socket client = server.accept(); // 접속 대기
				System.out.println("접속: " + client);
				PrintWriter pw = new PrintWriter(client.getOutputStream());
				pw.write(sdf.format(new Date() + "\n"));
				pw.close();
				client.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
