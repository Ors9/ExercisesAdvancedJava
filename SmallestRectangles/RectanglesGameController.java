import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class RectanglesGameController {
	private static final int NUM_OF_RECTS = 10;
	private static final int NUM_OF_PIXELS = 90;

	@FXML
	private Canvas canv;

	private GraphicsContext gc;
	private ArrayList<Rectangle> arrRects;
	private int countWrongClicks;

	public void initialize() {
		gc = canv.getGraphicsContext2D();
		initializeRectangles();
	}

	@FXML
	void onCanvPressed(MouseEvent event) {

		Rectangle smallest = arrRects.get(0);
		if (smallest.contains(event.getX(), event.getY())) {
			arrRects.remove(0);
			checkIfGameEnd();
			gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
			for(Rectangle r : arrRects) {
				gc.strokeRect(r.getX(), r.getY(), r.getSquareSide(), r.getSquareSide());
			}
		} else {
			countWrongClicks++;
		}

	}

	private void checkIfGameEnd() {
		if (arrRects.isEmpty()) {
			JOptionPane.showMessageDialog(null, "The number of mistakes: " + countWrongClicks);
			initializeRectangles();
		}

	}

	private void initializeRectangles() {
		gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
		arrRects = new ArrayList<Rectangle>();
		countWrongClicks = 0;
		Random r = new Random();
		for (int i = 0; i < NUM_OF_RECTS; i++) {
			double x = (double) r.nextDouble(canv.getWidth() - NUM_OF_PIXELS - 10);
			double y = (double) r.nextDouble(canv.getHeight() - NUM_OF_PIXELS - 10);
			int squareSide = (int) r.nextInt(NUM_OF_PIXELS) + 10;
			arrRects.add(new Rectangle(x, y, squareSide));
			gc.strokeRect(x, y, squareSide, squareSide);
		}
		sortList();

	}

	private void sortList() {
		Collections.sort(arrRects, new Comparator<Rectangle>() {
			@Override
			public int compare(Rectangle r1, Rectangle r2) {
				return Double.compare(r1.getSquareSide(), r2.getSquareSide());
			}
		});
	}

}
