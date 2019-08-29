package me.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;

/*
 * ImageJFrameTest2.java
 * MediaTracker를 이용한 이미지 로딩 보장
 * 
 * MediaTracker는 이미지가 완전히 로딩되는 것을 보장하는 기능을 한다.
 */
class ImageJFrameTest3 extends JFrame {
	private Image img = null;
	private BufferedImage bi = null;
	
	public ImageJFrameTest3(URL url) {
		super("이미지 그리기");
		this.img = Toolkit.getDefaultToolkit().getImage(url);
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(img, 0);
		try {
			tracker.waitForAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int w = img.getWidth(null);
		int h = img.getHeight(null);
		// 로딩된 이미지를 BufferedImage에 그리기
		this.bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		g.drawImage(img, 0, 0, this);
		g.setColor(Color.BLUE);
		g.setFont(new Font("돋움체",Font.BOLD,25));
		g.drawString("HelloWorld", 20, 30);
		g.dispose();

		setSize(420, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void paint(Graphics g) {
		if (this.bi != null) {
			g.drawImage(bi, 50, 50, this);
		}
	}

	public static void main(String[] args) {
		try {
			new ImageJFrameTest3(
					new URL("http://img.naver.net/static/www/u/2013/0731/nmms_224940510.gif"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
