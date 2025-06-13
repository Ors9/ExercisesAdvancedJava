import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Soldier extends Application{ 
	
	public void start(Stage stage) throws Exception{ 
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("Soldier.fxml")); 
		Scene scene = new Scene(root, 600, 400); 
		stage.setTitle("Soldier"); 
		stage.setScene(scene); 
		stage.show();
	} 
	
	public static void main(String[] args) { 
		launch(args); 
		System.out.println();
	} 
} 