package kr.green.test;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 문제 2
 * 알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서,
 * 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을
 * 출력하는 프로그램을 작성하시오.
 * 입력
 * baekjoon
 * 출력
 * 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
 * a b c d e f g h i j k l m n o p q r s t u v w x y z
 */
public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ar[] = new int[26];
		while (true) {
			System.out.print("공백없는 영문자열 입력(0은 종료) > ");
			String str = sc.nextLine();
			if (str.charAt(0)=='0') break;
			for (int i = 0; i < ar.length; i++) ar[i] = -1;
			for (char c : str.toCharArray()) {
				int index = str.indexOf(c);
				ar[c-'a'] = index;
			}
			System.out.println(Arrays.toString(ar));
		}
		sc.close();
	}
}
