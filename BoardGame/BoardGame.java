import java.util.ArrayList;
import java.util.Collections;

public class BoardGame {
	private int size;
	private ArrayList<Integer> boardId;
	private boolean[] revealed;

	public BoardGame(int size) {
		this.size = size;
		boardId = new ArrayList<Integer>();
		revealed = new boolean[size * size]; // all false not revealed
		initializeBoard();
	}

	private void initializeBoard() {
		int totalCells = size * size;
		int pairs = totalCells / 2;

		for (int id = 0; id < pairs; id++) {
			boardId.add(id);
			boardId.add(id);
		}
		Collections.shuffle(boardId);

	}

	public ArrayList<Integer> getBoard() {
		return boardId;
	}

	public String getMaskedBoard() {
		StringBuilder sb = new StringBuilder();
		sb.append("The game Board:\n");

		for (int i = 0; i < boardId.size(); i++) {
			if (i > 0 && i % size == 0) {
				sb.append("\n");
			}
			if (revealed[i]) {
				sb.append(boardId.get(i)).append(" ");
			} else {
				sb.append("? ");
			}
		}

		sb.append("\n");

		return sb.toString();
	}

	public boolean isRevealed(int index) {
		return revealed[index];
	}

	public void setRevealed(int index) {
		revealed[index] = true;
	}

	public void setHidden(int index) {
		revealed[index] = false;
	}

	public boolean isFinished() {
		for (int i = 0; i < revealed.length; i++) {
			if (!isRevealed(i)) {
				return false;
			}

		}
		return true;
	}
}
