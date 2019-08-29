package me.image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
 
/*
 * ImageResizeFrameMain.java
 * 이미지를 로딩한 후 크기를 변경하고 BufferedImage에 그리기
 *
 * [이미지 크기 변경 알고리즘(Image 클래스의 스태틱 상수)]
 * - static int SCALE_AREA_AVERAGING: Averaging 기법을 이용해서 축소되거나 확대된 영역을 처리
 * - static int SCALE_DEFAULT: 디폴트 이미지 크기 변경 알고리즘
 * - static int SCALE_FAST: Smoothing보다는 크기 변경 속도가 빠른 알고리즘
 * - static int SCALE_REPLICATE: ReplicateScaleFilter에 포함된 크기 변경 알고리즘
 * - static int SCALE_SMOOTH: 속도보다는 Smoothing을 중요시하는 알고리즘
 *
 */
 
class ImageResizeFrame2 extends JFrame{
 	private static final long serialVersionUID = -8480773388384434686L;
	private String filename;
    private Image img = null;
    private BufferedImage bi1 = null;
    private BufferedImage bi2 = null;
    private int width,height;
    public ImageResizeFrame2(String filename){
        this.filename = filename;
         
        //1. 원본이미지 로딩
        this.img = Toolkit.getDefaultToolkit().createImage(this.filename);
        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(img, 0);
        try{
            tracker.waitForID(0);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        width = img.getWidth(null);
        height = img.getHeight(null);
         
        //2. 이미지 Resizing
        //   1/4로 축소
        Image scaledImage1 = img.getScaledInstance(width/2, height/2, Image.SCALE_DEFAULT);
        tracker.addImage(scaledImage1, 0);
        try{
            tracker.waitForID(0);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
         
        //3. Image에서 Pixel데이터 추출하기
        int[] pixels1 = new int[(width/2)*(height/2)];
        PixelGrabber pg1 = new PixelGrabber(scaledImage1, 0, 0, width/2, height/2, pixels1, 0, width/2);
        try{
            pg1.grabPixels();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
         
        //4. Pixel을 이용해서 BufferedImage 생성하기
        this.bi1 = new BufferedImage(width/2, height/2, BufferedImage.TYPE_INT_RGB);
        this.bi1.setRGB(0, 0, width/2, height/2, pixels1, 0, width/2);
        // 이미지를 파일로 저장
        try {
			ImageIO.write(bi1, "jpg", new File("thumbnail1.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        //2. 이미지 Resizing
        //   4배 확대
        Image scaledImage2 = img.getScaledInstance(width*2, height*2, Image.SCALE_DEFAULT);
        tracker.addImage(scaledImage2, 0);
        try{
            tracker.waitForID(0);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
         
        //3. Image에서 Pixel데이터 추출하기
        int[] pixels2 = new int[(width*2)*(height*2)];
        PixelGrabber pg2 = new PixelGrabber(scaledImage2, 0, 0, width*2, height*2, pixels2, 0, width*2);
        try{
            pg2.grabPixels();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
         
        //4. Pixel을 이용해서 BufferedImage 생성하기
        this.bi2 = new BufferedImage(width*2, height*2, BufferedImage.TYPE_INT_RGB);
        this.bi2.setRGB(0, 0, width*2, height*2, pixels2, 0, width*2);
        
        // 이미지를 파일로 저장
        try {
			ImageIO.write(bi2, "jpg", new File("thumbnail3.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
       	setSize(500, 450);
    	setTitle("이미지 Resize II");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);

    }
    public void paint(Graphics g){
        if(this.img != null && this.bi1 != null && this.bi2 != null){
            g.drawImage(img, 0, 50, this);
            g.drawImage(bi1, width, 50, this);
            g.drawImage(bi2, width*2, 50, this);
        }
    }
    public static void main(String[] args){
    	new ImageResizeFrame2("java.jpg");
     }
}
