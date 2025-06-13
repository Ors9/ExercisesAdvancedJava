import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class ClientSideUI extends Application {

    private static final int RECT_WIDTH = 50;
    private static final int RECT_HEIGHT = 50;

    
    @SuppressWarnings("unused")
	@Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(400, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Handle mouse click on canvas
        Random rand = new Random();
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            double x = rand.nextDouble() * (canvas.getWidth() - RECT_WIDTH);
            double y = rand.nextDouble() * (canvas.getHeight() - RECT_HEIGHT);
            Color color = Color.BLUE;
            
            
            
            gc.setFill(Color.BLUE);
            gc.fillRect(x, y, RECT_WIDTH, RECT_HEIGHT);
            
            Rect rect = new Rect(x, y, RECT_WIDTH, RECT_HEIGHT);
            Thread thread = new Thread(new RectSenderToServer(rect));
            thread.start();

        });

        // Clear button
        Button clearBtn = new Button("Clear");
        clearBtn.setMaxWidth(Double.MAX_VALUE); // make it stretch

        clearBtn.setOnAction(e -> gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()));

        // Layout
        BorderPane root = new BorderPane();
        root.setCenter(new StackPane(canvas)); // center the canvas
        root.setBottom(clearBtn);              // place button at bottom

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("My Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
