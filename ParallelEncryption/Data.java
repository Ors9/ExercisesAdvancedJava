
public class Data {
	private String text;
	private int pos;

	public Data(int pos, String text) {
		this.pos = pos;
		this.text = text;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
