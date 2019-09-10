package kr.green.test;

import java.util.Scanner;

/*
 * 파스칼의 삼각형
 * 
 * 						1
 * 					1		1
 * 				1		2		1
 * 			1		3		3		1
 * 		1		4		6		4		1
 * 
 * 두개의 정수를 입력 받아 첫째 줄에 n번째 행에 있는 k번째 수를 출력한다.
 */
public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, k;

		System.out.print("행열을 입력하여주시기 바랍니다(00은 종료) > ");
		n = sc.nextInt();
		if (n == 00) System.exit(0);
		k = sc.nextInt();

		int[][] twoArr = new int[n + 1][];
		for (int i = 0; i < twoArr.length; i++) {
			twoArr[i] = new int[i + 1];
		}
		for (int i = 0; i < twoArr.length; i++) {
			for (int j = 0; j < 3*(twoArr.length-i); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				twoArr[i][j] = 1;
				if (i > 1 && j >= 1 && j < i - 1) {
					twoArr[i][j] = twoArr[i - 1][j - 1] + twoArr[i - 1][j];
				}
				if (twoArr[i][j] == 0) {
					System.out.print("  ");
				} else {
					System.out.print(String.format("%6d", twoArr[i][j]));
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("답은? " + twoArr[n][k - 1]);
		sc.close();
	}
}
