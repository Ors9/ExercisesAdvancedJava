
public class Coder implements Runnable {
	private Storage storage;

	public Coder(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		while (true) {
			Data data = storage.getData();
			if (data == null) {
				break;
			}
			String encodedText = encode(data.getText());
			data.setText(encodedText);
			storage.setData(data);

		}
	}

	public String encode(String data) {

		return new StringBuilder(data).reverse().toString();
	}
}
