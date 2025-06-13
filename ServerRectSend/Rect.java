import java.io.Serializable;

public class Rect implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private double x;
    private double y;
    private double width;
    private double height;


    public Rect(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Getters
    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }


    // Optional: convert to string for sending to server
    public String toMessage() {
        return x + "," + y + "," + width + "," + height;
    }
}
