package kr.green.test;

public class Test02 {
	public static void main(String[] args) {
		// 천간 배열
		String[] gan = { "경", "신", "임", "계", "갑", "을", "병", "정", "무", "기" };
		// 지지 배열
		String[] ji = { "신", "유", "술", "해", "자", "축", "인", "묘", "진", "사", "오", "미" };
		// 색상 배열
		String[] color = { "백", "백", "흑", "흑", "청", "청", "적", "적", "황", "황" };
		// 띠 배열
		String[] ddi = { "원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양" };

		for (int i = 1990; i <= 2100; i++) {
			// 천간 지지 계산
			int ganConvert = Integer.parseInt(String.valueOf(i).substring(3));
			int jiConvert = (i % 12);
			
			// 천간지지년으로 출력
			System.out.println(i + "년 - " + gan[ganConvert] + ji[jiConvert] + "년 - " + color[ganConvert] + ddi[jiConvert] + "해");
//			System.out.println(gan[ganConvert] + ji[jiConvert] + "년입니다.");
//			System.out.println(color[ganConvert] + ddi[jiConvert] + "의 해입니다.");
		}
	}
}
