package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageIoEx2 extends JPanel {
	int width, height, row = 5, col = 13;
	Image[] images = new Image[row * col];
	Image srcImage;

	public ImageIoEx2() {
		try {
			srcImage = ImageIO.read(new File("Deck.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 카드 1장의 이미지크기
		width = srcImage.getWidth(null) / col;
		height = srcImage.getHeight(null) / row;
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// 이미지 만들기
				BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics g = bi.getGraphics(); // 그래픽 객체 얻기
				// 이미지에 원본이미지를 잘라서 그리기
				g.drawImage(srcImage, 0, 0, width, height, width * j, height * i, width * (j + 1), height * (i + 1),
						this);
				// 배열에 이미지 넣기
				images[count] = bi;
				try {
					ImageIO.write(bi, "gif", new File("card\\" + count + ".gif"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				count++;
			}

		}
		// 잘라진 이미지를 합쳐보자...... 0~51번과 57번을 합쳐보자.
		// 합쳐진 크기의 이미지를 만들자...
		BufferedImage bi = new BufferedImage(width * 53, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		for (int i = 0; i < 52; i++) {
			// 배열에 있는 이미지를 그리자
			g.drawImage(images[i],width*i,0,this);
		}
		// 57번 이미지 그리기
		g.drawImage(images[57],width*52,0,this);
		try {
			ImageIO.write(bi, "gif", new File("cards.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("이미지 자르기");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIoEx2 panel = new ImageIoEx2();
		frame.add(panel);
		frame.setVisible(true);
	}

}
