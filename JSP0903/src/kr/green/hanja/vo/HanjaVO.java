package kr.green.hanja.vo;

/*
 * [{"d":"8급","s":"74회","n":1,"q":"《희다》","e1":"日","e2":"白","e3":"月","e4":"口","a":"2"},
 */
public class HanjaVO {
	private String d;
	private String s;
	private int n;
	private String q;
	private String e1;
	private String e2;
	private String e3;
	private String e4;
	private String a;

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getE1() {
		return e1;
	}

	public void setE1(String e1) {
		this.e1 = e1;
	}

	public String getE2() {
		return e2;
	}

	public void setE2(String e2) {
		this.e2 = e2;
	}

	public String getE3() {
		return e3;
	}

	public void setE3(String e3) {
		this.e3 = e3;
	}

	public String getE4() {
		return e4;
	}

	public void setE4(String e4) {
		this.e4 = e4;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "HanjaVO [d=" + d + ", s=" + s + ", n=" + n + ", q=" + q + ", e1=" + e1 + ", e2=" + e2 + ", e3=" + e3
				+ ", e4=" + e4 + ", a=" + a + "]";
	}
}
