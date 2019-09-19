package vo;

public class ChunjaVO {
	private int idx;
	private String k;
	private String h;
	private String m;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getH() {
		return h;
	}

	public void setH(String h) {
		this.h = h;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	@Override
	public String toString() {
		return "ChunjaVO [idx=" + idx + ", k=" + k + ", h=" + h + ", m=" + m + "]";
	}

}
