package me.swing.jlabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class JLabelTest01 extends JFrame {
	private static final long serialVersionUID = -7623922363619096433L;

	// 생성자 작성
	public JLabelTest01() throws HeadlessException {
		super();
		createGUI();
	}

	public JLabelTest01(String title) throws HeadlessException {
		super(title);
		createGUI();
	}

	// 디자인 구성
	private void createGUI() {
		setSize(400, 400);
		// 해상도 구하기
		Toolkit toolKit = getToolkit();
		Dimension screenSize = toolKit.getScreenSize();
		// 윈도우 크기 구하기
		Dimension windowSize = getSize();
		// 화면 중앙에 배치하기 위하여 위치값 계산
		int x = (screenSize.width - windowSize.width) / 2;
		int y = (screenSize.height - windowSize.height) / 2;
		// 윈도우 표시 위치 지정
		setLocation(x, y);
		
		// 레이아웃지정
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// 라벨작성
		JLabel label = new JLabel("나는 JLabel입니다.");
		Border border = new TitledBorder("JLabel 연습");
		label.setBorder(border);
		label.setToolTipText("나는 풍선도움말입니다.");
		label.setForeground(Color.BLUE);
		add(label);
		
		// 윈도우 종료 지정
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new JLabelTest01("JLabel 연습하기1").setVisible(true);;
            }
        });
		
	}
}
