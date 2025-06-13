import java.util.ArrayList;


public class ResourceAllocator {

	private ArrayList<Integer> resources;

	public ResourceAllocator(int n) {
		resources = new ArrayList<>();
		for (int i = 0; i < n; i++)
			resources.add(i);
	}

	public synchronized Integer getResouceAllocator() {
		while (resources.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return resources.remove(0);
	}

	public synchronized void releaseResoucer(int num) {
		resources.add(num);
		notifyAll();
	}
	
	
	
	public static void main(String[] args) {

		ResourceAllocator r = new ResourceAllocator(20);
		ResourceThread[] arr = new ResourceThread[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ResourceThread(r);
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i].start();
		}

		for (int i = 0; i < arr.length; i++) {
			try {
				arr[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Done");

	}

}

class ResourceThread extends Thread {

	private final ResourceAllocator r;
	private final int numOfThreads = 5;

	public ResourceThread(ResourceAllocator allocator) {
		this.r = allocator;
	}

	@Override
	public void run() {
		super.run();
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < numOfThreads; i++) {
			res.add(r.getResouceAllocator());
		}
		System.out.println("Using Resources.");
		for (int i = 0; i < numOfThreads; i++) {
			r.releaseResoucer(res.remove(0));
		}
	}

}
