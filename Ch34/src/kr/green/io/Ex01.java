package kr.green.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex01 {
	
	public static void main(String[] args) {
		// 1. 변수 준비
		Writer wr = null;
		
		try {
			// 2. 열기
			wr = new FileWriter("test01.txt", true);
			// 3. 사용
			wr.append("저장이 될까?\n");
			wr.append("저장이 안될까?\n");
			wr.flush(); // 강제로 버퍼의 내용을 출력한다.
			System.out.println("저장완료!!!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. 닫기
			try {
				wr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
