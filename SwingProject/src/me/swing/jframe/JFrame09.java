package me.swing.jframe;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JFrame09 extends JFrame implements WindowListener{
	private static final long serialVersionUID = -3252749292975764074L;

	// 생성자 작성
	public JFrame09() throws HeadlessException {
		super();
		createGUI();
	}
	public JFrame09(String title) throws HeadlessException {
		super(title);
		createGUI();
	}
	
	// 디자인 구성
	private void createGUI(){
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
		
		// 윈도우리스너 등록 : 자신이 인터페이스를 구현했음으로 this를 기술한다.
		addWindowListener(this);
	}

	// WindowListener 인터페이스 구현
	@Override
	public void windowActivated(WindowEvent e) { }
	@Override
	public void windowClosed(WindowEvent e) { }
	@Override
	public void windowClosing(WindowEvent e) { 
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		int choice = JOptionPane.showConfirmDialog(this, "정말 종료하시겠습니까?", "종료확인",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (choice == 0) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	@Override
	public void windowDeactivated(WindowEvent e) { }
	@Override
	public void windowDeiconified(WindowEvent e) { }
	@Override
	public void windowIconified(WindowEvent e) { }
	@Override
	public void windowOpened(WindowEvent e) { }

	// main메소드
	public static void main(String[] args) {
		JFrame09 win = new JFrame09("아홉번째 윈도우");
		win.setVisible(true);
	}
}
