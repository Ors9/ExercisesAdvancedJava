import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @SuppressWarnings("unchecked")
	@Override
    public void run() {
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
            Object obj = in.readObject();

            if (obj instanceof ArrayList<?>) {
                ArrayList<?> receivedList = (ArrayList<?>) obj;

                if (!receivedList.isEmpty() && receivedList.get(0) instanceof Line) {
                    ArrayList<Line> lines = (ArrayList<Line>) receivedList;
                    System.out.println("Received " + lines.size() + " lines from client:");
                    for (Line line : lines) {
                        System.out.printf("Line: (%.1f, %.1f) → (%.1f, %.1f)%n",
                                line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
                    }
                } else {
                    System.out.println("Received list is not of type Line.");
                }
            } else {
                System.out.println("Invalid object received.");
            }
        } catch (Exception e) {
            System.out.println("Error handling client: " + socket.getInetAddress());
            e.printStackTrace();
        }
    }
}
