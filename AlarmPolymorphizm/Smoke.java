import java.text.SimpleDateFormat;
import java.util.Date;

public class Smoke extends Alarm {
	private String name;

	public Smoke(String address, String name) throws BadAlarm {
		super(address, new Date());
		this.name = name;
	}

	@Override
	public void action() {
		super.action();
		System.out.println(" Name: " + name);
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH"); // HH = 24-hour format
		return sdf.format(time);
	}

}
