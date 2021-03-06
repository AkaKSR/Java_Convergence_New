/*
 * List : 입력 순서가 중요할때 배열 대용으로 사용한다.
 * 		  └ ArrayList, 
 */

package kr.green.list;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Enumeration;
import java.util.Iterator;

public class ListEx2 {
	
	public static void main(String[] args) {
		// 객체 생성시 크기를 지정하면 메모리 확보에 드는 시간을 절약 가능하다.
		ArrayList<String> v = new ArrayList<>();
		print(v);
		System.out.println();
		for (int i = 0; i < 15; i++) v.add("데이터 " + i); // 용량이 넘치면 자동으로 늘어난다.
		print(v);
		// 삽입
		v.add(0, "한사람");
		v.add(0, "두사람");
//		v.insertElementAt("세사람", 0);
		print(v);
		// 수정
		v.set(0, "1234");
		print(v);
		// 삭제
		v.remove(0);
		v.remove(0);
		print(v);
		
		// Vectort는 옛 버전에서 지원하는 컬렉션으로 멀티스레드에 안전하게 설계되어있다.
		// ArrayList는 Vector의 신버전으로 단일 스레드에만 안전하게 설계
		// ArrayList를 멀티스레드에서 사용하려면 Collections.synchronizedCollection(리스트)로 동기화 해주면 된다.
		// 조회
		for (int i = 0; i < v.size(); i++)
			System.out.print(v.get(i) + " ");
		System.out.println();
		
		for (String data : v) {
			System.out.print(data + " ");
		}
		System.out.println();
		
		Iterator<String> it = v.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		
//		Enumeration<String> en = v.elements();
//		while (en.hasMoreElements()) {
//			String string = (String) en.nextElement();
//			System.out.print(string + " ");
//		}
	}

	private static void print(ArrayList<String> v) {
		System.out.println("길이 : " + v.size());
		System.out.println("내용 : " + v);
	}
	
}
