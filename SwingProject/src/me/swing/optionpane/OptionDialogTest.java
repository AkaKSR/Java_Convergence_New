package me.swing.optionpane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OptionDialogTest extends JFrame {
	private static final long serialVersionUID = 2823408205018317134L;
	JButton btn[];
	
	public OptionDialogTest() {
		super("OptionDialog 연습");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		
		btn = new JButton[3];
		
		btn[0] = new JButton("기본 사용자정의창 - 부모 NULL");
		btn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] buttons = {"첫번째값", "두번째값", "세번째값"};
				int result = JOptionPane.showOptionDialog(null, 
						     "options를 이용해서\n버튼을 여러개 만들어봅니다.", 
						     "제목표시줄", 
						     JOptionPane.YES_NO_CANCEL_OPTION, 
						     JOptionPane.QUESTION_MESSAGE, 
						     null, 
						     buttons, 
						     "두번째값");	
				btn[0].setText("기본 사용자정의창 - 부모지정(" + "리턴값 : " + buttons[result] +")");
			}
			
		});
		add(btn[0]);
		
		btn[1] = new JButton("기본 입력창 - 부모지정");
		btn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 부모 컴포너트 중앙에 표시 
				String[] buttons = {"일", "이", "삼","사","오"};
				int result = JOptionPane.showOptionDialog(btn[1], 
						     "options를 이용해서\n버튼을 여러개 만들어봅니다.", 
						     "제목표시줄", 
						     JOptionPane.OK_CANCEL_OPTION, 
						     JOptionPane.QUESTION_MESSAGE, 
						     null, 
						     buttons, 
						     "삼");	
				btn[1].setText("기본 사용자정의창 - 부모지정(" + "리턴값 : " + buttons[result] +")");
			}
		});
		add(btn[1]);
		
		btn[2] = new JButton("기본 입력창 - 초기값 지정");
		btn[2].setIcon(new ImageIcon("images/s1.jpg"));
		btn[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon[] = new ImageIcon[12];
				for(int i=0;i<icon.length;i++){
					icon[i] = new ImageIcon("images/s"+(i+1)+".jpg");
				}
				String selections[] = {"자","축","인","묘","진","사","오","미","신","유","술","해"};
				int result = JOptionPane.showOptionDialog(btn[1], 
					     "options를 이용해서\n버튼을 여러개 만들어봅니다.", 
					     "제목표시줄", 
					     JOptionPane.OK_CANCEL_OPTION, 
					     JOptionPane.QUESTION_MESSAGE, 
					     icon[3], 
					     selections, 
					     "묘");	
				btn[1].setText("기본 사용자정의창 - 부모지정(" + "리턴값 : " + selections[result] +")");
				btn[2].setIcon(icon[result]);
			}
		});
		add(btn[2]);
		
		setVisible(true);
	}
		
	public static void main(String[] args) {
		new OptionDialogTest();
	}
}
