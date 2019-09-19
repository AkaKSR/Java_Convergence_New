package kr.green.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestEx01 {
	public static void main(String[] args) {
		int count = 0;
		String strArr[] = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌".split(",");

		// 1. 김씨와 이씨는 각각 몇 명 인가?
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].substring(0, 1).equals("김"))
				count++;
		}
		System.out.println("김씨는 " + count + "명 입니다.");
		count = 0;
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].substring(0, 1).equals("이"))
				count++;
		}
		System.out.println("이씨는 " + count + "명 입니다.");
		count = 0;

		// 2. "이재영"이란 이름이 몇번 반복되는가?
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].equals("이재영"))
				count++;
		}
		System.out.println("\"이재영\"이란 이름은 " + count + "번 반복됩니다.");

		// 3. 중복을 제거한 이름 출력(HashSet: 중복제거)
		Set<String> set = new HashSet<>(Arrays.asList(strArr));
		System.out.println(set);

		// 4. 중복을 제거한 이름을 오름차순으로 정렬하여 출력(TreeSet: 중복제거후 오른차순 정렬)
		Set<String> set1 = new TreeSet<>(Arrays.asList(strArr));
		System.out.println(set1);

		// 5-1. 중복을 제거한 이름은 내림차순으로 정렬하여 출력
		List<String> list = new ArrayList<String>(set1);
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i) + ", ");
		}
		System.out.println();

		// 5-2. 다른 방법
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println(list);

		// 6-1. 반복문 1개로 배열을 뒤집어 보세요.
		int ar[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("원본: " + Arrays.toString(ar));
		for (int i = 0; i < ar.length / 2; i++) {
			int temp = ar[i]; // temp에 ar[i]를 넣는다.
			ar[i] = ar[ar.length - i - 1]; // ar[i]에 ar[ar.length-i-1]를 넣는다. (여기서 ar[ar.length-i-1]는 ar[전체 배열크기-i-1]이다.)
			ar[ar.length - i - 1] = temp; // ar[ar.length-i-1]에 temp를 넣는다.
		}
		System.out.println("변경: " + Arrays.toString(ar));

		// 6-2. 반복문 1개로 배열을 뒤집어 보세요.(비트 연산자 사용)
		int ar1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("원본: " + Arrays.toString(ar1));
		for (int i = 0; i < ar1.length / 2; i++) {
			ar[i] = ar[i] ^ ar[ar.length-i-1];
			ar[ar.length-i-1] = ar[i] ^ ar[ar.length-i-1];
			ar[i] = ar[i] ^ ar[ar.length-i-1];
		}
		System.out.println("변경: " + Arrays.toString(ar1));
	}
}
