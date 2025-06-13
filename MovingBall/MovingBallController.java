import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class MovingBallController {
	
	@FXML
	private Canvas canv;
	
	private GraphicsContext gc;
	private Thread ballThread ;
	private BallPainter painter;
	private Thread painterThread;
	private MovingBall movingBall;
	
	public void initialize() {
		gc = canv.getGraphicsContext2D();
		movingBall = new MovingBall((int)(canv.getHeight() / 2), (int)(canv.getWidth() /2) );
		
		ballThread  = new Thread(movingBall);
		ballThread .setDaemon(true);
		ballThread .start();
		

		
		painter = new BallPainter( movingBall,  gc,  canv );
		painterThread = new Thread(painter);
		painterThread .setDaemon(true);
		painterThread .start();
		
		
	}
	

	
	
}
