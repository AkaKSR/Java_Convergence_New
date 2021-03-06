/*
 * Data타입에 맞추어 입력하는 클래스
 * DataInputStream, DataOutputStream
 */

package kr.green.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIO {
	public static void main(String[] args) {
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		try {
			dos = new DataOutputStream(new FileOutputStream("data.dat"));
			dos.writeByte(1);
			dos.writeChar('C');
			dos.writeInt(12);
			dos.writeDouble(3.14);
			dos.writeUTF("블라블라블라");
			dos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("저장완료");
		try {
			dis = new DataInputStream(new FileInputStream("data.dat"));
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readUTF());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
