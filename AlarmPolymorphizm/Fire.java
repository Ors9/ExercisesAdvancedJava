import java.util.Date;

public class Fire extends Alarm {
	private boolean active;
	private String name;

	public Fire(String address, String name) throws BadAlarm {
		super(address, new Date());
		this.setName(name);
		setActive(true);
	}

	@Override
	public void action() {
		setActive(false);
		super.action();
		System.out.println(" Name: " + name);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
