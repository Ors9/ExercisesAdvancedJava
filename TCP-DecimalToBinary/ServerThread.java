import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket s = null;
	public ServerThread(Socket socket) {
		this.s = socket;
	}
	@Override
	public void run() {
		super.run();
		try {
			handleReadAndWrite();
		}    
		catch (Exception e) {  }
	}    

	public void handleReadAndWrite() throws Exception{
		OutputStream outputStream = s.getOutputStream();
		ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
		InputStream inputStream = s.getInputStream();   
		ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
		// get Data from client
		Data2 n;
		n = (Data2)objInputStream.readObject();
		// process the number and send Data to client
		n.setBinaryNum(Integer.toBinaryString(n.getNum()));
		objOutputStream.writeObject(n);
		objInputStream.close();
		inputStream.close();
		objOutputStream.close();
		outputStream.close();
		s.close();
	}
}