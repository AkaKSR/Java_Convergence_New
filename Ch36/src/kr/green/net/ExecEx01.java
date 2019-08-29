package kr.green.net;

import java.io.IOException;

/*
 * 자바에서 윈도우 명령어 실행하기
 */
public class ExecEx01 {
	public static void main(String[] args) {
		// JDK 1.4 까지
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("calc");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
