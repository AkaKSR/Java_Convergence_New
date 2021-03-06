/*
 * 직렬화 : 객체를 스트림으로 만든다.
 * 역직렬화 : 스트림을 객체로 조립한다.
 * 
 * 자바에서는 직렬화/역직렬화를 지원하는 Serializable 인터페이스가 있어서 반드시 구현해 주어야만 입출력이 가능하다.
 * 
 * 객체가 저장 될때는 인스턴스 멤버 변수만 저장된다.
 * static 변수나 메서드는 저장되지 않는다.
 * 모든 객체가 공유하는 값은 저장할 필요가 없기 때문이다.
 * 인스턴스 변수 중에서 저장하고 싶지 않은 변수가 있을때는 멤버 변수 선언시 앞에 transient를 붙인다.
 * ex) transient private String name;
 */

package kr.green.io;

import java.io.Serializable;

public class PersonVO implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6154664002583996016L;
	
	private String name;
	transient private int age;
	private boolean gender;
	
	public PersonVO() {
		this("무명", 0, true);
	}

	public PersonVO(String name, int age, boolean gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return name + "(" + age + "세, " + (gender?"남":"여") + ")";
	}

	
}
