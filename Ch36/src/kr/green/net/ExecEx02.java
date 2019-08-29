package kr.green.net;

import java.io.IOException;
import java.util.Scanner;

/*
 * 자바에서 윈도우 명령어 실행하기
 */
public class ExecEx02 {
	public static void main(String[] args) {
		// JDK 1.5 까지
//		ProcessBuilder builder = new ProcessBuilder("calc");
		ProcessBuilder builder2 = new ProcessBuilder("cmd", "/c", "dir /w");
		try {
//			builder.start();
			Process process = builder2.start();
			Scanner sc = new Scanner(process.getInputStream(), "MS949");
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
			// 외부 명령어의 결과를 받아서 사용하고자 한다면
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
