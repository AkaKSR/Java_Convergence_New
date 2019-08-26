package kr.green.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		byte[] data = new byte[10];
		 try(FileInputStream fis = new FileInputStream("ex01.dat")) {
			 System.out.println(fis.read());
			 System.out.println(fis.read());
			 System.out.println(fis.read());
			 fis.read(data);
			 System.out.println(Arrays.toString(data));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
