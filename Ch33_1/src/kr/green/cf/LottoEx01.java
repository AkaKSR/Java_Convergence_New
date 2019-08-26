package kr.green.cf;

import java.util.Arrays;
import java.util.Random;

public class LottoEx01 {
	
	public static void main(String[] args) {
		// �迭�� �̿��� �ζ� ��ȣ ������
		int lotto[] = new int[6]; // 6�� ����
		Random rnd = new Random(); // ���� ��ü
		for (int i = 0; i < lotto.length; i++) { // 6ȸ �ݺ�
			lotto[i] = rnd.nextInt(45) + 1; // 1 ~ 45 ������ ���� �߻�
			for (int j = 0; j < i; j++) { // ���� ��ȣ�� ��
				if (lotto[i] == lotto[j]) { // ���� ���� ������
					i--; // ���� �ݺ� Ƚ���� �����Ͽ� ������ ��ȣ�� ����.
					break;
				}
			}
		}
		System.out.println("���� ��ȣ: " + Arrays.toString(lotto));
		Arrays.sort(lotto);
		System.out.println("���� ��ȣ: " + Arrays.toString(lotto));
	}
	
}