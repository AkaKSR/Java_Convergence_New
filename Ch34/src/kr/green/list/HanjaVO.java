package kr.green.list;

import java.io.Serializable;

public class HanjaVO implements Comparable<HanjaVO>, Serializable, Cloneable {
	private int index;
	private String h;
	private String k;
	
	/**
	 * HanjaVO serialVersionUID = 2801124667292720854L;
	 */
	private static final long serialVersionUID = 2801124667292720854L;

	@Override
	public int compareTo(HanjaVO o) {
		return index - o.index;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((h == null) ? 0 : h.hashCode());
		result = prime * result + index;
		result = prime * result + ((k == null) ? 0 : k.hashCode());
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
		HanjaVO other = (HanjaVO) obj;
		if (h == null) {
			if (other.h != null)
				return false;
		} else if (!h.equals(other.h))
			return false;
		if (index != other.index)
			return false;
		if (k == null) {
			if (other.k != null)
				return false;
		} else if (!k.equals(other.k))
			return false;
		return true;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getH() {
		return h;
	}

	public void setH(String h) {
		this.h = h;
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	@Override
	public String toString() {
		return index + ". " + h + " : " + k; 
	}
}
