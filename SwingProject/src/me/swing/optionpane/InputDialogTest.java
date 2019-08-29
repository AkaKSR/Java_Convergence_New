package me.swing.optionpane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InputDialogTest extends JFrame {
	private static final long serialVersionUID = 2823408205018317134L;
	JButton btn[];
	
	public InputDialogTest() {
		super("InputDialog 연습");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,3));
		
		btn = new JButton[6];
		
		btn[0] = new JButton("기본 입력창 - 부모 NULL");
		btn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = JOptionPane.showInputDialog(null, "기본 입력창입니다.");
				btn[0].setText("기본 입력창 - 부모 NULL(" + "리턴값 : " + result +")");
			}
		});
		add(btn[0]);
		
		btn[1] = new JButton("기본 입력창 - 부모지정");
		btn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 부모 컴포너트 중앙에 표시 
				String result = JOptionPane.showInputDialog(btn[1], "기본 입력창입니다.");
				btn[1].setText("기본 입력창 - 부모지정(" + "리턴값 : " + result +")");
			}
		});
		add(btn[1]);
		
		btn[2] = new JButton("기본 입력창 - 초기값 지정");
		btn[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = JOptionPane.showInputDialog(btn[2], "이름을 입력하세요","홍길동");
				btn[2].setText("기본 입력창 - 초기값 지정(" + "리턴값 : " + result +")");
			}
		});
		add(btn[2]);
		
		btn[3] = new JButton("콤보박스로 값 선택1");
		btn[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] selections = {"첫번째값", "두번째값", "세번째값"};
				Object result = JOptionPane.showInputDialog(btn[3], 
						     "selectionValues를 이용해서\n선택창으로 만들어봅니다.", 
						     "값선택", 
						     JOptionPane.QUESTION_MESSAGE,
						     null,
						     selections,
						     selections[0]);
				btn[3].setText("콤보박스로 값 선택1(" + "리턴값 : " + result +")");
			}
		});
		add(btn[3]);
		
		btn[4] = new JButton("콤보박스로 값 선택2");
		btn[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer[] selections = {10,20,30,40};
				Object result = JOptionPane.showInputDialog(btn[4], 
						     "selectionValues를 이용해서\n선택창으로 만들어봅니다.", 
						     "연령대 선택", 
						     JOptionPane.QUESTION_MESSAGE,
						     null,
						     selections,
						     selections[0]);
				btn[4].setText("콤보박스로 값 선택2(" + "리턴값 : " + result +"대)");
			}
		});
		add(btn[4]);
		
		btn[5] = new JButton("사용자정의 아이콘");
		btn[5].setIcon(new ImageIcon("images/s1.jpg"));
		btn[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon[] = new ImageIcon[12];
				for(int i=0;i<icon.length;i++){
					icon[i] = new ImageIcon("images/s"+(i+1)+".jpg");
				}
				String selections[] = {"자","축","인","묘","진","사",
						               "오","미","신","유","술","해"};
				Object result = JOptionPane.showInputDialog(btn[5], 
						     "selectionValues를 이용해서\n선택창으로 만들어봅니다.", 
						     "값선택", 
						     JOptionPane.QUESTION_MESSAGE,
						     icon[0],
						     selections,
						     selections[0]);
				btn[5].setText("콤보박스로 값 선택1(" + "리턴값 : " + result +")");
				ImageIcon temp=null;
				switch(result.toString()){
				case "자": temp = icon[0]; break;
				case "축": temp = icon[1]; break;
				case "인": temp = icon[2]; break;
				case "묘": temp = icon[3]; break;
				case "진": temp = icon[4]; break;
				case "사": temp = icon[5]; break;
				case "오": temp = icon[6]; break;
				case "미": temp = icon[7]; break;
				case "신": temp = icon[8]; break;
				case "유": temp = icon[9]; break;
				case "술": temp = icon[10]; break;
				case "해": temp = icon[11]; break;
				}
				btn[5].setIcon(temp);
			}
		});
		add(btn[5]);
		
		setVisible(true);
	}
		
	public static void main(String[] args) {
		new InputDialogTest();
	}
}
