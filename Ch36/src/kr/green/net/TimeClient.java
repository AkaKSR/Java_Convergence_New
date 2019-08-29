package kr.green.net;
import java.io.IOException;
/*
 * 서버로부터 시간을 받아 현재 컴퓨터의 시간을 변경한다.
 */
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TimeClient {
	public static void main(String[] args) {
		Socket socket = null;
		Scanner sc = null;
		
		try {
			socket = new Socket("192.168.0.123", 1004);
//			socket = new Socket("localhost", 1004);
			sc = new Scanner(socket.getInputStream());
			String time = sc.nextLine();
			System.out.println("받은시간: " + time);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sc.close();
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
