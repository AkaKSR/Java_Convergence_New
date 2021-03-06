package kr.green.test;

public class Test01 {
	// 풀이 1: 약수의 개수를 세어 2개면 소수
//	public static void main(String[] args) {
//		int count = 0, cnt = 0;
//		
//		for (int i = 2; i < 100; i++) { // 2~100까지
//			count=0;
//			for (int j = 1; j <= i; j++) { // 1~i까지 
//				if (i%j==0) { // 나누어 떨어지면 약수이므로 개수 세기
//					count++;
//				}
//			}
//			if (count==2) { // 약수의 개수가 2개면 소수
//				System.out.print(String.format("%5d", i));
//				if (++cnt%5==0) { // 개수가 5의 배수면 줄바꿈
//					System.out.println();
//				}
//			}
//		}
//	}

	// 풀이 2: 2부터 나누었을때 나누어 떨어지는 수가 자기 자신이면 소수
//	public static void main(String[] args) {
//		int j, cnt=0;
//		for (int i = 2; i < 100; i++) {
//			for (j = 2; j <= i; j++) {
//				if (i%j == 0) {
//					break;
//				}
//			}
//			if (i == j) { // 나누어 떨어졌을때 나눈 수가 자기 자신이면 중간에 약수가 없다.
//				System.out.print(String.format("%5d", i));
//				if (++cnt%5 == 0) {
//					System.out.println();
//				}
//			}
//		}
//	}

	// 풀이 3: 2부터 n/2까지 나누었을때 나누어지지 않으면 소수
//	public static void main(String[] args) {
//		boolean flag = true;
//		int cnt = 0;
//		for (int i = 2; i < 100; i++) {
//			flag = true; // 일단 소수라고 가정한다.
//			for (int j = 2; j <= i/2; j++) {
//				if (i%j == 0) {
//					// 나누어졌다면 소수가 아니다.
//					flag = false;
//					break;
//				}
//			}
//			if (flag) { // 나누어 떨어졌을때 나눈 수가 자기 자신이면 중간에 약수가 없다.
//				System.out.print(String.format("%5d", i));
//				if (++cnt%5 == 0) {
//					System.out.println();
//				}
//			}
//		}
//	}
//}

	public static void main(String[] args) {
		int cnt = 0;
		loop : for (int i = 2; i < 100; i++) {
			for (int j = 2; j <= i/2; j++) {
				if (i%j == 0) continue loop;
			}
			System.out.print(String.format("%5d", i));
			if (++cnt%5==0) System.out.println();
		}
	}
}