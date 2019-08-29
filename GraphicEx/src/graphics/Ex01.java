package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex01 extends JFrame {
	int width, height;
	public Ex01() {
		setTitle("그래픽");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//add(new GraphicPanel());
		add(new Board());
	}
	class GraphicPanel extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			setBackground(Color.WHITE);
			g.setColor(Color.RED);
			g.drawLine(0, 0, 100, 100);
			g.setColor(Color.BLUE);
			g.drawOval(50, 50, 60, 60);
			g.fillArc(100, 100, 50, 50, 45, 300);
			g.setColor(Color.YELLOW);
			g.fillOval(120, 110, 10, 10);
		}
	}
	public static void main(String[] args) {
		new Ex01().setVisible(true);
	}
	
	class Board extends JPanel {
		private BufferedImage image;
		public Board() {
			try {
				image = ImageIO.read(new File("img2.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void paint(Graphics g) {
			g.drawImage(image, 0, 0, null);
		}
	}
	
}
