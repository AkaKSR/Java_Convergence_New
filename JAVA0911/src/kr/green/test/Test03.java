package kr.green.test;

import java.util.Scanner;

/*
 * 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 
 * 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. 
 * 입력
 * 3
 * ABC
 * 출력
 * AAABBBCCC
 */
public class Test03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("반복할 횟수를 입력(0은 종료) > ");
			int num = sc.nextInt();
			if (num == 0) break;
			System.out.println("반복할 문자열 입력 > ");
			String str = sc.nextLine();
			StringBuffer sb = new StringBuffer();
			for (char c : str.toCharArray()) {
				for (int i = 0; i < num; i++) sb.append(c);
			}
			System.out.println(sb.toString());
		}
		sc.close();
	}
}
