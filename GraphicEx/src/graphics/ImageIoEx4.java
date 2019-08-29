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

public class ImageIoEx4 extends JPanel {
	int width, height, row = 13, col = 4;
	Image[] images = new Image[row * col];
	Image srcImage;

	public ImageIoEx4() {
		try {
			srcImage = ImageIO.read(new File("Gostop.jpg"));
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
					ImageIO.write(bi, "jpg", new File("gostop\\" + count + ".jpg"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				count++;
			}

		}
		// 잘라진 이미지를 합쳐보자...... 화투이미지
		// 합쳐진 크기의 이미지를 만들자...
		BufferedImage bi = new BufferedImage(width * row * col, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		int go[] = {3,2,1,0,7,6,5,4,11,10,9,8,15,14,13,12,19,18,17,16,23,22,21,20,27,26,25,24,
				    31,30,29,28,35,34,33,32,39,38,37,36,43,42,41,40,47,46,45,44,51,50,49,48};
		for (int i = 0; i < 52; i++) {
			// 배열에 있는 이미지를 그리자
			g.drawImage(images[go[i]],width*i,0,this);
		}
		try {
			ImageIO.write(bi, "png", new File("gostop.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 잘라진 이미지를 합쳐보자..... 섯다 이미지
		// 합쳐진 크기의 이미지를 만들자...
		BufferedImage bi2 = new BufferedImage(width * 20, height, BufferedImage.TYPE_INT_RGB);
		Graphics g2 = bi2.getGraphics();
		int stop[] = {3,2,7,6,11,10,15,14,19,18,23,22,27,26,31,30,35,34,39,38};
		for (int i = 0; i < 20; i++) {
			// 배열에 있는 이미지를 그리자
			g2.drawImage(images[stop[i]],width*i,0,this);
		}
		try {
			ImageIO.write(bi2, "png", new File("stop.png"));
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
		ImageIoEx4 panel = new ImageIoEx4();
		frame.add(panel);
		frame.setVisible(true);
	}

}
