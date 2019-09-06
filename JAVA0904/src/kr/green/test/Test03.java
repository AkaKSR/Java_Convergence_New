package kr.green.test;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 1 = 2s
 * 2 = 3s
 * 3 = 4s
 * 4 = 5s
 * 5 = 6s
 * 6 = 7s
 * 7 = 8s
 * 8 = 9s
 * 9 = 10s
 * 0 = 11s
 */
public class Test03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String ar[] = ",,,abc,def,ghi,jkl,mno,pqrs,tuv,wxyz,".split(",");
		System.out.println(Arrays.toString(ar));
		
		while (true) {
			System.out.print("영어 문장 입력(첫글자가 0이면 종료) : ");
			String str = sc.nextLine();
			if (str.charAt(0)=='0') break;
			str = str.toLowerCase(); // 모두 소문자로 바꾼다.
			int count = 0;
			for (int i = 0; i < str.length(); i++) { // 모든 글자 반복
				char ch = str.charAt(i);
				for (int j = 0; j<ar.length;j++) {
					if (ar[j].indexOf(ch)!=-1) { // 배열에 그 글자가 들어 있으면
						count += j; // 위치값이 초(s)이다.
						break;
					}
				}
			}
			System.out.println("시간: " + count + "초");
		}
	}
}
