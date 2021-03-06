package kr.green.cf;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import kr.green.vo.HanjaVO;

/*
 * 내가 만든 클래스도 Set에 저장이 가능한가?
 * 사용자가 만든 클래스에 반드시 같은 객체인지 판단하는 메소드가 작성되어있어야 한다.
 * equals와 hashcode 메소드를 추가해 주어야 한다.
 * 
 * 내가 만든 클래스가 TreeSet(정렬을 지원하는 Set)에 넣을 수 있는가?
 * TreeSet에 저장하려면 반드시 정렬 기준을 정하는 Comparable 인터페이스를 구현해야 한다.
 */

public class SetEx02 {
	public static void main(String[] args) {
		Set<HanjaVO> hanjaSet = new HashSet<>();
		
		hanjaSet.add(new HanjaVO("1", "天", "천", "하늘 천"));
		hanjaSet.add(new HanjaVO("1", "天", "천", "하늘 천"));
		hanjaSet.add(new HanjaVO("1", "天", "천", "하늘 천"));
		hanjaSet.add(new HanjaVO("1", "天", "천", "하늘 천"));
		
		System.out.println(hanjaSet.size() + "개!!!");
		
		Set<HanjaVO> treeSet = new TreeSet<>();
		treeSet.add(new HanjaVO("1", "天", "천", "하늘 천"));
		treeSet.add(new HanjaVO("3", "天", "천", "하늘 천"));
		treeSet.add(new HanjaVO("2", "天", "천", "하늘 천"));
		
		System.out.println(treeSet.size() + "개!!!");
		System.out.println(treeSet);
	}
}
