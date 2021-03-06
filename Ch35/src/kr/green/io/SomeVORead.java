package kr.green.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SomeVORead {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("some.dat"));
			// 객체를 읽을 때는 Object타입이므로 형변환 해줘야 한다.
			// 형변환 할때는 ClassNotFoundException이 발생한다.
			SomeVO vo = (SomeVO) ois.readObject();
			System.out.println(vo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
