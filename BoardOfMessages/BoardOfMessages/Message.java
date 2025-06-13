package BoardOfMessages;

public class Message {
	private int x;
	private int y;
	private String text;
	
	public Message(int x ,int y , String text) {
		setX(x);
		setY(y);
		setText(text);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
