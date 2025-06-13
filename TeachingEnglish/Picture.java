import java.util.Random;

import javafx.scene.image.Image;

public class Picture {
	private Image image; // התמונה עצמה
	private String text; // שם התמונה באנגלית

	private final int numOfPic = 3;
	private String[] textPool = { "scot", "scot2", "toy2" };
	private Image[] picturePool = { new Image("scot.jpg"), new Image("scot2.jpg"), new Image("toy2.jpg") };

	// בנאי עם פרמטרים – אם רוצים ליצור תמונה עם ערכים
	public Picture() {
		Random r = new Random();
		int randomIndex = (int) r.nextInt(numOfPic);
		text = textPool[randomIndex];
		image = picturePool[randomIndex];
	}

	// מחזיר את התמונה
	public Image getImage() {
		return image;
	}

	// מחזיר את שם התמונה
	public String getText() {
		return text;
	}

	// (רשות) מתודה להדפסה נוחה של מידע
	@Override
	public String toString() {
		return "Picture{text='" + text + "'}";
	}
}
