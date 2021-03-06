/*
 * 깊은 복사 : 내용 복사
 * 얕은 복사 : 주소 복사
 */

package kr.green.list;

public class CopyEx {
	public static void main(String[] args) {
		HanjaVO vo1 = new HanjaVO();
		vo1.setIndex(1);
		vo1.setH("天");
		vo1.setK("하늘 천");
		System.out.println(vo1);
		HanjaVO vo2 = vo1; // 얕은 복사
		System.out.println(vo2); // 내용이 같다. 복사인가?
		System.out.println();
		
		vo2.setH("地");
		
		System.out.println(vo1);
		System.out.println(vo2); // 두개 다 복사되었다. 객체는 1개다. vo2는 vo1의 주소를 가진다.
		
		System.out.println();
		
		// 주소가 아닌 내용이 복사 되어야 한다. : 깊은 복사
		HanjaVO vo3 = new HanjaVO(); // 객체를 별도로 만들고
		vo3.setH(vo1.getH()); // 내용을 하나하나 복사해야 한다.
		vo3.setIndex(vo1.getIndex());
		vo3.setK(vo1.getK());
		
		System.out.println(vo1);
		System.out.println(vo3); // vo3가 변경되었다. vo1과 vo3는 다른 객체다.
		
		/*
		 * 위의 내용을 보면 깊은 복사는 왕짜증이다.
		 * 그래서 깊은 복사가 필요한 경우에는 VO를 만들때 Cloneable 인터페이스를 구현해 줘라.
		 * 그러면 clone 메서드로 깊은 복사 가능
		 */
		
		try {
			HanjaVO vo4 = (HanjaVO) vo1.clone();
			System.out.println("vo1 : " + vo1);
			System.out.println("vo4 : " + vo4);
			vo4.setH("天");
			System.out.println("vo1 : " + vo1);
			System.out.println("vo4 : " + vo4);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
