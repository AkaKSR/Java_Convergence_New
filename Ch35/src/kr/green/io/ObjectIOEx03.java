/*
 * 사용자가 작성한 객체의 저장
 */

package kr.green.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIOEx03 {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("person.dat"));
			oos.writeObject(new PersonVO());
			oos.writeObject(new PersonVO("한사람", 33, false));
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("저장완료");
		try {
			ois = new ObjectInputStream(new FileInputStream("person.dat"));
			// 객체를 읽을 때는 Object타입이므로 형변환 해줘야 한다.
			// 형변환 할때는 ClassNotFoundException이 발생한다.
			PersonVO vo1 = (PersonVO) ois.readObject();
			PersonVO vo2 = (PersonVO) ois.readObject();
			System.out.println(vo1);
			System.out.println(vo2);
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
