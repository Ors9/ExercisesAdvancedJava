import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MemoryGameSession extends Thread {
	private static final int PLAYER_ONE = 1;
	private static final int PLAYER_TWO = 2;

	private Socket player1, player2;
	private ObjectInputStream in1, in2;
	private ObjectOutputStream out1, out2;

	private BoardGame game;
	private int size;
	private int score1 = 0, score2 = 0;
	private boolean hasError = false;

	public MemoryGameSession(Socket p1, Socket p2, int size) {
		this.player1 = p1;
		this.player2 = p2;
		this.size = size;

		try {
			this.out1 = new ObjectOutputStream(player1.getOutputStream());
			this.out2 = new ObjectOutputStream(player2.getOutputStream());
			this.in1 = new ObjectInputStream(player1.getInputStream());
			this.in2 = new ObjectInputStream(player2.getInputStream());
			this.game = new BoardGame(size);
		} catch (IOException e) {
			e.printStackTrace();
			hasError = true;
		}
	}

	@Override
	public void run() {
		sendMessage(out1, GameMessage.MessageType.INFO, "Game Start!");
		sendMessage(out2, GameMessage.MessageType.INFO, "Game Start!");

		while (!game.isFinished() && !hasError) {
			sendMessage(out1, GameMessage.MessageType.INFO, "Your turn!");
			sendMessage(out2, GameMessage.MessageType.INFO, "Player 1 is playing...");
			broadcastBoard();

			int idx1 = getPlayerChoice(in1, out1, size * size - 1);
			int idx2 = getPlayerChoice(in1, out1, size * size - 1);
			playTurnLogic(PLAYER_ONE, idx1, idx2);

			if (game.isFinished())
				break;

			sendMessage(out2, GameMessage.MessageType.INFO, "Your turn!");
			sendMessage(out1, GameMessage.MessageType.INFO, "Player 2 is playing...");
			broadcastBoard();

			int idx3 = getPlayerChoice(in2, out2, size * size - 1);
			int idx4 = getPlayerChoice(in2, out2, size * size - 1);
			playTurnLogic(PLAYER_TWO, idx3, idx4);
		}

		printFinalResults();
	}

	private int getPlayerChoice(ObjectInputStream in, ObjectOutputStream out, int max) {
		while (true) {
			try {
				sendMessage(out, GameMessage.MessageType.PLAYER_PROMPT, "Choose a card (0 - " + max + "):");
				GameMessage msg = (GameMessage) in.readObject();
				int idx = Integer.parseInt(msg.getContent().trim());

				if (idx < 0 || idx >= size * size) {
					sendMessage(out, GameMessage.MessageType.INFO, "Out of range.");
				} else if (game.isRevealed(idx)) {
					sendMessage(out, GameMessage.MessageType.INFO, "Already revealed.");
				} else {
					game.setRevealed(idx);
					return idx;
				}
			} catch (Exception e) {
				e.printStackTrace();
				hasError = true;
				return 0;
			}
		}
	}

	private void playTurnLogic(int playerNumber, int i1, int i2) {
		if (i1 == i2) {
			sendMessage(getOut(playerNumber), GameMessage.MessageType.INFO, "You chose the same card twice!");
			game.setHidden(i1);
			broadcastBoard();
			return;
		}

		int val1 = game.getBoard().get(i1);
		int val2 = game.getBoard().get(i2);

		sendMessage(getOut(playerNumber), GameMessage.MessageType.INFO, "Checking cards: " + val1 + " and " + val2);
		broadcastBoard();
		if (val1 == val2) {
			sendMessage(getOut(playerNumber), GameMessage.MessageType.INFO, "Found a pair!");
			updateScore(playerNumber);
		} else {
			sendMessage(getOut(playerNumber), GameMessage.MessageType.INFO, "Not a pair.");
			broadcastBoard();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

			game.setHidden(i1);
			game.setHidden(i2);
		}

		broadcastBoard();
	}

	private ObjectOutputStream getOut(int playerNumber) {
		return playerNumber == PLAYER_ONE ? out1 : out2;
	}

	private void sendMessage(ObjectOutputStream out, GameMessage.MessageType type, String content) {
		try {
			out.writeObject(new GameMessage(type, content));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
			hasError = true;
		}
	}

	private void broadcastBoard() {
		sendMessage(out1, GameMessage.MessageType.BOARD_UPDATE, game.getMaskedBoard());
		sendMessage(out2, GameMessage.MessageType.BOARD_UPDATE, game.getMaskedBoard());
	}

	private void printFinalResults() {
		sendMessage(out1, GameMessage.MessageType.RESULT, "Game Over! Your score: " + score1);
		sendMessage(out2, GameMessage.MessageType.RESULT, "Game Over! Your score: " + score2);

		if (score1 > score2) {
			sendMessage(out1, GameMessage.MessageType.RESULT, "You win!");
			sendMessage(out2, GameMessage.MessageType.RESULT, "You lose!");
		} else if (score2 > score1) {
			sendMessage(out2, GameMessage.MessageType.RESULT, "You win!");
			sendMessage(out1, GameMessage.MessageType.RESULT, "You lose!");
		} else {
			sendMessage(out1, GameMessage.MessageType.RESULT, "Draw!");
			sendMessage(out2, GameMessage.MessageType.RESULT, "Draw!");
		}
	}

	private void updateScore(int playerNumber) {
		if (playerNumber == PLAYER_ONE)
			score1++;
		else
			score2++;
	}
}
