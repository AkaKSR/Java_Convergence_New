/*
 * 문자단위 입력 : Reader객체가 최고 조상
 * 문자단위 출력 : Writer객체가 최고 조상
 */

package kr.green.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex03 {
	public static void main(String[] args) {
		Reader fr = null;
		
		try {
			fr = new FileReader("test02.txt");
			int n;
//			while ((n=fr.read()) > 0) { // 1글자씩 읽기.
//				System.out.print((char) n);
//			}
			char[] data = new char[1024];
			while ((n=fr.read(data)) > 0) { // 배열 크기 만큼만 읽기
				System.out.print(new String(data, 0, n));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
