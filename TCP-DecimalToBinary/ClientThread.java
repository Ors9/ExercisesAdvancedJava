import java.io.*;
import java.net.*;

public class ClientThread extends Thread {

	private ClientController cont;
	private String ip;
	private Data2 num;
	public ClientThread(ClientController cont, String ip, Data2 num) {
		this.cont = cont;
		this.ip = ip;
		this.num = num;
	}
	public void run() {
		super.run();
		try {
			handleReadAndWrite();
		} catch (Exception e) { e.printStackTrace(); }	
	}  

	public void handleReadAndWrite() throws Exception {
		Socket s = new Socket(ip, 7777);
		OutputStream outputStream = s.getOutputStream();
		ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);

		InputStream inputStream = s.getInputStream();
		ObjectInputStream objInputStream = new ObjectInputStream(inputStream);

		// Write the Data to server
		objOutputStream.writeObject(num);

		// get updated Data from server
		num = (Data2)objInputStream.readObject();
		cont.setBinaryNum(num.getBinaryNum());

		outputStream.close();
		objOutputStream.close();
		inputStream.close();
		objInputStream.close();
		s.close();
	}
}
