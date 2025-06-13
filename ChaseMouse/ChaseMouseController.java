import javafx.fxml.FXML;
import javafx.scene.canvas.*;
import javafx.scene.input.MouseEvent;

public class ChaseMouseController {

	@FXML
	private Canvas can;
	private GraphicsContext gc;

    public void initialize() {
		gc = can.getGraphicsContext2D();
	}
	
	@FXML
	void moved(MouseEvent event) {
		gc.clearRect(0, 0, can.getWidth(), can.getHeight());
		gc.fillText("moved", event.getX(), event.getY());
	}
	
	@FXML
	void dragged(MouseEvent event) {
		gc.clearRect(0, 0, can.getWidth(), can.getHeight());
		gc.fillText("dragged", event.getX(), event.getY());
	}
	
	@FXML
	void clicked(MouseEvent event) {
		gc.clearRect(0, 0, can.getWidth(), can.getHeight());
		gc.fillText("clicked", event.getX(), event.getY());
	}
}
