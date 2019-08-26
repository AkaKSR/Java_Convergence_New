package kr.green.io;

import java.io.Serializable;

public class SomeVO implements Serializable{
	private static final long serialVersionUID = -5373334919532376827L;
	int data;
	
	@Override
	public String toString() {
		return "[" + data + "]";
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
}