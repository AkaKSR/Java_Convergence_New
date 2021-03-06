/*
 * Data타입에 맞추어 입력하는 클래스
 * DataInputStream, DataOutputStream
 */

package kr.green.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIO {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("data.dat"));
			oos.writeByte(1);
			oos.writeChar('C');
			oos.writeInt(12);
			oos.writeDouble(3.14);
			oos.writeUTF("블라블라블라");
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("저장완료");
		try {
			ois = new ObjectInputStream(new FileInputStream("data.dat"));
			System.out.println(ois.readByte());
			System.out.println(ois.readChar());
			System.out.println(ois.readInt());
			System.out.println(ois.readDouble());
			System.out.println(ois.readUTF());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
