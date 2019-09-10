package kr.green.test;

import java.util.Scanner;

/*
 * 비만도 측정
 * 처리방법
 * 표준체중의 게산 방법: 표준 체중 = (신장 - 100) x 0.9
 * 신체질량지수 계산 방법: 체중을 신장(미터단위)의 제곱으로 나눈 값
 * 비만 정도	신체질량지수
 * 저체중		20미만
 * 정상체중		20~24
 * 과체중		25~30
 * 병적 비만	31이상
 * 
 * 비만도		처리할 내용
 * 정상체중		10% 미만
 * 과체중		11%~19%
 * 병적 비만	20% 이상
 */
public class Test01 {
	public static void main(String[] args) {
		System.out.println("비만도 측정 program");
		// 신장 체중 입력 (입력)
		int size, weight;
		String obesity;
		String bodyMass;
		double result[] = new double[3]; // 0: 표준 체중, 1: 신체질량지수, 2: 비만도
		
		Scanner sc = new Scanner(System.in);
		System.out.print("신장을 입력하시오 (0은 종료) > ");
		size = sc.nextInt();
		if (size == 0) {
			System.exit(0);
		}
		System.out.print("체중을 입력하시오 > ");
		weight = sc.nextInt();
		
		// 표준 체중, 신체질량지수, 비만도 계산 (처리)
		// 표준 체중 로직
		result[0] = (size-100) * 0.9;
		// 신체질량지수 로직
		result[1] = (double) weight / ((double) size*size/10000);
		if (result[1] < 20) {
			obesity = "저체중";
		} else if (result[1] <=24) {
			obesity = "정상체중";
		} else if (result[1] <=30) {
			obesity = "과체중";
		} else {
			obesity = "병적 비만";
		}
		
		// 비만도 로직
		result[2] = ((weight-result[0])/result[0])*100;
		if (result[2] < 10) {
			bodyMass = "정상체중";
		} else if (result[2] <= 19) {
			bodyMass = "과체중";
		} else {
			bodyMass = "병적 비만";
		}
		
		// 신장, 체중, 표준 체중, 신체질량지수, 비만도, 신체질량지수와 비만도에 대한 비만 각각의 판정 결과 (출력)
		System.out.println("판정 결과");
		
		System.out.println("표준체중(kg) : " + result[0]);
		System.out.println("신체질량지수 : " + result[1]);
		System.out.println("지수에 대한 비만 판정 : " + obesity);
		System.out.println("비만도(%) : " + result[2]);
		System.out.println("비만도에 대한 판정 : " + bodyMass);
		
	}
}
