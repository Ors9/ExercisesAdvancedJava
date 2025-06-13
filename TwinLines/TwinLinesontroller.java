import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class TwinLinesontroller {

	@FXML
	private Canvas can1;

	@FXML
	private Canvas can2;

	private GraphicsContext gc1, gc2;
	private double x1,y1;

	public void initialize() {
		gc1 = can1.getGraphicsContext2D();
		gc2 = can2.getGraphicsContext2D();
	}

	@FXML
	void pressed(MouseEvent event) {
		x1 = event.getX();
		y1 = event.getY();
	}

	@FXML
	void released(MouseEvent event) {
		gc1.strokeLine(x1, y1, event.getX(), event.getY());
		gc2.strokeLine(x1, y1, event.getX(), event.getY());
	}
}
