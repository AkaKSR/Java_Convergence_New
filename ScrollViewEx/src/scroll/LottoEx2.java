package scroll;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;

public class LottoEx2 extends JFrame implements ActionListener {
	LottoVScrollPanel[] panels = new LottoVScrollPanel[6];
	public LottoEx2() {
		setTitle("로또");
		setSize(500, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 6));
		for(int i=0;i<panels.length;i++){
			panels[i] = new LottoVScrollPanel(new Random().nextInt(100)+1);
			add(panels[i]);
		}
		getContentPane().setBackground(Color.WHITE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new LottoEx2().setVisible(true);
	}
}
