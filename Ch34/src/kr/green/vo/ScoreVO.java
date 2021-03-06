package kr.green.vo;

public class ScoreVO {
	private String name;
	private int kor, eng, mat, edps, rank;

	public ScoreVO() {
		name = "";
		rank = 1;
	}

	public ScoreVO(String name, int kor, int eng, int mat, int edps) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.edps = edps;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getEdps() {
		return edps;
	}

	public void setEdps(int edps) {
		this.edps = edps;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSum() {
		return kor + eng + mat + edps;
	}

	public double getAverage() {
		return (double) getSum() / 4;
	}

	@Override
	public String toString() {
		String data = String.format("%-5s %5d %5d %5d %5d %5d %7.2f %3d", name, kor, eng, mat, edps, getSum(),
				getAverage(), rank);
		return data;
	}

}
