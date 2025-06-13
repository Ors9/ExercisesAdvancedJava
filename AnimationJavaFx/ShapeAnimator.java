import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;

public class ShapeAnimator implements Runnable {

	private final GraphicsContext gc;
	private final double startX;
	private final double startY;
	private final boolean isRect;
	private final int SLEEP_TIME = 200;
	private final int SHAPE_COUNT = 100;

	public ShapeAnimator(GraphicsContext gc, double startX, double startY, boolean isRect) {
		this.gc = gc;
		this.startX = startX;
		this.startY = startY;
		this.isRect = isRect;
	}

	@Override
	public void run() {

		for (int i = 0; i < SHAPE_COUNT; i++) {
			final int size = 1 + i;
			final double x = startX + i;
			final double y = startY + i;

			Platform.runLater(new Runnable() {
				public void run() {
					if (isRect) {
						gc.fillRect(x, y, size, size);
					} else {
						gc.fillOval(x, y, size, size);
					}
				}
			});

			safeSleep();
		}
	}

	private void safeSleep() {
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
