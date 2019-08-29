package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageIoEx8 extends JPanel implements Runnable , KeyListener{
	int width, height,row = 8, col = 12;
	Image[] images = new Image[row*col]; // 이미지를 저장할 배열
	Image[] game = new Image[24]; // 이미지를 저장할 배열
	Image srcImage;
	
	//  나타날 좌표,      반전,         이미지번호 방향         캐릭터 위치
	int nowx=30, nowy=30, swx=1, swy=1, step = 0, orientation=0,ss=0; 
	boolean flag = true; //좌우인지 위아래인지 판단
	
	public ImageIoEx8() {
		setBackground(Color.WHITE);
		try {
			srcImage = ImageIO.read(new File("spriteImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 캐릭터 1개의 이미지크기
		width = srcImage.getWidth(null) / col;
		height = srcImage.getHeight(null) / row;
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// 이미지 만들기
				BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics g = bi.getGraphics(); // 그래픽 객체 얻기
				// 이미지에 원본이미지를 잘라서 그리기
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, width, height);
				g.drawImage(srcImage, 0, 0, width, height, 
						              width * j, height * i, width * (j + 1), height * (i + 1),this);
				// 배열에 이미지 넣기
				images[count++] = bi;
			}
		}
		// 캐릭터 2명만 배열에 따로 저장
		int index=0;
		for(int i=0;i<images.length;i++){
			if(i%12<3){
				game[index++] = images[i];
			}
		}
		
		// 스레드 시작
		Thread thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		/*
		for(int i=0;i<game.length;i++){
			g.drawImage(game[i], width*(i+10)+20, 10, this);
		}
		*/
		g.drawImage(game[step+orientation+ss], nowx, nowy, this);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("케릭터를 움직여 보자!!");
		frame.setSize(1200, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIoEx8 panel = new ImageIoEx8();
		
		frame.addKeyListener(panel); // 키 리스너 지정

		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void run() {
		while(true){
			step = ++step%3; // 0,1,2,0,1,2,....
			if(flag) 
				nowy += swy; // y값만
			else
				nowx += swx; // x값만
			try { Thread.sleep(100); } catch (InterruptedException e) { ; }
			repaint();
		}
	}

	// 키리스너 구현
	@Override
	public void keyTyped(KeyEvent e) { // 입력될때
	}
	@Override
	public void keyPressed(KeyEvent e) { // 눌릴때
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			orientation = 9;
			swy = -1;
			flag=true;
			break;
		case KeyEvent.VK_DOWN:
			orientation = 0;
			swy = 1;
			flag=true;
			break;
		case KeyEvent.VK_LEFT:
			orientation = 3;
			swx = -1;
			flag=false;
			break;
		case KeyEvent.VK_RIGHT:
			orientation = 6;
			swx = 1;
			flag=false;
			break;
		case KeyEvent.VK_SPACE:
			// 다음 캐릭터가 12번째있다.
			if(ss==0)
				ss=12;
			else
				ss=0;
			break;
		default:
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) { // 눌렀다 뗄때
		
	}

}
