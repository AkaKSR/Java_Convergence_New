package kr.green.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02 {
	
	public static void main(String[] args) {
		// JDK 1.7 이후의 방법
		// 1. 열고 닫기
		try(Writer wr = new FileWriter("test02.txt", true)) { // try(열기) 하면 자동으로 닫기가 가능하다.
			// 2. 사용
			wr.append("저장이 될까?\n");
			wr.append("저장이 안될까?\n");
			System.out.println("저장완료!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
