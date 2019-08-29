package kr.green.cal;

public class LunarVO {
	private String solar;
	private String lunar;
	private String ganji;

	public LunarVO() {
	}

	public LunarVO(String solar, String lunar, String ganji) {
		super();
		this.solar = solar;
		this.lunar = lunar;
		this.ganji = ganji;
	}

	public String getSolar() {
		return solar;
	}

	public void setSolar(String solar) {
		this.solar = solar;
	}

	public String getLunar() {
		return lunar;
	}

	public void setLunar(String lunar) {
		this.lunar = lunar;
	}

	public String getGanji() {
		return ganji;
	}

	public void setGanji(String ganji) {
		this.ganji = ganji;
	}

	/*
	 * 메서드 추가
	 */
	// 양력 가공
	public String getSolarYear() { // 양력 연도
		return solar.split("-")[0];
	}

	public String getSolarMonth() { // 양력 월
		return solar.split("-")[1];
	}

	public String getSolarDate() { // 양력 일
		return solar.split("-")[2].split(" ")[0];
	}

	public int getWeekday() { // 양력 요일
		return "일월화수목금토".indexOf(solar.split(" ")[1].substring(1, 2)) + 1;
	}

	// 음력 가공
	public String getLunarYear() { // 음력 연도
		return lunar.split("-")[0];
	}

	public String getLunarMonth() { // 음력 월
		return lunar.split("-")[1];
	}

	public String getLunarDate() { // 음력 일
		return lunar.split("-")[2];
	}

	// 간지 가공 : 윤달은 월건이 없다.
	public String getGanjiYear() {
		return ganji.split(" ")[0].substring(0, 2);
	}

	public String getGanjiMonth() {
		if (ganji.split(" ").length == 2) { // 윤달인 경우
			return "";
		} else { // 윤달이 아닌 경우
			return ganji.split(" ")[1].substring(0, 2); 
		}
	}

	public String getGanjiDate() {
		if (ganji.split(" ").length == 2) { // 윤달인 경우
			return ganji.split(" ")[1].substring(0, 2); 
		} else { // 윤달이 아닌 경우
			return ganji.split(" ")[2].substring(0, 2); 
		}
	}
	
	@Override
	public String toString() {
		String msg = "양력 : " + solar + "\n";
		msg = "음력 : " + lunar + "\n";
		msg = "간지 : " + ganji + "\n";
		return msg;
	}
}
