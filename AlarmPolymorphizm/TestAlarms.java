import java.util.ArrayList;

public class TestAlarms {

	public static void main(String[] args) {
		ArrayList<Alarm> arrTypes = new ArrayList<Alarm>();
		try {
			arrTypes.add(new Fire("Haifa", "Or"));
			arrTypes.add(new Elevator("Tel Aviv", 5));
			arrTypes.add(new Smoke("Jerusalem", "Dana"));
			arrTypes.add(new Smoke("Eilat", "Rami"));
			arrTypes.add(new Fire("Be'er Sheva", "Noa"));
			arrTypes.add(new Elevator("Netanya", 7));
			arrTypes.add(new Smoke("Ashdod", "Gil"));
			arrTypes.add(new Fire("Herzliya", "Tamar"));
			arrTypes.add(new Elevator("Holon", 2));
			arrTypes.add(new Smoke("Acre", "Yoni"));
			arrTypes.add(new Elevator("Rishon LeZion", 4));

			process(arrTypes);

		} catch (BadAlarm e) {
			System.out.println("Alarm creation failed: " + e.getMessage());
		}
	}

	public static void process(ArrayList<Alarm> arrTypes) {
		int count = 0;
		for (Alarm item : arrTypes) {
			item.action();

			if (item instanceof Smoke) {
				count++;
			}

			if (item instanceof Elevator) {
				((Elevator) item).reset();
			}
		}

		System.out.println("Number of Smoke Alarms = " + count);
	}
}
