/*
 * Set: 입력 순서는 중요하지 않고 중복을 허용하고 싶지 않을때 사용
 * Set은 인터페이스이므로 구현체인 HashSet 또는 TreeSet을 사용한다.
 * JDK 1.5부터는 모두 Generic으로 구현하였다.
 */

package kr.green.cf;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEx {
	
	public static void main(String[] args) {
		// JDK 1.4까지 사용 방법
		Set set = new HashSet();
		set.add(1);
		set.add(1.2f);
		set.add(3.14);
		set.add("한사람");
		System.out.println(set.size() + "개 " + set);
		
		// JDK 1.5부터 사용 방법
		Set<Integer> set2 = new HashSet<Integer>(); // JDK 1.5까지
		Set<Integer> set3 = new TreeSet<>(); // JDK 1.6부터
		
		set3.add(2);
		set3.add(3);
		set3.add(1);
		
		System.out.println(set3.size() + "개 " + set3);
	}
	
}
