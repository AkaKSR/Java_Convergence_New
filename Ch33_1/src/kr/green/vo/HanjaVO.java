package kr.green.vo;

public class HanjaVO implements Comparable<HanjaVO> {
	private String idx;
	private String h;
	private String k;
	private String m;
	
	public HanjaVO() {
	}
	
	public HanjaVO(String string, String string2, String string3, String string4) {
	}

	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
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
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}

	@Override
	public String toString() {
		return "HanjaVO [idx=" + idx + ", h=" + h + ", k=" + k + ", m=" + m + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((h == null) ? 0 : h.hashCode());
		result = prime * result + ((idx == null) ? 0 : idx.hashCode());
		result = prime * result + ((k == null) ? 0 : k.hashCode());
		result = prime * result + ((m == null) ? 0 : m.hashCode());
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
		if (idx == null) {
			if (other.idx != null)
				return false;
		} else if (!idx.equals(other.idx))
			return false;
		if (k == null) {
			if (other.k != null)
				return false;
		} else if (!k.equals(other.k))
			return false;
		if (m == null) {
			if (other.m != null)
				return false;
		} else if (!m.equals(other.m))
			return false;
		return true;
	}

	// Comparable 인터페이스 구현
	@Override
	public int compareTo(HanjaVO o) {
//		return idx.compareTo(o.getIdx());
		return o.getIdx().compareTo(idx);
	}
	
	
}
