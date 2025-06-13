package BoardOfMessages;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class MyBoardController {

    @FXML
    private Canvas canv;
    
    private LinkedList<Message> msgs;
    private GraphicsContext gc;
    private  final int PIXEL_TO_DEL =  10;
    
    
    public void initialize() {
    	gc = canv.getGraphicsContext2D();
    	msgs = new LinkedList<Message>();
    	
    }
    
    @FXML
    void onCanvasPressed(MouseEvent event) {
    	boolean del = false;
    	for(Message m : msgs) {
    		if(Math.abs(event.getX() - m.getX()) <= PIXEL_TO_DEL) {
    			del = true;
    			msgs.remove(m);
    			break;
    		}
    		
    	}
    	if(!del) {
    		String str = JOptionPane.showInputDialog("Enter Message:");
    		msgs.add(new Message((int)event.getX(), (int)event.getY(), str));
    	}
    	
    	drawMessages();
    	
    }
    
    private void drawMessages() {
    	gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
    	for(Message m : msgs) {
    		gc.strokeText(m.getText(), m.getX(), m.getY());
    	}
    }

}
