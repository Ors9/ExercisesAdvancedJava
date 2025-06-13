import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class ChaseMouse extends Application{ 
	
	public void start(Stage stage) throws Exception{ 
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("ChaseMouse.fxml")); 
		Scene scene = new Scene(root); 
		stage.setTitle("ChaseMouse"); 
		stage.setScene(scene); 
		stage.show(); 
	} 
	
	public static void main(String[] args) { 
		launch(args); 
		System.out.println();
	} 
} 