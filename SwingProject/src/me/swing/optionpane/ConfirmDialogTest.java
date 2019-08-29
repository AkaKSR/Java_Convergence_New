package me.swing.optionpane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConfirmDialogTest extends JFrame {
	private static final long serialVersionUID = 2823408205018317134L;
	JButton btn[];
	
	public ConfirmDialogTest() {
		super("ConfirmDialog 연습");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(7,1));
		
		btn = new JButton[7];
		
		btn[0] = new JButton("기본창(예/아니오/취소) - 부모 NULL");
		btn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "기본 확인창입니다.");
				btn[0].setText("기본창(예/아니오/취소) - 부모 NULL(" + "리턴값 : " + result +")");
			}
		});
		add(btn[0]);
		
		btn[1] = new JButton("기본창(예/아니오/취소) - 부모지정");
		btn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 부모 컴포너트 중앙에 표시 
				int result = JOptionPane.showConfirmDialog(btn[1], "기본 확인창입니다.");
				btn[1].setText("기본창(예/아니오/취소) - 부모지정(" + "리턴값 : " + result +")");
				switch(result){
				case 0:
					JOptionPane.showMessageDialog(btn[1],"예 버튼을 클릭했습니다.","확인"
							,JOptionPane.INFORMATION_MESSAGE);
					break;
				case 1:
					JOptionPane.showMessageDialog(btn[1],"아니오 버튼을 클릭했습니다.","확인"
							,JOptionPane.INFORMATION_MESSAGE);
					break;
				case 2:
					JOptionPane.showMessageDialog(btn[1],"취소 버튼을 클릭했습니다.","확인"
							,JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		});
		add(btn[1]);
		
		btn[2] = new JButton("DEFAULT_OPTION");
		btn[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(btn[2], "DEFAULT_OPTION", "제목",
											  JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
				btn[2].setText("DEFAULT_OPTION(" + "리턴값 : " + result +")");
			}
		});
		add(btn[2]);
		
		btn[3] = new JButton("YES_NO_CANCEL_OPTION");
		btn[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(btn[3], "YES_NO_CANCEL_OPTION", "제목",
											  JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				btn[3].setText("YES_NO_CANCEL_OPTION(" + "리턴값 : " + result +")");
				switch(result){
				case JOptionPane.YES_OPTION:
					JOptionPane.showMessageDialog(btn[1],"예 버튼을 클릭했습니다.","확인"
							,JOptionPane.INFORMATION_MESSAGE);
					break;
				case JOptionPane.NO_OPTION:
					JOptionPane.showMessageDialog(btn[1],"아니오 버튼을 클릭했습니다.","확인"
							,JOptionPane.INFORMATION_MESSAGE);
					break;
				case JOptionPane.CANCEL_OPTION:
					JOptionPane.showMessageDialog(btn[1],"취소 버튼을 클릭했습니다.","확인"
							,JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		});
		add(btn[3]);
		
		btn[4] = new JButton("YES_NO_OPTION");
		btn[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(btn[4], "YES_NO_OPTION", "제목",
											  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				btn[4].setText("YES_NO_OPTION(" + "리턴값 : " + result +")");
			}
		});
		add(btn[4]);
		
		btn[5] = new JButton("OK_CANCEL_OPTION");
		btn[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(btn[5], "OK_CANCEL_OPTION", "제목",
											  JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				btn[5].setText("OK_CANCEL_OPTION(" + "리턴값 : " + result +")");
				switch(result){
				case JOptionPane.OK_OPTION:
					JOptionPane.showMessageDialog(btn[1],"확인 버튼을 클릭했습니다.","확인"
							,JOptionPane.INFORMATION_MESSAGE);
					break;
				case JOptionPane.CANCEL_OPTION:
					JOptionPane.showMessageDialog(btn[1],"취소 버튼을 클릭했습니다.","확인"
							,JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		});
		add(btn[5]);
		
		btn[6] = new JButton("OK_CANCEL_OPTION(사용자아이콘)");
		btn[6].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("icon/java.png");
				int result = JOptionPane.showConfirmDialog(btn[6], "OK_CANCEL_OPTION", "제목",
											  JOptionPane.OK_CANCEL_OPTION, 
											  JOptionPane.WARNING_MESSAGE,
											  icon);
				btn[6].setText("OK_CANCEL_OPTION(" + "리턴값 : " + result +")");
			}
		});
		add(btn[6]);
		
		setVisible(true);
	}
		
	public static void main(String[] args) {
		new ConfirmDialogTest();
	}
}
