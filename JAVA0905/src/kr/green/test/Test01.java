package kr.green.test;

import java.util.Scanner;

/*
 *              7
 *            3   8
 *          8   1   0
 *        2   7   4   4
 *      4   5   2   6   5
 * 위 그림은 크기가 5인 정수 삼각형의 한 모습이다.
 * 맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때,
 * 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라
 * 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택 할 수 있다.
 * 삼각형의 크기는 1 이상 500 이하이다.
 * 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.
 * 입력					출력
 * 5					28
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 */
public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("행수 입력 : ");
		int row = sc.nextInt();
		int[][] ar = new int[row][row*2];
		int col = row-1;
		for (int i = 0; i < row; i++) {
			System.out.print("정수 " + (i+1) + "개 입력 : ");
			int t = col;
			for (int j = 0; j <= i; j++) {
				ar[i][t] = sc.nextInt();
				t += 2;
			}
			col--;
		}
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				if (ar[i][j]==0) {
					System.out.print("  ");
				} else {
					System.out.print(String.format("%3d", ar[i][j]));
				}
			}
			System.out.println();
		}
		sc.close();
		
		// 계산하기
		col = row-1; // 첫번째 줄에 입력된 위치
		int sum = ar[0][col]; // 첫줄은 그냥 더하고
		for (int i = 1; i < row; i++) { // 1행부터 마지막 줄까지
			if (ar[i][col-1] < ar[i][col+1]) { // 왼쪽것과 오른쪽것을
				col++; // 오른쪽으로
			} else {
				col--; // 왼쪽으로
			}
			System.out.println(ar[i][col]);
			sum += ar[i][col]; // 둘 중 큰값 더하기
		}
		System.out.println("답 : " + sum);
		
	}
}
