package graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveOval extends JFrame implements Runnable{
	int width, height, nowX,nowY,swx=1,swy=1;
	MovePanel mv;
	public MoveOval() {
		setTitle("튕겨라공!!!");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mv = new MovePanel();
		add(mv);
		
		// 윈도우 크기가 변경될때.......
		mv.addComponentListener(new ComponentAdapter() {
			// 컴포넌트의 크기가 변경될때
			public void componentResized(ComponentEvent evt) {
				Component c = (Component)evt.getSource();
				width = c.getWidth();
				height =c.getHeight();
				//System.out.println(width + ", " + height);
			}
		});
		// 스레드 시작
		Thread thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();
	}
	
	public static void main(String[] args) {
		new MoveOval().setVisible(true);
	}
	// 스레드 구현
	@Override
	public void run() {
		while(true){
			nowX += swx*20; // x값 증감
			nowY += swy*12; // y값 증감
			if(nowX<=0 || nowX>=width-30) swx *= -1; // 경계에 도달하면 반전
			if(nowY<=0 || nowY>=height-30) swy *= -1;
			try { Thread.sleep(10); } catch (InterruptedException e) { ; } // 잠시 쉬어
			repaint(); // 좌표가 바뀌었으니 다시 그려
		}
	}
	// 공그리기 판넬
	class MovePanel extends JPanel{
		@Override
		public void paint(Graphics g) {
			setBackground(Color.WHITE);
			g.setColor(Color.red);
			g.fillOval(nowX, nowY, 30, 30);
		}
	}
}
