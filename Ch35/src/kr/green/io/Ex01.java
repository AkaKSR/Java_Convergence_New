// 바이트 단위 입출력 : InputStream, OutputStream으로 끝나는 클래스들
package kr.green.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("ex01.dat");
			fos.write(1);
			fos.write(2);
			fos.write(3);
			fos.write(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 });
			fos.flush();
			System.out.println("저장 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
