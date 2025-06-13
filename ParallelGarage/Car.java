import java.util.Random;

public class Car implements Runnable{
	public static final int DRIVING_TIME = 10;
	public static final int SECOND_OFFSET = 1000;
	private Garage garage;
	
	public Car(Garage garage) {
		this.garage = garage;
	}

	@Override
	public void run() {
		sleepRandomTime();
		
		int parking = garage.park();
		
		sleepRandomTime();
		
		garage.release(parking);
	}
	
	private void sleepRandomTime() {
		Random r = new Random();
		int time = (int)r.nextInt(DRIVING_TIME);
		
		try {
			Thread.sleep(time * SECOND_OFFSET);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
