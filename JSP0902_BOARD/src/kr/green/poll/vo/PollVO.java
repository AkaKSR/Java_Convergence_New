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
	//-----------------------------------------------------------
	// 필요한 메서드 추가
	// 총 투표수를 구하는 메서드
	public int getTotalCount() {
		int total = 0;
		for(int i=0;i<count.length;i++) total += count[i];
		return total;
	}
	// 각 항목의 백분율을 리턴하는 메서드 
	public String getPercent(int index) {
		if(getTotalCount()>0)
			return String.format("%.2f%%", (double)count[index]/getTotalCount() * 100);
		else
			return "0.00%";
	}
}










