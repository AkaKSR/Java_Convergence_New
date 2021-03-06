/*
 * Queue : FIFO(First In First Out) 먼저들어온 데이터를 먼저 처리할때 사용
 */

package kr.green.list;

import java.util.LinkedList;

public class QueueEx {
	
	public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<>();
		
		queue.addLast(1);
		queue.addLast(2);
		queue.addLast(3);
		queue.addFirst(1);
		queue.addFirst(2);
		queue.addFirst(3);
		
		queue.offer(11);
		queue.offer(22);
		queue.offer(33);
		
		System.out.println(queue);
		
		System.out.println();
		
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
		System.out.println();
		
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		
		System.out.println();
		
		System.out.println(queue.pollLast());
		System.out.println(queue.pollLast());
		System.out.println(queue.pollLast());
		
//		System.out.println(queue.getFirst());
//		System.out.println(queue.getLast());
	}
	
}
