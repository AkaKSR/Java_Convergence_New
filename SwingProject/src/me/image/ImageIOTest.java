package me.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/*
 * ImageIOMain.java 자바 1.4 ImageIO를 이용한 이미지 로딩
 * 자바 1.4에서는 이미지의 관리를 위해 ImageIO 클래스를 제공한다.
 */

public class ImageIOTest extends JFrame {
	BufferedImage bi = null;

	public ImageIOTest() {
		super("이미지 IO(이미지 저장)");
		try {
			bi = bufferedImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSize(330, 420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private BufferedImage bufferedImage() throws Exception {
		// 자바 1.4 ImageIO를 이용한 이미지 로딩
		File file = new File("images/Duke1.gif");
		BufferedImage bi = ImageIO.read(file);

		// 자바 1.4 ImageIO를 이용한 이미지 저장
		File file1 = new File("Duke.png");
		ImageIO.write(bi, "png", file1);

		File file2 = new File("Duke.gif");
		ImageIO.write(bi, "gif", file2);

		File file3 = new File("Duke.jpg");
		ImageIO.write(bi, "jpg", file3);

		return bi;
	}

	public void paint(Graphics g) {
		if (this.bi != null)
			g.drawImage(this.bi, 0, 20, this);
	}

	public static void main(String[] args) {
		new ImageIOTest();
	}
}