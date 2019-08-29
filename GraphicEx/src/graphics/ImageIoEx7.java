package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageIoEx7 extends JPanel implements Runnable, MouseListener{
	Image[] images = new Image[8];
	Image   bgImage;
	int width, height, nowx=10,nowy=10, index=0;
	boolean flag = true;
	public ImageIoEx7() {
		try {
			images[0] = ImageIO.read(new File("ship2_1.png"));
			images[1] = ImageIO.read(new File("ship2_2.png"));
			images[2] = ImageIO.read(new File("ship2_3.png"));
			images[3] = ImageIO.read(new File("ship2_4.png"));
			images[4] = ImageIO.read(new File("ship2_hit_1.png"));
			images[5] = ImageIO.read(new File("ship2_hit_2.png"));
			images[6] = ImageIO.read(new File("ship2_hit_3.png"));
			images[7] = ImageIO.read(new File("ship2_hit_4.png"));
			bgImage = ImageIO.read(new File("background_a.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		width = images[0].getWidth(this);
		height = images[0].getHeight(this);
		
		// 마우스 리스너 등록
		addMouseListener(this);
		
		Thread thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();
	}	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bgImage, 0, 0, null);
		g.drawImage(images[index], nowx, nowy, null);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("날아라 비행기");
		frame.setSize(1500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIoEx7 panel = new ImageIoEx7();
		frame.add(panel);
		frame.setVisible(true);
	}
	@Override
	public void run() {
		int cnt=0;
		while(true){
			if(flag){
				index = ++index%4; // 0,1,2,3 반복
			}else{
				index = ++index%4 + 4; // 4,5,6,7 반복
				if(++cnt==4){ // 1번만
					flag = true; // 원래대로
					cnt = 0; // 다음번을 위해 카운트를 0으로
				}
			}
			nowx++;
			try { Thread.sleep(50); } catch (InterruptedException e) {;}
			repaint();
		}
	}

	// 마우스 리스너 구현
	@Override
	public void mouseClicked(MouseEvent e) {
		flag = false;
	}
	@Override
	public void mousePressed(MouseEvent e) { }
	@Override
	public void mouseReleased(MouseEvent e) { }
	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) { }
}
