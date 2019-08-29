package rock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RockScissorsPaper extends JFrame implements ActionListener{
	Image sourceImage;
	Image[] images = new Image[3];
	JButton centerbtn;
	JButton[] buttons = new JButton[3];
	Random rnd;
	int width,height, index;
	Timer timer;
	public RockScissorsPaper(String title) {
		setTitle(title);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.WHITE);
		try {
			sourceImage = ImageIO.read(new File("images/images.jpg"));
			width = sourceImage.getWidth(this)/3-2;
			height = sourceImage.getHeight(this);
			for(int i=0;i<images.length;i++){
				BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics g = bi.getGraphics(); // 그래픽 객체 얻기
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, width, height);
				// 이미지에 원본이미지를 잘라서 그리기
				g.drawImage(sourceImage, 0, 0, width, height, i*width, 0, (i*width)+width, height,this);
				images[i] = bi;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		add(new JLabel("하단의 가위/바위/보 버튼을 클릭해봐!",JLabel.CENTER),BorderLayout.NORTH);
		
		centerbtn = new JButton(new ImageIcon(images[1]));
		centerbtn.setBackground(Color.WHITE);
		add(centerbtn,BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
		for(int i=0;i<buttons.length;i++){
			buttons[i] = new JButton(new ImageIcon(images[i]));
			buttons[i].setBackground(Color.WHITE);
			buttons[i].addActionListener(this);
			bottomPanel.add(buttons[i]);
		}
		add(bottomPanel,BorderLayout.SOUTH);
		buttons[0].requestFocus();
		
		timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					index = ++index%images.length;
					centerbtn.setIcon(new ImageIcon(images[index]));
			}
		});
		timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		timer.stop();
		String message=  "";
		if(button.equals(buttons[0])){
			if(index==0)
				message = "비겼다";
			else if(index==2)
				message = "이겼다";
			else
				message = "졌다";
		}else if(button.equals(buttons[1])){
			if(index==1)
				message = "비겼다";
			else if(index==0)
				message = "이겼다";
			else
				message = "졌다";
		}else if(button.equals(buttons[2])){
			if(index==2)
				message = "비겼다";
			else if(index==0)
				message = "졌다";
			else
				message = "이겼다";
		}
		if(JOptionPane.showConfirmDialog(this, message + "\n계속하시겠습니까", 
				       "승부확인",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
			index=0;
			timer.start();
		}
	}
	public static void main(String[] args) {
		new RockScissorsPaper("가위바위보 게임").setVisible(true);
	}
}
