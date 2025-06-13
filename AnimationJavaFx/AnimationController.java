import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class AnimationController {

	@FXML
	private Canvas canv;

	@FXML
	private RadioButton circleBtn;

	@FXML
	private ToggleGroup groupButtons;

	@FXML
	private RadioButton rectBtn;

	private GraphicsContext gc;

	private boolean isRect;

	private Thread thread;

	public void initialize() {
		gc = canv.getGraphicsContext2D();
		isRect = true;

	}

	@FXML
	void onCirclePressed(ActionEvent event) {
		isRect = false;
	}

	@FXML
	void onMousePressed(MouseEvent event) {
		ShapeAnimator animator = new ShapeAnimator(gc, event.getX(), event.getY(), isRect);
		thread = new Thread(animator);
		thread.start();

	}

	@FXML
	void onRectPressed(ActionEvent event) {
		isRect = true;

	}

}
