import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {

    private static final int PORT = 8888;

    public static void main(String[] args) {
        System.out.println("Server started. Listening on port " + PORT + "...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept(); // מקבל לקוח
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // מפעיל תהליך חדש לטיפול בלקוח
                new ClientHandler(clientSocket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
