package me.swing.jframe;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class JFrame05 {
	public static void main(String[] args) {
		// 프레임 생성
		JFrame frame = new JFrame("다섯번째 윈도우");
		// 프레임 크기지정
		frame.setSize(400, 400);
		// 윈도우가 닫힐때 프로그램이 종료된다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		// 해상도 구하기
//		Toolkit toolKit = frame.getToolkit();
//		Dimension screen = toolKit.getScreenSize();
//		System.out.println(screen.width + ", " + screen.height);
//		// 윈도우 크기 구하기
//		Dimension window = frame.getSize();
//		System.out.println(window.width + ", " + window.height);
//		// 화면 중앙에 배치하기 위하여 위치값 계산
//		int x = (screen.width - window.width) / 2;
//		int y = (screen.height - window.height) / 2;
//		// 윈도우 표시 위치 지정
//		frame.setLocation(x, y);
		frame.setLocationRelativeTo(null);
		// 윈도우를 표시
		frame.setVisible(true);
	}
}
