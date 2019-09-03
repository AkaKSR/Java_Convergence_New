package kr.green.poll.vo;

import java.util.Arrays;

public class PollVO {
	private String subject;
	private String[] item;
	private int[] count;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String[] getItem() {
		return item;
	}

	public void setItem(String[] item) {
		this.item = item;
	}

	public int[] getCount() {
		return count;
	}

	public void setCount(int[] count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "PollVO [subject=" + subject + ", item=" + Arrays.toString(item) + ", count=" + Arrays.toString(count)
				+ "]";
	}
	
}
