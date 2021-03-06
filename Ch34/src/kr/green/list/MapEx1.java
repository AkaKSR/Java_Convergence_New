package kr.green.list;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapEx1 {

	public static void main(String[] args) {
//		Map<Integer, String> map = new Hashtable<>(); // 멀티스레드에도 안전
//		Map<Integer, String> map = new HashMap<>(); // 싱글스레드에 안전
		Map<Integer, String> map = new TreeMap<>(); // 정렬 지원

		map.put(1, "한사람");
		map.put(2, "두사람");
		map.put(3, "세사람");
		map.put(4, "네사람");
		map.put(3, "오사람");
		map.put(4, "육사람");

		System.out.println("map: " + map);
		System.out.println();

		// 꺼내기
		String data = map.get(4);
		System.out.println("data: " + data);
		System.out.println();

		Set<Integer> keys = map.keySet(); // 키는 Set이다.
		for (int key : keys) {
			System.out.println("keySet: " + key + " : " + map.get(key));
		}
		System.out.println();

		// 값만
		for (String value : map.values()) {
			System.out.println("values: " + value);
		}
		System.out.println();

		// 제거
		map.remove(4);
		System.out.println("map: " + map);
	}

}
