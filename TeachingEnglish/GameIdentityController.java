import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class GameIdentityController {

	@FXML
	private ImageView imgView;

	@FXML
	private TextField textField;

	private int countRightAnswer = 0, countAppearance = 0;

	private Picture picture;

	public void initialize() {
		newPicture();
	}

	@FXML
	public void stopPressed(ActionEvent e) {
		if(countAppearance == 0) {
			JOptionPane.showMessageDialog(null, "You cant stop what you didnt start....", "Message", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		double percent = (countRightAnswer * 100.0) / countAppearance;

		
		JOptionPane.showMessageDialog(null, "The percent of right answers is: " + String.format("%.1f", percent) + "%", "Message", JOptionPane.INFORMATION_MESSAGE);
		countAppearance = 0;
		countRightAnswer = 0;
		newPicture();
	}

	@FXML
	public void checkPressed(ActionEvent e) {
		String text = textField.getText();

		if (text.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insert text!", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}

		countAppearance++;

		if (text.equals(picture.getText())) {
			countRightAnswer++;
		}
		newPicture();
	}

	private void newPicture() {
		picture = new Picture();
		imgView.setImage(picture.getImage());
		textField.setText("");
	}
}
