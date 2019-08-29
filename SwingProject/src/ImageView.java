import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImageView extends JPanel{
	Image img;
	int width=55, height=68;
	public ImageView() {
		img = Toolkit.getDefaultToolkit().getImage("images/Duke2.gif"); // 그림읽기
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0,0,this);// 0,0위치에 그리기
		// 그림, 나타날 좌표, 원본의 좌표
		g.drawImage(img, width, 0, width*2, height, 0, 0, width, height, this);
		// 좌우뒤집기
		g.drawImage(img, width*2, 0, width*3, height, width, 0, 0, height, this);
		// 위아래 뒤집기
		g.drawImage(img, width*3, 0, width*4, height, 0, height, width, 0, this);
		// 상하좌우뒤집기
		g.drawImage(img, width*4, 0, width*5, height, width, height, 0, 0, this);
		// 4배 확대
		g.drawImage(img, width*5, 0, width*7, height*2, 0, 0, width, height, this);
		// 4배 축소
		g.drawImage(img, width*7, 0, width*7+width/2, height/2, 0, 0, width, height, this);
	}
	public static void main(String[] args) {
		final Frame f = new Frame("그림 그리기");
		f.setSize(500, 500);
		ImageView me = new ImageView(); // 자신의 객체를 생성
		f.add(me);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
                JOptionPane.showConfirmDialog (f, "정말 종료 하시겠습니까?","종료확인",dialogButton);
                if(dialogButton == JOptionPane.YES_OPTION){
                	System.exit(0);
                }else if(dialogButton == JOptionPane.NO_OPTION){
                	return;
                }
			}
		});
		f.setVisible(true);
	}
}
