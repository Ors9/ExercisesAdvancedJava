
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;

public class CircleController {

	@FXML
	private Canvas canv;

	@FXML
	private Button downBtn;

	@FXML
	private Button leftBtn;

	@FXML
	private Button rightBtn;

	@FXML
	private Button upButton;

	private GraphicsContext gc;
	private final int DIAMETER = 20;
	private final int PIXELS = 20;
	
	public enum Direction {
	    UP, DOWN, LEFT, RIGHT
	}

	private double currX, currY;

	public void initialize() {
		gc = canv.getGraphicsContext2D();

		fillCircleAtMid();
	}

	private void fillCircleAtMid() {
		gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
		currX = canv.getWidth() / 2;
		currY = canv.getHeight() / 2;
		gc.fillOval(currX, currY, DIAMETER, DIAMETER);

	}

	@FXML
	void downPressed(ActionEvent event) {
		buttonPressed(Direction.DOWN);
	}

	@FXML
	void leftPressed(ActionEvent event) {
		buttonPressed(Direction.LEFT);
	}

	@FXML
	void rightPressed(ActionEvent event) {
		buttonPressed(Direction.RIGHT);
	}

	@FXML
	void upPressed(ActionEvent event) {
		buttonPressed(Direction.UP);
	}

	private void buttonPressed(Direction side) {
		
		fixPressed(side);
		
		if (currX < 0 || currX > canv.getWidth() || currY < 0 || currY > canv.getHeight()) {
		    fillCircleAtMid();
		    return;
		}


		gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
		gc.fillOval(currX, currY, PIXELS, PIXELS);

	}
	
	private void fixPressed(Direction side) {
		switch (side) {
	    case Direction.UP:
	        currY -= PIXELS; 
	        break;
	    case Direction.RIGHT:
	        currX += PIXELS; 
	        break;
	    case Direction.LEFT:
	        currX -= PIXELS; 
	        break;
	    case Direction.DOWN:
	        currY += PIXELS; 
	        break;
	}
	}

}
