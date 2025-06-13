
public class Rectangle {
	private double squareSide;
	private double x , y;
	
	public Rectangle(double x , double y , double squareSide ) {
		this.squareSide = squareSide;
		this.x = x;
		this.y = y;
	}
	
	public double getSquareSide() {
		return squareSide;
	}
	

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public boolean contains(double px, double py) {
	    return (px >= x && px <= x + squareSide &&
	            py >= y && py <= y + squareSide);
	}
	
}
