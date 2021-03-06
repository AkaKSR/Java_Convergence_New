package kr.green.io;

import java.util.Scanner;
import java.util.StringTokenizer;

public class STEx {
	public static void main(String[] args) {
		String data = "사과=300,배=600,딸기=200,감=900";
		// 위의 데이터를 아래와 같이 변경하여 출력하시오
		// 사과(300원)
		// 배(600원)
		// ........
		Scanner sc = new Scanner(data);
		StringTokenizer st = new StringTokenizer(data, "=,", true);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (token.equals(",")) {
				System.out.println("원)"); // ,이면 줄바꿈과 동시에 원)으로 변경
			} else if (token.equals("=")) {
				System.out.print("("); // =이면 (으로 변경
			} else {
				System.out.print(token);
			}
		}
		System.out.println("원)");
	}
}
