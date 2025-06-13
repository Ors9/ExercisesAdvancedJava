import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class QuizController {

	@FXML
	private TextArea text;

	@FXML
	private GridPane grid;

	@FXML
	private RadioButton btnTrue;
	
	@FXML
	private RadioButton btnFalse;

	@FXML
	private ToggleGroup choice;

	private Questions q;
	private Question qu;
	private int count;

	public void initialize() {
		String str = JOptionPane.showInputDialog("How many questions?");
		count = Integer.parseInt(str);

		q = new Questions();

		setQuestion();
	}

	@FXML
	void answerSelected(ActionEvent event) {
		if (qu.getAns() && btnTrue.isSelected() ||
				!qu.getAns() && btnFalse.isSelected())
				JOptionPane.showConfirmDialog(null, "Correct!", "Correct!", JOptionPane.CLOSED_OPTION);
			else
				JOptionPane.showConfirmDialog(null, "Incorrect!", "Incorrect!", JOptionPane.CLOSED_OPTION);

			setQuestion();
	}

	private void setQuestion() {
		if (count == 0) {
			JOptionPane.showConfirmDialog(null, "Game over", "Game over!", JOptionPane.CLOSED_OPTION);
			System.exit(0);
		}
		else {
			count--;
			btnTrue.setSelected(false);
			btnFalse.setSelected(false);
			qu = q.getRandomQuestion();
			text.setText(qu.getText());
		}
	}
}
