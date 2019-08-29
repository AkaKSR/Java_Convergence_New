package scroll;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class ScrollEx03{

	public static void main(String[] args) {
		JFrame f = new JFrame("이미지 스크롤");
		f.setSize(400, 400);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(1,6,20,20));
		f.add(new LottoVScrollPanel(100));
		f.add(new LottoVScrollPanel(70));
		f.add(new LottoVScrollPanel(30));
		f.add(new LottoVScrollPanel(80));
		f.add(new LottoVScrollPanel(10));
		f.add(new LottoVScrollPanel(20));
		f.setVisible(true);
	}
}
