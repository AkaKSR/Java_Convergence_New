/*
 * 주어진 형태대로 높이가 N인 달팽이 사각형을 출력한다.
 * 
 * 입력: 5
 * 출력
 * 1  2  3  4  5
 * 16 17 18 19 6
 * 15 24 25 20 7
 * 14 23 22 21 8
 * 13 12 11 10 9
 */

package kr.green.test;

public class Test01 {
	public static void main(String[] args) {
		int length = 5, row = 0, col = -1, sw = 1, k = 0; // 개수, 행, 열, 반전, 증가 변수
		int ar[][] = new int[length][length]; // 채울 배열
		while (length > 0) {
			for (int i = 0; i < length; i++) { // 열 증감
				col += sw;
				ar[row][col] = ++k;
			}
			length--; // 갯수 감소
			if (length == 0) continue; // 개수가 0이면 종료
			for (int i = 0; i < length; i++) { // 행 증감
				row += sw;
				ar[row][col] = ++k;
			}
			sw *= -1; // 반전
		}
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.printf("%3d", ar[i][j]);
			}
			System.out.println();
		}
	}
}
