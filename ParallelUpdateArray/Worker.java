import java.util.Random;

public class Worker implements Runnable {
	private ConcArray concArr;
	private int myIndex;
	private final int RAND_TIME = 5000;
	private final int RAND_VALUE = 100;
	private volatile boolean finished;

	public Worker(ConcArray concArr, int myIndex) {
		this.concArr = concArr;
		this.myIndex = myIndex;
		finished = false;
	}

	public void finish() {
		finished = true;
	}

	@Override
	public void run() {
		Random r = new Random();
		while (!finished) {
			int time = (int) r.nextInt(RAND_TIME);

			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
	            return;
			}

			int value = (int) r.nextInt(RAND_VALUE) + 1;
			concArr.update(myIndex, value);
		}

	}

}
