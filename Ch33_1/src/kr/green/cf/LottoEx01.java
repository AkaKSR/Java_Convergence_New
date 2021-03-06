package kr.green.cf;

import java.util.Arrays;
import java.util.Random;

public class LottoEx01 {
	
	public static void main(String[] args) {
		// 배열을 이용한 로또 번호 생성기
		int lotto[] = new int[6]; // 6개 숫자
		Random rnd = new Random(); // 난수 객체
		for (int i = 0; i < lotto.length; i++) { // 6회 반복
			lotto[i] = rnd.nextInt(45) + 1; // 1 ~ 45 사이의 난수 발생
			for (int j = 0; j < i; j++) { // 이전 번호와 비교
				if (lotto[i] == lotto[j]) { // 같은 수가 있으면
					i--; // 현재 반복 횟수를 감소하여 현재의 번호를 버림.
					break;
				}
			}
		}
		System.out.println("생성 번호: " + Arrays.toString(lotto));
		Arrays.sort(lotto);
		System.out.println("생성 번호: " + Arrays.toString(lotto));
	}
	
}
