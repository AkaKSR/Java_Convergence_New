package kr.green.vo;

import java.io.Serializable;

public class Some implements Comparable<Some>, Serializable, Cloneable {
	private int i = 0;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Some other = (Some) obj;
		if (i != other.i)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Some o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}