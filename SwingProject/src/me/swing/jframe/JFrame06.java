package me.swing.jframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class JFrame06 {
	public static void main(String[] args) {
		// DefaultLookAndFeel 지정
		JFrame.setDefaultLookAndFeelDecorated(true);
		// 프레임 생성
		JFrame frame = new JFrame("여섯번째 윈도우");
		// 프레임 크기지정
		frame.setSize(400, 400);
		// 윈도우가 닫힐때 프로그램이 종료된다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 해상도 구하기
		Toolkit toolKit = frame.getToolkit();
		Dimension screenSize = toolKit.getScreenSize();
		// 윈도우 크기 구하기
		Dimension windowSize = frame.getSize();
		// 화면 중앙에 배치하기 위하여 위치값 계산
		int x = (screenSize.width - windowSize.width) / 2;
		int y = (screenSize.height - windowSize.height) / 2;
		// 윈도우 표시 위치 지정
		frame.setLocation(x, y);

		// 윈도우 배경색 변경
		// frame.setBackground(Color.red);
		frame.getContentPane().setBackground(Color.CYAN);
		// 윈도우 크기 변경 금지
		frame.setResizable(false);

		// 윈도우를 표시
		frame.setVisible(true);
	}
}
