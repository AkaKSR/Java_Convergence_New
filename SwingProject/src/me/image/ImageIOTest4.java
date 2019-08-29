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

public class ImageIOTest4 extends JFrame {
	private static final long serialVersionUID = -2076255023329860372L;
	BufferedImage img[];
	BufferedImage bi = null;
	int w = 870/4;
	int h = 639/3;

	public ImageIOTest4() {
		super("이미지 IO(가로로 이미지 결합)");
		try {
			// 자바 1.4 ImageIO를 이용한 이미지 로딩
			img = new BufferedImage[12];
			for(int i=0;i<12;i++){
				File ofile = new File("images/s"+(i+1)+".jpg");
				img[i] = ImageIO.read(ofile);
			}

			//로딩된 이미지를 BufferedImage에 그리기
	        bi = new BufferedImage(w*12, h, BufferedImage.TYPE_INT_RGB);
	        Graphics g = bi.getGraphics();
	        for(int i=0;i<12;i++){
	        	g.drawImage(img[i], w*i, 0 ,this);
	        }
	        g.dispose();
			// 자바 1.4 ImageIO를 이용한 이미지 저장
			File file = new File("ganji2.jpg");
			ImageIO.write(bi, "jpg", file);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSize(w*4, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void paint(Graphics g) {
		if (bi != null)
			g.drawImage(bi, 0, 0, this);
	}

	public static void main(String[] args) {
		new ImageIOTest4();
	}
}