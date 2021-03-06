package kr.green.vo;

public class Code {
	private int rgba[];
	private String hex;

	public int[] getRgba() {
		return rgba;
	}

	public void setRgba(int[] rgba) {
		this.rgba = rgba;
	}

	public String getHex() {
		return hex;
	}

	public void setHex(String hex) {
		this.hex = hex;
	}
}

class Color {
	private String color;
	private String category;
	private String type;
	private Code code;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}
}

class Colors {
	private Color[] colors;

	public Color[] getColors() {
		return colors;
	}

	public void setColors(Color[] colors) {
		this.colors = colors;
	}
}