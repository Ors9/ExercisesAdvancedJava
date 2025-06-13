import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: java Client <server_ip> <port>");
			return;
		}

		String serverIP = args[0];
		int port = Integer.parseInt(args[1]);

		try (Socket socket = new Socket(serverIP, port);
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				Scanner scanner = new Scanner(System.in)) {
			while (true) {
				GameMessage msg = (GameMessage) in.readObject();

				switch (msg.getType()) {
				case BOARD_UPDATE:
					System.out.println(msg.getContent());
					break;

				case INFO:
					System.out.println("INFO: " + msg.getContent());
					break;

				case PLAYER_PROMPT:
					System.out.print(msg.getContent() + " ");
					String input = scanner.nextLine();
					GameMessage response = new GameMessage(GameMessage.MessageType.CHOICE_RESPONSE, input);
					out.writeObject(response);
					out.flush();
					break;

				case RESULT:
					System.out.println("GAME RESULT: " + msg.getContent());
					return;
				case CHOICE_RESPONSE:
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Connection closed or error occurred.");
			e.printStackTrace();
		}
	}
}
