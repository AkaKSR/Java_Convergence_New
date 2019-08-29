package scroll2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LottoHScrollPanel extends JPanel{
	private static final long serialVersionUID = 5288297416030267803L;
	private static Image sourceImage;
	public static int imageWidth,imageHeight;
	private int nowx=0, width1, width2=1;
	static{
		try {
			sourceImage = ImageIO.read(new File("images/lotto_ball_horz.jpg"));
			imageWidth = sourceImage.getWidth(null);
			imageHeight = sourceImage.getHeight(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public LottoHScrollPanel(int speed) {
		System.out.println(speed/10);
		width1 = imageWidth/45;
		new Timer(speed/10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                 nowx++ ;
                if(nowx>imageWidth/45*44){// 마지막 끝그림까지 갔다면
                    width1 = imageWidth - nowx;
                    width2 = imageWidth/45 - width1;
                    if(nowx==imageWidth){// 끝까지 갔다면 다시 처음
                        nowx = 0;
                        width1 = imageWidth/45;
                        width2 = 0;
                    }
                }
                repaint();
			}
		}).start();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		BufferedImage bi = new BufferedImage(imageWidth/45, imageHeight, BufferedImage.TYPE_INT_RGB);
		Graphics g2 = bi.getGraphics(); // 그래픽 객체 얻기
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, imageWidth/45, imageWidth);
		// 이미지에 원본이미지를 잘라서 그리기
        // 첫번째 그림 출력
        g2.drawImage(sourceImage, 0, 0, width1, imageHeight, nowx, 0, nowx+width1, imageHeight,this);
        // 두번째 그림 출력
        g2.drawImage(sourceImage, width1, 0, width1+width2, imageHeight, 0,0,width2,imageHeight,this);
		// 완성된 그림 그리기
		g.drawImage(bi, 0, 0, this);
	}
}
