public class Ball {
    private int x, y;     // מיקום הכדור
    private int dx, dy;   // כיוון הכדור

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;

        if (Math.random() > 0.5) dx = 1; else dx = -1;
        if (Math.random() > 0.5) dy = 1; else dy = -1;
    }

    public void move() {
        x = x + dx * 10;
        y = y + dy * 10;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void resetDirection() {
        dx = (Math.random() > 0.5) ? 1 : -1;
        dy = (Math.random() > 0.5) ? 1 : -1;
    }
    
    public void setX(int x) {
        this.x = x; 
    }

    public void setY(int y) {
        this.y = y; 
    }
}
