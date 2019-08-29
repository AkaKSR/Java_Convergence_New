package scroll;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class ScrollEx02{

	public static void main(String[] args) {
		JFrame f = new JFrame("이미지 스크롤");
		f.setSize(400, 400);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(2, 3,20,20));
		f.add(new LottoHScrollPanel(100));
		f.add(new LottoHScrollPanel(70));
		f.add(new LottoHScrollPanel(30));
		f.add(new LottoHScrollPanel(80));
		f.add(new LottoHScrollPanel(10));
		f.add(new LottoHScrollPanel(20));
		f.setVisible(true);
	}
}
