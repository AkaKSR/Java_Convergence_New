package kr.green.test;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalCase[][] = new int[9][2];
		int testCase;

		// 테스트 케이스 개수 입력
		System.out.print("테스트 케이스의 수를 입력하시오(0은 종료) > ");
		testCase = sc.nextInt();
		// 0이면 종료
		if (testCase == 0) System.exit(0);

		// 테스트 케이스 입력
		System.out.println("테스트 케이스를 입력하시오(예제 1 2)");
		for (int i = 0; i < testCase; i++) {
			totalCase[i][0] = sc.nextInt();
			totalCase[i][1] = sc.nextInt();
		}
		
		// 경기 결과 출력
		for (int i = 0; i < testCase; i++) {
			if (totalCase[i][0] > totalCase[i][1]) {
				System.out.println((i+1) + "회차 연세대 승");
			} else if (totalCase[i][0] < totalCase[i][1]) {
				System.out.println((i+1) + "회차 고려대 승");
			} else {
				System.out.println((i+1) + "회차 무승부");
			}
		}
		
		sc.close();
	}
}
