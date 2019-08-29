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

public class ImageIOTest2 extends JFrame {
	BufferedImage bi = null;
	int w = 870/4;
	int h = 639/3;

	public ImageIOTest2() {
		super("이미지 IO(이미지 분리)");
		try {
			// 자바 1.4 ImageIO를 이용한 이미지 로딩
			File ofile = new File("all.jpg");
			BufferedImage original = ImageIO.read(ofile);

			//로딩된 이미지를 BufferedImage에 그리기
			int count=0;
			for(int i=0;i<3;i++){
				for(int j=0;j<4;j++){
			        bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			        Graphics g = bi.getGraphics();
			        g.drawImage(original, 0, 0, w,h,w*j,h*i,w*(j+1),h*(i+1),this);
			        g.dispose();
					// 자바 1.4 ImageIO를 이용한 이미지 저장
					File file = new File(++count + ".jpg");
					ImageIO.write(bi, "jpg", file);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSize(330, 420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void paint(Graphics g) {
		if (bi != null)
			g.drawImage(bi, 0, 0, this);
	}

	public static void main(String[] args) {
		new ImageIOTest2();
	}
}