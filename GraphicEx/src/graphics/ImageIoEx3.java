package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageIoEx3 extends JPanel {
	int width, height, row = 1, col = 53;
	Image[] images = new Image[row * col]; // 이미지를 저장할 배열
	int[] game = new int[52]; // 섞인 숫자가 저장될 배열
	Image srcImage;

	public ImageIoEx3() {
		try {
			srcImage = ImageIO.read(new File("cards.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 카드 1장의 이미지크기
		width = srcImage.getWidth(null) / col;
		height = srcImage.getHeight(null) / row;
		for(int i=0;i<images.length;i++){
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = bi.getGraphics(); // 그래픽 객체 얻기
			// 이미지에 원본이미지를 잘라서 그리기
			g.drawImage(srcImage, 0, 0, width, height, width * i, 0, width * (i + 1), height, this);	
			// 배열에 이미지 넣기
			images[i] = bi;	
		}
		// 배열의 숫자를 섞어보자
		Random rnd = new Random();
		int t;
		for(int i=0;i<game.length;i++){
			do{
				t = rnd.nextInt(game.length);
			}while(game[t]!=0);
			game[t] = i;
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		/*
		int row=0, col=0;
		for(int i=0;i<game.length;i++){
			g.drawImage(images[game[i]], col*(width + 10)+10, row * (height + 10)+10, this);
			col++;
			if((i+1)%13==0) {
				row++;
				col=0;
			}
		}
		*/
		// 플레이어 1
		int row=0, col=0, index=0;
		for(int i=0;i<7;i++){
			g.drawImage(images[game[index++]], col*(width + 10)+10, row * (height + 10)+10, this);
			col++;
		}
		// 플레이어 2
		row = 2; col=0;
		for(int i=0;i<7;i++){
			g.drawImage(images[game[index++]], col*(width + 10)+10, row * (height + 10)+10, this);
			col++;
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("카드를 섞어보자!!!");
		frame.setSize(1200, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIoEx3 panel = new ImageIoEx3();
		frame.add(panel);
		frame.setVisible(true);
	}

}
