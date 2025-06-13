import java.util.Date;

public abstract class Alarm {
	public String address;
	public Date time;

	public Alarm(String address, Date time) throws BadAlarm {
		if (address == null) {
			throw new BadAlarm("Address is null");
		}

		this.address = address;
		this.time = time;
	}

	public void action() {
		System.out.println("Address: " + address + "\n Time: " + time.toString());
	}
}
