package kr.green.test;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		// m = 총 건수, n = 한 페이지에 보여줄 게시물 수
		int m, n, totalPage;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("총 건수와 한 페이지당 노출 수를 입력해주시기 바랍니다(0 0은 종료) > ");
			m = sc.nextInt();
			n = sc.nextInt();
			
			// 0 0을 입력받으면 종료
			if (m == 0 && n == 0) break;
			totalPage = (m - 1)/n + 1;
			System.out.println(m + "  " + n + "  " + totalPage);
		}
	}
}
/*
m	n	출력
0	1	0
1	1	1
2	1	2
1	10	1
10	10	1
11	10	2
*/