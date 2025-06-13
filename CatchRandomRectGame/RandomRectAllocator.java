import java.util.ArrayList;
import javax.swing.JOptionPane;
import javafx.scene.canvas.GraphicsContext;

public class RandomRectAllocator extends Thread {
	private static final int x = 1200;

	private GraphicsContext gc;
	private ArrayList<Rectangle> rects;

	private int currentIndex = -1;
	private int countRight = 0, countWrong = 0;

	public RandomRectAllocator(GraphicsContext gc, ArrayList<Rectangle> rects) {
		this.gc = gc;
		this.rects = rects;

	}

	@Override
	public void run() {
		for (int i = 0; i < rects.size(); i++) {
			currentIndex = i;
			gc.clearRect(0, 0, RandomRectController.windowSize, RandomRectController.windowSize);
			Rectangle r = rects.get(i);
			gc.strokeRect(r.getX(), r.getY(), r.getSquareSide(), r.getSquareSide());
			try {
				Thread.sleep(x);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		currentIndex = -1; // סימון שהמשחק נגמר
		gc.clearRect(0, 0, RandomRectController.windowSize, RandomRectController.windowSize);
		JOptionPane.showMessageDialog(null, "Score: " + (2 * countRight - countWrong));

	}

	public void handleClick(double x, double y) {
		if (currentIndex != -1) {
			Rectangle r = rects.get(currentIndex);
			double rectX = r.getX();
			double rectY = r.getY();
			double side = r.getSquareSide();

			// Check if click is inside the rectangle bounds
			if (x >= rectX && x <= rectX + side && y >= rectY && y <= rectY + side) {
				countRight++;
			} else {
				countWrong++;
			}
		}
	}

	

	public int getCountRight() {
		return countRight;
	}

	public int getCountWrong() {
		return countWrong;
	}

}
