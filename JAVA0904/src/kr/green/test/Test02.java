package kr.green.test;

import java.util.Scanner;

/*
영어 대소문자와 띄어쓰기만으로 이루어진 문자열이 주어진다. 
이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 
단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
 */
public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("영어 문장 입력(첫글자가 0이면 종료) :");
			String str = sc.nextLine();
			if(str.charAt(0)=='0') break;
			int count=1;
			// 왜? 연속된 공백이나 탭을 걸러내야 한다.
			char oldChar='a'; // 공백이나 탭이아닌 아무문자로 초기화
			for(int i=0;i<str.length();i++) { // 글자수 만큼 반복
				char ch = str.charAt(i); // 1글자 잘라내기
				// 이전글자가 공백이나 탭이 아닐때 공백이나 탭이면 새로운 단어 시작
				if(oldChar!=' ' && oldChar!='\t' && (ch==' ' || ch=='\t')) count++; // 개수 증가
				oldChar = ch; // 현재 글자 피신
			}
			// 첫글자가 공백이나 탭이라면 개수 감소
			if(str.charAt(0)==' '||str.charAt(0)=='\t') count--;
			// 마지막 글자가 탭 또는 공백이면 새로운 단어가 시작된것이 아미므로 개수 감소
			if(str.charAt(str.length()-1)==' '||str.charAt(str.length()-1)=='\t') count--;

			System.out.println("단어수 : " + count + "개");
		}
		sc.close();
	}
}






