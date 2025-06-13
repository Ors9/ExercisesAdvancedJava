package BoardOfMessages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyBoard extends Application {

	/**
	 * Entry point for the JavaFX application. Loads the FXML file, sets up the
	 * scene and stage properties.
	 *
	 * @param stage the primary window for the application
	 * @throws Exception if FXML loading fails
	 */
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("MyBoard.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("MyBoard Excersice");
		stage.setScene(scene);
		stage.setWidth(500);
		stage.setHeight(500);
		stage.show();

		stage.setMinWidth(500);
		stage.setMinHeight(500);
	}

	public static void main(String[] args) {
		launch(args);
		System.out.println();
	}
}
