import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MagicBoxController extends Thread {

	@FXML
	private Button btn;
	
	@FXML
    private ImageView img;
	
	private boolean stop = false;
	private boolean isVisible = false;

	public void initialize() {
		start();
	}
	
	@Override
	public void run() {
		super.run();
		
		while(!stop) {
			isVisible = !isVisible;
			img.setVisible(isVisible);
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void btnPressed(ActionEvent event) {
		stop = true;
	}
}
