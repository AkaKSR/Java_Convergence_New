package kr.green.test;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		// 천간 배열
		String[] gan = { "경", "신", "임", "계", "갑", "을", "병", "정", "무", "기" };
		// 지지 배열
		String[] ji = { "신", "유", "술", "해", "자", "축", "인", "묘", "진", "사", "오", "미" };
		// 색상 배열
		String[] color = { "백", "백", "흑", "흑", "청", "청", "적", "적", "황", "황" };
		// 띠 배열
		String[] ddi = { "원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양" };
		
		Scanner sc = new Scanner(System.in);
		while (true) {
		// 연도를 입력받는다.
		System.out.print("계산하고자 하는 연도를 입력해주시기 바랍니다(예시 2019) > ");
		int year = sc.nextInt();
		
		if (year == 0) break;
		
		// 천간 지지 계산
		int ganConvert = Integer.parseInt(String.valueOf(year).substring(3));
		int jiConvert = (year%12);
		
		// 천간지지년으로 출력
		System.out.println(gan[ganConvert] + ji[jiConvert] + "년입니다.");
		System.out.println(color[ganConvert] + ddi[jiConvert] + "의 해입니다.");
		}
		sc.close();
	}
}
