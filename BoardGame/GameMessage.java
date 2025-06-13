import java.io.Serializable;

public class GameMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	public enum MessageType {
		BOARD_UPDATE, // שליחת מצב הלוח
		PLAYER_PROMPT, // בקשת קלט משחקן
		INFO, // הודעה כללית
		RESULT, // סוף משחק
		CHOICE_RESPONSE // שליחת בחירה לשרת
	}

	private MessageType type;
	private String content;

	public GameMessage(MessageType type, String content) {
		this.type = type;
		this.content = content;
	}

	public MessageType getType() {
		return type;
	}

	public String getContent() {
		return content;
	}
}
