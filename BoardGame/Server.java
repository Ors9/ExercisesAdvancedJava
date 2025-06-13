import java.util.LinkedList;
import java.util.Queue;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Server {
	private int port = 7777;
	private Queue<Socket> waitingPlayers = new LinkedList<>();

	public Server(int boardSize) {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			while (true) {
				Socket clientSocket = serverSocket.accept();
				waitingPlayers.add(clientSocket);

				if (waitingPlayers.size() >= 2) {
					Socket p1 = waitingPlayers.poll();
					Socket p2 = waitingPlayers.poll();
					new MemoryGameSession(p1, p2, boardSize).start();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Usage: java Server <boardSize>");
			return;
		}

		int boardSize = Integer.parseInt(args[0]);

		if (boardSize < 2 || boardSize % 2 != 0) {
			System.out.println("Board size must be an even number >= 2.");
			return;
		}

		new Server(boardSize);
	}
}
