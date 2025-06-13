import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawingServerCore implements Runnable {
	private static final int PORT = 8888;
	private GraphicsContext gc;

	public DrawingServerCore(Canvas canv , GraphicsContext gc ) {
		this.gc = gc;
	}

	@Override
	public void run() {
		ServerSocket serverSocket;
		Socket socket;

		try {
			serverSocket = new ServerSocket(PORT);

			while (true) {
				socket = serverSocket.accept();
				
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				Rect rect = (Rect) in.readObject();
	            double x = rect.getX();;
	            double y = rect.getY();
	            gc.setFill(Color.BLUE);
	            gc.fillRect(x, y, rect.getHeight(), rect.getWidth());
				
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Server error ");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error get input from server ");
			e.printStackTrace();
		}

	}
}
