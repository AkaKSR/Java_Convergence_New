package scroll2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import javax.swing.JFrame;

public class LottoEx2 extends JFrame{
	LottoVScrollPanel[] panels = new LottoVScrollPanel[6];
	TreeSet<Integer> lotto = new TreeSet<>();
	Random r = new Random();
	
	public LottoEx2() {
		// 번호만듬
		while(lotto.size()<6) lotto.add(r.nextInt(45)+1);
		List<Integer> list = new ArrayList<>(lotto);
		
		setTitle("로또");
		setSize(500, 120);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 6));
		for(int i=0;i<panels.length;i++){
			panels[i] = new LottoVScrollPanel(i+1, i+1, list.get(i));
			add(panels[i]);
		}
	}

	public static void main(String[] args) {
		new LottoEx2().setVisible(true);
	}
}
