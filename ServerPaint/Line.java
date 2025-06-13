import java.io.Serializable;

public class Line implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private double startX , startY;
	private double endX , endY;
	
	public Line(double startX, double startY, double endX, double endY) {
	    this.startX = startX;
	    this.startY = startY;
	    this.endX = endX;
	    this.endY = endY;
	}
	

	public double getStartX() {
		return this.startX ;
	}
	
	public double getStartY() {
		return this.startY;
	}
	
	
	public double getEndX() {
		return this.endX;
	}
	
	public double getEndY() {
		return this.endY;
	}
	
	public void setStartX(double startX) {
		this.startX  = startX;
	}
	
	public void setStartY(double startY) {
		this.startY = startY;
	}
	
	public void setEndX(double endX) {
		this.endX = endX;
	}
	
	public void setEndY(double endY) {
		this.endY = endY;
	}
}
