package me.image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
 
/*
 * ImageJFrameTest2.java
 * MediaTracker를 이용한 이미지 로딩 보장
 * 
 * MediaTracker는 이미지가 완전히 로딩되는 것을 보장하는 기능을 한다.
 */ 
class ImageJFrameTest2 extends JFrame{
    private Image img = null;
    public ImageJFrameTest2(URL url){
    	super("이미지 그리기");
    	 this.img = Toolkit.getDefaultToolkit().getImage(url);
         MediaTracker tracker = new MediaTracker(this);
         tracker.addImage(img, 0);
         try{
            tracker.waitForAll();
         }catch(InterruptedException e){
             e.printStackTrace();
         }        
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
        try {
			new ImageJFrameTest2(new URL("http://img.naver.net/static/www/u/2013/0731/nmms_224940510.gif"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
}
