import java.util.Date;

public class Elevator extends Alarm {
	private int floor;

	public Elevator(String address, int floor) throws BadAlarm {
		super(address, new Date());
		this.floor = floor;
	}

	@Override
	public void action() {
		super.action();
		System.out.println("Floor: " + floor);
	}

	public void reset() {
		floor = 0;
	}

}
