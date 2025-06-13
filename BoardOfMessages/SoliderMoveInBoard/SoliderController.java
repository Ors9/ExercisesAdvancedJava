package SoliderMoveInBoard;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class SoliderController {

	@FXML
	private GridPane grid;
	
	private Button[][] buttons;
	private final int SIZE = 10;
	private int currentX, currentY, counter = 1;

	public void initialize() {
		buttons = new Button[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				final int row = i , col = j;
				buttons[i][j] = new Button("");
				buttons[i][j].setPrefSize(grid.getPrefWidth()/SIZE, grid.getPrefHeight()/SIZE);
				buttons[i][j].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
					@Override public void handle(ActionEvent e) {
						handleButton(e, row , col);
					}
				});
				
				grid.add(buttons[i][j], i, j);
			}
		}
		
		Random rand =  new Random();
		currentX = rand.nextInt(SIZE);
		currentY = rand.nextInt(SIZE);
		buttons[currentX][currentY].setText("*");
		buttons[currentX][currentY].setFont(new Font(20));
	}
	
	private void handleButton(ActionEvent e , int row , int col) {
		if(buttons[row][col].getText().equals("")) {
			if(Math.abs(row - currentX) + Math.abs(col - currentY) == 1){
				buttons[currentX][currentY].setText(""+counter);
				buttons[currentX][currentY].setFont(new Font(20));
				buttons[row][col].setText("*");
				buttons[row][col].setFont(new Font(20));
				counter++;
				currentX = row;
				currentY = col;
			}
			
		}
	}

}
