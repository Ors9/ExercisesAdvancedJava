import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client  extends Application{
	
	private static String serverIP;
	
	//add argoument 127.0.0.1
	public static void main(String []args) {
        if (args.length < 1) {
            System.out.println("Usage: java Main <server_ip>");
            System.exit(1);
        }
        serverIP = args[0];
        launch(args);
	}
	
    public static String getServerIP() {
        return serverIP;
    }
    
    
    
	@SuppressWarnings("unused")
	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Board.fxml")));
		stage.setTitle("Client Drawing Board");
		stage.setScene(scene);
		stage.setOnCloseRequest(e -> System.exit(0));
		stage.show();
	}
    
}
