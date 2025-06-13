import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ColorsController {
	
	@FXML
	private BorderPane b1;
	@FXML
	private BorderPane b2;
	
	public Button[] arrayButtons;

	

	@FXML
	void bluePressed(ActionEvent event) {
	    b1.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	@FXML
	void greenPressed(ActionEvent event) {
		b2.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
