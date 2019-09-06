package kr.green.test;

import java.util.Scanner;

/*
 * 영어 대소문자와 띄어쓰기만으로 이루어진 문자열이 주어진다.
 * 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오.
 * 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
 */

/*
 * Lorem Ipsum is simply dummy text of the printing and typesetting industry.
 * Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
 * when an unknown printer took a galley of type and scrambled it to make a type specimen book.
 */
public class Test01 {
	public static void main(String[] args) {
		String input;
		Scanner sc = new Scanner(System.in);
		System.out.print("확인할 문자열을 입력해주시기 바랍니다 > ");
		input = sc.nextLine();
		
		String str[] = input.split(" ");
		String str1[];
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("\t")) {
				str1 = str[i].split("\t");
				System.out.println(str1[i]);
			}
		}
		
		// Test Code
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		
		
		if (str.length != 0) {
			System.out.println("입력된 문자열에서 단어의 개수는 " + str.length + "개 입니다.");
		}
	}
}
