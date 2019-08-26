package kr.green.cf;

import java.util.Random;

public class CardEx03 {
	public static void main(String[] args) {
		// 배열을 이용한 카드 섞기
		int card[] = new int[52]; // 52개 숫자
		Random rnd = new Random(); // 난수 객체
		
		for (int i = 0; i < card.length; i++) { // 52개 숫자
			int temp = 0;
			do {
				temp = rnd.nextInt(card.length); // 0~44 사이의 난수 생성
			} while (card[temp] != 0); // 생성된 번호의 위치에 값이 0이 아닌 동안 반복
			card[temp] = i; // 0인 위치를 찾았으면 숫자 i로 변경
		} // 이 반복문이 종료되면 0~51까지의 숫자가 중복없이 저장

		for (int i = 0; i < card.length; i++) {
			System.out.print(String.format("%1s%-2d", "　", card[i]));
			if ((i + 1) % 13 == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
		
		String kind[] = "◆,♠,♥,♥".split(",");
		String num[] = "1,2,3,4,5,6,7,8,9,10,J,Q,K".split(",");
		
		for (int i = 0; i < card.length; i++) {
			System.out.print(String.format("%1s%-2s", kind[i/13], num[card[i]%13]));
			if ((i + 1) % 13 == 0) {
				System.out.println();
			}
		}
		
	}
}
