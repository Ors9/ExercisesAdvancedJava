import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class BallPainter implements Runnable {
	private MovingBall movingBall;
	private GraphicsContext gc;
	private Canvas canv;

	public BallPainter(MovingBall movingBall, GraphicsContext gc, Canvas canv) {
		this.movingBall = movingBall;
		this.gc = gc;
		this.canv = canv;

	}

	@Override
	public void run() {
		while (!movingBall.getFreezeStatus()) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				break;
			}

			Platform.runLater(new Runnable() {
				public void run() {
					if (outOfBounds()) {
						movingBall.setX((int)(canv.getWidth() / 2));
						movingBall.setY((int)(canv.getHeight() / 2));
						movingBall.resetDirection();
					}

					gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
					gc.fillOval(movingBall.getX(), movingBall.getY(), 10, 10);
				}
			});
		}
	}

	private boolean outOfBounds() {
		return movingBall.getX() < 0 ||
		       movingBall.getY() < 0 ||
		       movingBall.getX() > canv.getWidth() ||
		       movingBall.getY() > canv.getHeight();
	}

}
