package kr.green.list;

import java.util.ArrayList;
import java.util.Random;

public class ListEx3 {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Random r = new Random();
		
		for (int i = 0; i < 20; i++) {
			list.add(r.nextInt(101));
		}
		System.out.println("list : " + list);
		
		// 리스트에서 반복문을 이용하여 삭제할때는 주의 하여야 한다.
		// 삭제하면 index값이 바뀐다. 그래서 반드시 뒤에서 부터 작업을 해야 한다.
		// 50이하의 데이터 삭제
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i) >= 50) {
//				list.remove(i);
//			}
//		}
		for (int i = list.size()-1; i >= 0; i--) {
			if (list.get(i) >= 50) {
				list.remove(i);
			}
		}
		System.out.println("list : " + list);
	}
	
}
