import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Quiz extends Application{ 
	
	public void start(Stage stage) throws Exception{ 
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("Quiz.fxml")); 
		Scene scene = new Scene(root, 300, 200); 
		stage.setTitle("Quiz"); 
		stage.setScene(scene); 
		stage.show(); 
	} 
	
	public static void main(String[] args) { 
		launch(args); 
		System.out.println();
	} 
} 