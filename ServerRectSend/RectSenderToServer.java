import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class RectSenderToServer implements Runnable{
	private static final int PORT = 8888;
	private Rect rect;
	
	public RectSenderToServer(Rect rect) {
		this.rect = rect;
	}
	
	@Override
	public void run() {
		try (Socket socket = new Socket("localhost", PORT)) {
			
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(rect);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error write input to server ");
			e.printStackTrace();
		}
	}
}
