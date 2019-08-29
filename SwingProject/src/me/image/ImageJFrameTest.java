package me.image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
 
/**
 * ImageJFrameTest.java
 * 이미지 로딩 예제
 * Tookkit을 이용해서 Image객체 생성하기
 * 
 * ImageJFrameTest의 생성자에 파일명을 넘겨주면, 
 * 해당 파일명으로 Toolkit을 얻어낸 후 이미지를 로딩한다. 
 * 그리고 paint()가 호출될 때 로딩된 이미지가 null이 아니라면 
 * 이미지를 그리게 된다.
 */
 
class ImageJFrameTest extends JFrame{
    private Image img = null;
    public ImageJFrameTest(String filename){
    	super("이미지 그리기");
        Toolkit t = Toolkit.getDefaultToolkit();
        img = t.getImage(filename);
        setSize(420, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void paint(Graphics g){
        if(this.img != null){
            g.drawImage(img,50, 50, this);
        }
    }
    public static void main(String[] args){
        new ImageJFrameTest("java.jpg");
    }
}
