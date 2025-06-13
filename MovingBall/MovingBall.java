public class MovingBall extends Ball implements Runnable {
    private boolean isFreeze;

    public MovingBall(int x, int y) {
        super(x, y);
        isFreeze = false;
    }

    @Override
    public void run() {
        while (!isFreeze) {
            try {
                Thread.sleep(100); // מושהה ל-100 מילישניות
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
            move(); // הפעולה שנירשת מ-Ball
        }
    }

    public void freeze() {
        isFreeze = true;
    }
    
    public boolean getFreezeStatus() {
    	return isFreeze;
    }
    

}
