package me.swing.jframe;

import javax.swing.JFrame;

public class JFrame01 {
	public static void main(String[] args) {
		// 윈도우가 만들어지고 닫히나 프로그램이 종료되지 않는다.
		// 프레임 생성
		JFrame frame = new JFrame("첫번째 윈도우");
		// 프레임 크기지정
		frame.setSize(400, 400);
		// 윈도우를 표시
		frame.setVisible(true);
	}
}
