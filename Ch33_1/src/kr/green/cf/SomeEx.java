package kr.green.cf;

import kr.green.vo.Some;

public class SomeEx {
	
	public static void main(String[] args) {
		Some s1 = new Some();
		Some s2 = new Some();
		Some s3 = new Some();
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		
		System.out.println();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}