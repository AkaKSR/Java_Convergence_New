package kr.green.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectIOEx02 {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("time.dat"));
			oos.writeObject(new Date());
			oos.flush();
			oos.close();
			System.out.println("저장 완료!! 3초 후에 읽어보자~~~");
			Thread.sleep(3000);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("time.dat"));
			Date time = (Date) ois.readObject();
			ois.close();
			System.out.println("읽은 시간: " + sdf.format(time));
			System.out.println("현재 시간: " + sdf.format(new Date()));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
