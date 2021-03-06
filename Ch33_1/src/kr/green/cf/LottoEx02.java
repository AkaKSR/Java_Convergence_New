package kr.green.cf;

import java.util.Random;

public class LottoEx02 {
	public static void main(String[] args) {
		// 배열을 이용한 로또 번호 생성기
		int lotto[] = new int[45]; // 45개 숫자
		Random rnd = new Random(); // 난수 객체

		for (int i = 0; i < 6; i++) { // 6개 숫자
			int temp = 0;
			do {
				temp = rnd.nextInt(lotto.length); // 0~44 사이의 난수 생성
			} while (lotto[temp] != 0); // 생성된 번호의 위치에 값이 0이 아닌 동안 반복
			lotto[temp] = 1; // 0인 위치를 찾았으면 숫자 1로 변경
		} // 이 반복문이 종료되면 6군데만 숫자 1이고 나머지는 모두 0이다.

		System.out.print("생성 번호: ");

		for (int i = 0; i < lotto.length; i++) { // 배열 중에 숫자가 1인 "위치값" 출력
			if (lotto[i] == 1) {
				System.out.print(String.format("%3d", i + 1));
			}
		}
		System.out.println();
	}
}
