package kr.green.cf;

import java.util.Random;

public class CardEx03 {
	public static void main(String[] args) {
		// �迭�� �̿��� ī�� ����
		int card[] = new int[52]; // 52�� ����
		Random rnd = new Random(); // ���� ��ü
		
		for (int i = 0; i < card.length; i++) { // 52�� ����
			int temp = 0;
			do {
				temp = rnd.nextInt(card.length); // 0~44 ������ ���� ����
			} while (card[temp] != 0); // ������ ��ȣ�� ��ġ�� ���� 0�� �ƴ� ���� �ݺ�
			card[temp] = i; // 0�� ��ġ�� ã������ ���� i�� ����
		} // �� �ݺ����� ����Ǹ� 0~51������ ���ڰ� �ߺ����� ����

		for (int i = 0; i < card.length; i++) {
			System.out.print(String.format("%1s%-2d", "��", card[i]));
			if ((i + 1) % 13 == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
		
		String kind[] = "��,��,��,��".split(",");
		String num[] = "1,2,3,4,5,6,7,8,9,10,J,Q,K".split(",");
		
		for (int i = 0; i < card.length; i++) {
			System.out.print(String.format("%1s%-2s", kind[i/13], num[card[i]%13]));
			if ((i + 1) % 13 == 0) {
				System.out.println();
			}
		}
		
	}
}
