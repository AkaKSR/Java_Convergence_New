/*
 * Set: �Է� ������ �߿����� �ʰ� �ߺ��� ����ϰ� ���� ������ ���
 * Set�� �������̽��̹Ƿ� ����ü�� HashSet �Ǵ� TreeSet�� ����Ѵ�.
 * JDK 1.5���ʹ� ��� Generic���� �����Ͽ���.
 */

package kr.green.cf;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEx {
	
	public static void main(String[] args) {
		// JDK 1.4���� ��� ���
		Set set = new HashSet();
		set.add(1);
		set.add(1.2f);
		set.add(3.14);
		set.add("�ѻ��");
		System.out.println(set.size() + "�� " + set);
		
		// JDK 1.5���� ��� ���
		Set<Integer> set2 = new HashSet<Integer>(); // JDK 1.5����
		Set<Integer> set3 = new TreeSet<>(); // JDK 1.6����
		
		set3.add(2);
		set3.add(3);
		set3.add(1);
		
		System.out.println(set3.size() + "�� " + set3);
	}
	
}