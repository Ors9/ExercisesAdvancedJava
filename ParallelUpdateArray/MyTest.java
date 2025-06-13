public class MyTest {
	public static void main(String[] args) {
		int size = 5;
		ConcArray concArray = new ConcArray(size);

		Worker[] workers = new Worker[size];
		Thread[] threads = new Thread[size];

		for (int i = 0; i < size; i++) {
			workers[i] = new Worker(concArray, i);
			threads[i] = new Thread(workers[i]);
			threads[i].start();
		}

		// Thread שמדפיס כל 10 עדכונים
		Thread printerThread = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				concArray.print();
			}
		});
		printerThread.start();

		// תן לרוץ 10 שניות
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// עצירת כל ה-Workers
		for (Worker w : workers) {
			w.finish();
		}

		// המתן עד שכולם סיימו
		for (Thread t : threads) {
			try {
				t.join();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// עצירת Thread ההדפסה
		printerThread.interrupt();

		try {
			printerThread.join(); // ← כאן מחכים ש-printer 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}



		System.out.println("תוצאה סופית:");
		for (int i = 0; i < size; i++) {
			System.out.println("Index " + i + ": " + concArray.get(i));
		}
	}
}
