package kr.green.memo.vo;

import java.util.Date;

// 테이블과 1대1로 대응되게 작성한다.
public class MemoVO {
	private int idx;
	private String name;
	private String password;
	private String memo;
	private Date regDate;
	private String ip;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "MemoVO [idx=" + idx + ", name=" + name + ", password=" + password + ", memo=" + memo + ", regDate="
				+ regDate + ", ip=" + ip + "]";
	}

}
