package scroll;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;

public class LottoEx extends JFrame implements ActionListener {
	LottoHScrollPanel[] panels = new LottoHScrollPanel[6];
	public LottoEx() {
		setTitle("로또");
		setSize(400, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(6, 1));
		for(int i=0;i<panels.length;i++){
			panels[i] = new LottoHScrollPanel(new Random().nextInt(100)+1);
			add(panels[i]);
		}
		getContentPane().setBackground(Color.WHITE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new LottoEx().setVisible(true);
	}
}
