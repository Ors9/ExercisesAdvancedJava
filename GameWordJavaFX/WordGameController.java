import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class WordGameController {
	private final int CHARS = 7;
	
	@FXML
	private GridPane grid;
	
	@FXML
	private TextField text;
	
	@FXML
	private Button endBtn;
	
	private Button [] btns;
	
	private String [] btnText;
	
	private Dictionary dict;
	
	private int score = 0 ;
	
	public void initialize() {
		btns = new Button[CHARS];
		btnText = new String[CHARS];
		dict = new Dictionary();
		text.setText("");

		
		for(int i = 0 ; i < btns.length ; i ++) {
			int index = i;
			btnText[i] = dict.getRandomLetter();
			btns[i] = new Button(btnText[i]);
			btns[i].setOnAction(new EventHandler<ActionEvent>(){
				
				@Override
				public void handle(ActionEvent e) {
					handleBtnPressed(e,index);
				}
				
			});
			
			btns[i].setPrefSize(grid.getPrefHeight() / CHARS , grid.getPrefWidth() / CHARS);
			
			grid.add( btns[i] , i , 0);
		}
		
	}
	
	private void handleBtnPressed(ActionEvent e , int index) {		
		String connectStr = text.getText() + btnText[index];
		text.setText(connectStr);
		
	}
	
	@FXML
	public void endPressed(ActionEvent e) {
		String userWord = text.getText();
		
		if(userWord.isEmpty()) {
			return;
		}
		
		if(dict.isLegal(userWord)) {
			score += userWord.length();
			JOptionPane.showMessageDialog(null , "~~~~ Good Word! :) , Your points = "+ score +" ~~~~", "Information", JOptionPane.INFORMATION_MESSAGE);
		}else {
			score -= 1;
			JOptionPane.showMessageDialog(null , "~~~~ Wrong Word :( , Your points = "+ score +" ~~~~", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		
		initialize();
	}
	
}
