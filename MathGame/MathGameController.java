import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class MathGameController {
	private final int LINE = 25;
	private final int FREE = -1;
	
	@FXML
	private GridPane grid;
	
	private Button btns [];
	
	private int first = FREE , second  = FREE , countRightAnswers = 0;
	
	public void initialize() {
		btns = new Button [LINE];
		for(int i = 0 ; i < LINE ; i++) {
			int value = i + 1;
			btns[i] = new Button(value + "");
			
			btns[i].setPrefSize(grid.getPrefHeight() / 5 , grid.getPrefWidth() / 5);
			
			btns[i].setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					handleButton(e , value);
				}
			});
			
			grid.add( btns[i] , i % 5 , i / 5);
		}
		
	}
	
	public void handleButton(ActionEvent e , int value) {
		if(first == FREE) {
			first = value;
			return;
		}
		if(second == FREE) {
			second = value;
			return;
		}
		
		if(first + second == value) {
			countRightAnswers++;
			btns[first - 1].setText("");
			btns[second - 1].setText("");
			btns[value - 1].setText("");
			btns[first - 1].setDisable(true);
			btns[second - 1].setDisable(true);
			btns[value - 1].setDisable(true);
		}else {
			JOptionPane.showMessageDialog(null, "The value "+first+"+" + second +" is not "+value, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		first = FREE;
		second = FREE;
	}
	
	@FXML
	public void finishAction(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "The number of right answers is: " + countRightAnswers , "Finished",JOptionPane.INFORMATION_MESSAGE);
	}
	
}
