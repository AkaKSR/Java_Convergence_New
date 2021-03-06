/*
 * Stack : LIFO(Last In First Out) 자료 구조로 나중에 들어온 데이터를 먼저 처리할 경우에 사용
 */

package kr.green.list;

import java.util.LinkedList;

public class StackEx {
	public static void main(String[] args) {
//		Stack<Integer> stack = new Stack<>();
		LinkedList<Integer> stack = new LinkedList<>();
		// 넣기
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		// 맨 위의 데이터 맛보기
		System.out.println(stack.peek());
		System.out.println("개수 : " + stack.size());
		System.out.println();
		
		// 맨 위의 데이터 꺼내기
		System.out.println(stack.pop());
		System.out.println("개수 : " + stack.size());
		System.out.println();
		
		// 모두 꺼내기
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
