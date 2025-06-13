import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ClientBoardController {
	private final int PORT = 8888;

	@FXML
	private Canvas canv;

	@FXML
	private Button clearBtn;

	@FXML
	private Button sendButton;

	private GraphicsContext gc;

	private ArrayList<Line> lines;

	private double startX, startY, endX, endY;

	public void initialize() {
		gc = canv.getGraphicsContext2D();
		lines = new ArrayList<Line>();

	}

	@FXML
	public void canvPressed(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
	}

	@FXML
	public void canvReleased(MouseEvent e) {
		endX = e.getX();
		endY = e.getY();

		gc.strokeLine(startX, startY, endX, endY);
		lines.add(new Line(startX, startY, endX, endY));
	}

	@FXML
	public void clearPressed(ActionEvent e) {
		lines.removeAll(lines);
		gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
	}

	@FXML
	public void sendPressed(ActionEvent e) {
		try {
			String ip = Client.getServerIP();
			Socket socket = new Socket(ip, PORT);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(lines);
			out.flush();
			out.close();
			socket.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
