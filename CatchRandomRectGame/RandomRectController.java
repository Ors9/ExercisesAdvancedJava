import java.util.ArrayList;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class RandomRectController{
	private static final int squareSide = 30;
	public static final int windowSize = 400;
	public static final int n = 10;
	
	@FXML
	private Canvas canv;
	
	private GraphicsContext gc;
	private ArrayList<Rectangle> rects;
	private Thread thread;
	private RandomRectAllocator allocator;
	
	public void initialize() {
		gc = canv.getGraphicsContext2D();
		rects = new ArrayList<Rectangle>();
		allocator = new RandomRectAllocator(gc, rects);
		Random r = new Random();
		
		for(int i = 0 ; i < n ; i++) {
			int x = (int)r.nextInt(windowSize - squareSide);
			int y =  (int)r.nextInt(windowSize - squareSide);
			rects.add(new Rectangle(x,y,squareSide));
		}
		
		startTheThread();
	}
	
	
	public void canvPressed(MouseEvent e) {
		allocator.handleClick(e.getX() , e.getY());
	}	
	
	private void startTheThread() {
		thread = new Thread(allocator);
		thread.setDaemon(true);
		thread.start();
	}

}
