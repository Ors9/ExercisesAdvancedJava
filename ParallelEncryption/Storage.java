import java.util.ArrayList;

public class Storage {
	private ArrayList<Data> data;
	private boolean[] isTaken;
	private int encryptedCount = 0;

	public Storage(ArrayList<Data> data) {
		this.data = data;
		isTaken = new boolean[data.size()]; // כל הערכים false
	}

	public synchronized Data getData() {
		for (int i = 0; i < isTaken.length; i++) {
			if (!isTaken[i]) {
				isTaken[i] = true;
				Data d = data.get(i);
				return new Data(i, d.getText());
			}
		}
		return null;
	}

	public synchronized void setData(Data data) {
		this.data.set(data.getPos(), data);
		encryptedCount++;
		notifyAll();
	}

	public synchronized String[] getResult() {
		while (encryptedCount < data.size()) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		String[] result = new String[data.size()];
		for (int i = 0; i < data.size(); i++) {
			result[i] = data.get(i).getText();
		}
		return result;
	}
}
