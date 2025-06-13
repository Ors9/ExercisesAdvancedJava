
public class MyMain {
	public static final int GARAGE_PLACES = 30;
	public static final int NUM_OF_CARS = 100;
	
	public static void main(String []args) {
		Garage garage = new Garage(GARAGE_PLACES);
		Car [] cars = new Car[NUM_OF_CARS];
		Thread [] threads = new Thread[NUM_OF_CARS];
		
		for(int i = 0 ; i < cars.length ; i++) {
			cars[i] = new Car(garage);
			threads[i] = new Thread(cars[i]);
			threads[i].start();
		}
		
		for(int i = 0 ; i < threads.length ; i ++) {
			try {
				threads[i].join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		System.out.println("All cars finished parking and leaving.");
	}
}
