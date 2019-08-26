package kr.green.cf;

import java.util.Random;

public class LottoEx02 {
	public static void main(String[] args) {
		// �迭�� �̿��� �ζ� ��ȣ ������
		int lotto[] = new int[45]; // 45�� ����
		Random rnd = new Random(); // ���� ��ü

		for (int i = 0; i < 6; i++) { // 6�� ����
			int temp = 0;
			do {
				temp = rnd.nextInt(lotto.length); // 0~44 ������ ���� ����
			} while (lotto[temp] != 0); // ������ ��ȣ�� ��ġ�� ���� 0�� �ƴ� ���� �ݺ�
			lotto[temp] = 1; // 0�� ��ġ�� ã������ ���� 1�� ����
		} // �� �ݺ����� ����Ǹ� 6������ ���� 1�̰� �������� ��� 0�̴�.

		System.out.print("���� ��ȣ: ");

		for (int i = 0; i < lotto.length; i++) { // �迭 �߿� ���ڰ� 1�� "��ġ��" ���
			if (lotto[i] == 1) {
				System.out.print(String.format("%3d", i + 1));
			}
		}
		System.out.println();
	}
}