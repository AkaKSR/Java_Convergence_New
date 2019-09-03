package kr.green.pool.vo;

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

	// 총 투표수를 리턴하는 메서드 추가
	public int getTotalCount() {
		int total = 0;
		for (int i = 0; i < count.length; i++) {
			total += count[i];
		}
		return total;
	}

	// 각각의 항목이 몇 퍼센트인지 리턴해주는 메서드 추가
	public String getPercent(int i) {
		double percent = 0;
		if (getTotalCount() > 0) {
			percent = (double) count[i] / getTotalCount() * 100;
		}
		return String.format("%.2f%%", percent);
	}

	@Override
	public String toString() {
		return "PollVO [subject=" + subject + ", item=" + Arrays.toString(item) + ", count=" + Arrays.toString(count)
				+ "]";
	}
}
