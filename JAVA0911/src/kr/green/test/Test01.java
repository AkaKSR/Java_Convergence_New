package kr.green.test;

import java.util.Scanner;

/*
 * 문제 1
 * N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
 */
public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, sum = 0;
		
		while (true) {
			System.out.print("계산할 숫자를 입력해주시기 바랍니다(0은 종료) > ");
			n = sc.nextInt();
			
			if (n == 0) break;
			
			sum += n;
			
			System.out.println("현재 합: " + sum);
			System.out.println();
		}
		sc.close();
	}
}
