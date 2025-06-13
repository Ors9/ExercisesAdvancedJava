import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// 1. ניצור רשימת מחרוזות מקורית
		ArrayList<Data> list = new ArrayList<>();
		list.add(new Data(0, "hello"));
		list.add(new Data(1, "world"));
		list.add(new Data(2, "java"));
		list.add(new Data(3, "rocks"));

		// 2. ניצור את המאגר
		Storage storage = new Storage(list);

		// 3. ניצור כמה תהליכים (נגיד 3)
		int numThreads = 3;
		Thread[] threads = new Thread[numThreads];

		for (int i = 0; i < numThreads; i++) {
			threads[i] = new Thread(new Coder(storage));
			threads[i].start();
		}

		// 4. נחכה שכל התהליכים יסיימו
		for (int i = 0; i < numThreads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 5. נדפיס את התוצאה הסופית
		String[] result = storage.getResult();
		System.out.println("תוצאה מוצפנת:");
		for (String s : result) {
			System.out.println(s);
		}
	}
}
