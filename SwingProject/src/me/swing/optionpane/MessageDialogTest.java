package me.swing.optionpane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MessageDialogTest extends JFrame {
	private static final long serialVersionUID = 2823408205018317134L;
	JButton btn[];
	
	public MessageDialogTest() {
		super("MessageDialog 연습");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(8,1));
		
		btn = new JButton[8];
		
		btn[0] = new JButton("기본창 - 부모 NULL");
		btn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// showMessageDialog( 부모컴포넌트, 메세지 )
				// 부모 컴포너트가 null이면 운영체제가 부모가 되어 화면 중앙에 표시 
				JOptionPane.showMessageDialog(null, "기본 알림창(Information Icon)");
			}
		});
		add(btn[0]);
		btn[1] = new JButton("기본창 - 부모지정");
		btn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 부모 컴포너트 중앙에 표시 
				JOptionPane.showMessageDialog(btn[1], "기본 알림창(Information Icon)");
			}
		});
		add(btn[1]);
		
		btn[2] = new JButton("경고 아이콘");
		btn[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btn[2], "경고 메시지 내용(WARNING_MESSAGE Icon)", 
						"경고 메시지 제목", JOptionPane.WARNING_MESSAGE);
			}
		});
		add(btn[2]);
		
		btn[3] = new JButton("에러 아이콘");
		btn[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btn[3], "오류 메시지 내용(ERROR_MESSAGE Icon)", 
						"오류 메시지 제목", JOptionPane.ERROR_MESSAGE);
			}
		});
		add(btn[3]);
		
		btn[4] = new JButton("아이콘 없음");
		btn[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btn[4], "아이콘 없는 메시지 내용(PLAIN_MESSAGE)", 
						"아이콘 없는 메시지 제목", JOptionPane.PLAIN_MESSAGE);
			}
		});
		add(btn[4]);
		
		btn[5] = new JButton("안내 아이콘");
		btn[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btn[5], "정보 메시지 내용(INFORMATION_MESSAGE Icon)", 
						"정보 메시지 제목", JOptionPane.INFORMATION_MESSAGE);			}
		});
		add(btn[5]);
		
		btn[6] = new JButton("질문 아이콘");
		btn[6].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btn[6], "질문 메시지 내용(QUESTION_MESSAGE Icon)", 
						"질문 메시지 제목", JOptionPane.QUESTION_MESSAGE);		
			}
		});
		add(btn[6]);
		
		btn[7] = new JButton("사용자 아이콘");
		btn[7].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("icon/java.png");
				JOptionPane.showMessageDialog(btn[7], "사용자 메시지 내용(사용자 아이콘)", 
						"사용자 메시지 제목", JOptionPane.QUESTION_MESSAGE,icon);		
			}
		});
		add(btn[7]);
		
		setVisible(true);
	}
		
	public static void main(String[] args) {
		new MessageDialogTest();
	}
}
