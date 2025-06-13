
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DrawingServerApp extends Application {

	
	private static Canvas canvas;
	private static  GraphicsContext gc;

	@SuppressWarnings("unused")
	@Override
	public void start(Stage primaryStage) {
		canvas = new Canvas(400, 250);
		gc = canvas.getGraphicsContext2D();
	    BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 300);
	    Button clearBtn = new Button("Clear");
	    clearBtn.setMaxWidth(Double.MAX_VALUE);
	    clearBtn.setOnAction(e -> gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()));
	    
	    root.setCenter(new StackPane(canvas));
	    root.setBottom(clearBtn);

		primaryStage.setTitle("Server Side Canvas");
		primaryStage.setScene(scene);
		primaryStage.show();

		DrawingServerCore server = new DrawingServerCore(canvas,gc);
	    Thread thread = new Thread(server);
	    thread.start();
	}

	public static void main(String[] args) {
	    launch(args); 
	}


}
