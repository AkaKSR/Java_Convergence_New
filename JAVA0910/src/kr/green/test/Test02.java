package kr.green.test;

import java.util.Scanner;

/*
 * 고속도로 통행요금 계산
 * 0: 서울
 * 1: 수원
 * 2: 천안
 * 3: 대전
 * 4: 대구
 * 5: 부산
 */
public class Test02 {
	public static void main(String[] args) {
		int pay[][] = {
				{0, 1700, 4200, 7500, 15200, 19300},
				{0, 0, 3400, 6700, 13600, 17800},
				{0, 0, 0, 4200, 11000, 15000},
				{0, 0, 0, 0, 7800, 12100},
				{0, 0, 0, 0, 0, 4500},
				{0, 0, 0, 0, 0, 0}
					};
		int x, y;
		Scanner sc = new Scanner(System.in);
		// 출발 도시 코드, 도착 도시 코드 (입력)
		System.out.println("고속도로 통행료 계산 program");
		
		System.out.println("각 도시별 번호");
		System.out.println("서울(0) 수원(1) 천안(2)");
		System.out.println("대전(3) 대구(4) 부산(5)");
		
		System.out.print("출발지 도시번호 입력하고 Enter > ");
		x = sc.nextInt();
		System.out.print("도착지 도시번호 입력하고 Enter > ");
		y = sc.nextInt();
		
		// 출발 도시 코드를 행의 값으로, 도착 도시 코드를 열의 값으로 하여 2차원 배열에서 요금을 계산 (처리)
		// 통행요금을 계산 (출력)
	}
}
