package me.swing.jframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JFrame07 {
	public static void main(String[] args) {
		// DefaultLookAndFeel 지정
		JFrame.setDefaultLookAndFeelDecorated(true);
		// 프레임 생성
		final JFrame frame = new JFrame("일곱번째 윈도우");
		// 프레임 크기지정
		frame.setSize(400, 400);
		// 윈도우가 닫힐때 종료 확인하기
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				int choice = JOptionPane.showConfirmDialog(frame, "정말 종료하시겠습니까?", "종료확인",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (choice == 0) {
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		});

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
