package scroll2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class LottoEx extends JFrame implements ActionListener {
	LottoVScrollPanel[] panels = new LottoVScrollPanel[6];
	public LottoEx() {
		setTitle("로또");
		setSize(500, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new LottoVScrollPanel(1,2,4));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new LottoEx().setVisible(true);
	}
}
