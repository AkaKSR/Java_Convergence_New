package me.swing.jframe;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class JFrame03 {
	public static void main(String[] args) {
		// 프레임 생성
		JFrame frame = new JFrame("세번째 윈도우");
		// 프레임 크기지정
		frame.setSize(400, 400);
		// 윈도우가 닫힐때 프로그램이 종료된다. - 윈도우 리스너 지정
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// 윈도우를 표시
		frame.setVisible(true);
	}
}
