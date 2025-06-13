import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class SoldierController {

	@FXML
	private GridPane grid;

	private Button[][] buttons;
	private final int SIZE = 10;
	private int currentX, currentY, counter = 1;

	public void initialize() {
		buttons = new Button[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				final int row = i, col = j;
				buttons[i][j] = new Button("");
				buttons[i][j].setPrefSize(grid.getPrefWidth() / SIZE, grid.getPrefHeight() / SIZE);
				buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {

					@Override 
					public void handle(ActionEvent e) {
						handleButton(e, row, col);
					}
				});
				grid.add(buttons[i][j], i, j);
			}
		}	
		Random r = new Random();
		currentX = r.nextInt(SIZE);
		currentY = r.nextInt(SIZE);
		buttons[currentX][currentY].setText("*");
	}

	private void handleButton(ActionEvent e, int i, int j) {
		if (buttons[i][j].getText().equals("") && Math.abs(i - currentX) + 
				Math.abs(j - currentY) == 1) {
			buttons[currentX][currentY].setText("" + counter);
			buttons[i][j].setText("*");
			counter++;
			currentX = i;
			currentY = j;
		}
	}
}