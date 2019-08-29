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

public class ImageIoEx1 extends JPanel{
	Image[] images = new Image[8]; 
	int width, height;
	public ImageIoEx1() {
		try {
			images[0] = ImageIO.read(new File("ship2_1.png"));
			images[1] = ImageIO.read(new File("ship2_2.png"));
			images[2] = ImageIO.read(new File("ship2_3.png"));
			images[3] = ImageIO.read(new File("ship2_4.png"));
			images[4] = ImageIO.read(new File("ship2_hit_1.png"));
			images[5] = ImageIO.read(new File("ship2_hit_2.png"));
			images[6] = ImageIO.read(new File("ship2_hit_3.png"));
			images[7] = ImageIO.read(new File("ship2_hit_4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		width = images[0].getWidth(null);
		height = images[0].getHeight(null);
		System.out.println(width + ", " + height);
		// 그림 크기가 (폭*8개, 높이)
		BufferedImage bi = new BufferedImage(width*images.length, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics(); // 그래픽 객체 얻기
		g.setColor(Color.WHITE); // 흰색
		g.fillRect(0, 0, width*images.length, height); // 배경을 희색 사각형으로 그리고
		for(int i=0;i<images.length;i++){
			g.drawImage(images[i], i*width, 10, this); // 그림을 좌표를 바꿔거면서 그리기
		}
		try {
			ImageIO.write(bi, "png", new File("ships.png")); // 완성된 그림을 저장
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(int i=0;i<images.length;i++){
			g.drawImage(images[i], i*width, 10, null);
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("이미지 합치기");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIoEx1 panel = new ImageIoEx1();
		frame.add(panel);
		frame.setVisible(true);
	}
	
}
