import java.util.ArrayList;

public class Garage {
	private ArrayList<Integer> list;

	public Garage(int n) {
		list = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			list.add(i);
		}
	}
	
	public synchronized int park() {
		while(list.isEmpty()) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		return list.remove(0);
	}
	
	public synchronized void release(int park) {
		list.add(park);
		notifyAll();
	}

}
