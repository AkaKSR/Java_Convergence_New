package me.swing.jframe;

import javax.swing.JFrame;

public class JFrame02 {
	public static void main(String[] args) {
		// 프레임 생성
		JFrame frame = new JFrame("두번째 윈도우");
		// 프레임 크기지정
		frame.setSize(400, 400);
		// 윈도우가 닫힐때 프로그램이 종료된다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 윈도우를 표시
		frame.setVisible(true);
	}
}
