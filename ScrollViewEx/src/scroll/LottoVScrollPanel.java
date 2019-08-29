package scroll;

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

public class LottoVScrollPanel extends JPanel{
	private static final long serialVersionUID = 5288297416030267803L;
	private static Image sourceImage;
	public static int imageWidth,imageHeight;
	private int nowy=0, height1, height2=1;
	static{
		try {
			sourceImage = ImageIO.read(new File("images/lotto_ball_vert.jpg"));
			imageWidth = sourceImage.getWidth(null);
			imageHeight = sourceImage.getHeight(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public LottoVScrollPanel(int speed) {
		System.out.println(speed/10);
		height1 = imageHeight/45;
		new Timer(speed/10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                 nowy++ ;
                if(nowy>imageHeight/45*44){// 마지막 끝그림까지 갔다면
                    height1 = imageHeight - nowy;
                    height2 = imageHeight/45 - height1;
                    if(nowy>=imageHeight){// 끝까지 갔다면 다시 처음
                        nowy = 0;
                        height1 = imageHeight/45;
                        height2 = 0;
                    }
                }
                repaint();
			}
		}).start();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		BufferedImage bi = new BufferedImage(imageWidth, imageHeight/45, BufferedImage.TYPE_INT_RGB);
		Graphics g2 = bi.getGraphics(); // 그래픽 객체 얻기
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, imageWidth, imageHeight/45);
		// 이미지에 원본이미지를 잘라서 그리기
        // 첫번째 그림 출력
        g2.drawImage(sourceImage, 0, 0, imageWidth, height1, 
        		                  0, nowy, imageWidth, nowy+height1,this);
        // 두번째 그림 출력
        g2.drawImage(sourceImage,0, height1, imageWidth, height1+height2, 
        		                  0,0,imageWidth,height2,this);
		// 완성된 그림 그리기
		g.drawImage(bi, 0, 0, this);
	}
}
