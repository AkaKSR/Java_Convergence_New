package me.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImgScroll extends JFrame implements Runnable{
	private static final long serialVersionUID = -7041435529546956978L;
	BufferedImage original = null;
	int w = 870/4;
	int h = 639/3;
	int play[];
	public ImgScroll() {
		super("이미지 IO(이미지 스크롤)");
		try {
			// 자바 1.4 ImageIO를 이용한 이미지 로딩
			File ofile = new File("ganji.jpg");
			original = ImageIO.read(ofile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		play = new int[5];
		Random rnd = new Random();
		for(int i=0;i<play.length;i++){
			play[i] = rnd.nextInt(h*12);
		}
		
		setSize(w*5, h*3);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void paint(Graphics g) {
		if (original != null){
			for(int i=0;i<play.length;i++){
				if(play[i]<=h*11){
					g.drawImage(original, i*w,  0, w*(i+1),h, 0,play[i],w,play[i]+h,this);
				}else{
					g.drawImage(original, i*w,  0, w*(i+1), (h*12-play[i]), 
							              0,    play[i], w, play[i]+(h*12-play[i]),this);
					g.drawImage(original, i*w,  (h*12-play[i]),  w*(i+1), h, 
							              0,    0, w, h-(h*12-play[i]),this);
				}
			}
		}
	}

	public static void main(String[] args) {
		ImgScroll scroll = new ImgScroll();
		Thread thread = new Thread(scroll);
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void run() {
		while(true){
			for(int i=0;i<play.length;i++){
				play[i] += 3;
				if(play[i]>=h*12) play[i] = 0;
				
			}
			try { Thread.sleep(10); } catch (InterruptedException e) { ; }
			repaint();
		}
	}
}
