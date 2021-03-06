package kr.green.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopy {
	public static void main(String[] args) {
		String inFile, outFile;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("원본 파일 이름 입력: ");
		inFile = sc.nextLine();
		System.out.print("사본 파일 이름 입력: ");
		outFile = sc.nextLine();
		
		int n;
		byte[] data = new byte[1024];
		
		try {
			fis = new FileInputStream(inFile);
			fos = new FileOutputStream(outFile);
			while ((n=fis.read(data)) > 0 ) {
				fos.write(data, 0, n);
				fos.flush();
			}
			System.out.println(inFile + "을 " + outFile + "로 복사 완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
}
