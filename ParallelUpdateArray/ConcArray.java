public class ConcArray extends Thread {
	private int arr[];
	private int countUpdate;
	private final int MAX_UPDATE = 10;
	private boolean printing;

	public ConcArray(int m) {
		arr = new int[m]; // all initialized automatically to 0
		countUpdate = 0;
		printing = false;
	}

	public synchronized void update(int i, int val) {
		if (i < 0 || i >= arr.length) {
			throw new IllegalArgumentException("Invalid index");
		}

		while (countUpdate >= MAX_UPDATE || printing) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}

		arr[i] = val;
		countUpdate++;
		notifyAll();
	}

	public synchronized void print() {
		while (countUpdate < MAX_UPDATE) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
		}

		printing = true;
		countUpdate = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		printing = false;
		notifyAll();
	}

	public synchronized int get(int index) {
		return arr[index];
	}
}
