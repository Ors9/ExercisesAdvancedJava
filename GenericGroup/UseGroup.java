import java.util.ArrayList;

public class UseGroup {
	public static <T extends Comparable<T>> ArrayList<T> boundedGroup( Group<T> g , T upperBound ){
		ArrayList<T> newList = new ArrayList<T>();
		for(T item : g) {
			if(item.compareTo(upperBound) < 0) {
				newList.add(item);
			}
		}
		
		return newList;
	}
	
	public static void main(String[] args) {
	    // יצירת קבוצה של מספרים שלמים
	    Group<Integer> g = new Group<>();

	    // הוספת איברים לקבוצה
	    g.add(3);
	    g.add(5);
	    g.add(10);
	    g.add(12);
	    g.add(7);
	    g.add(5); // כפול, לא ייכנס

	    // הדפסת כל האיברים בקבוצה
	    System.out.println("Original Group:");
	    for (int x : g) {
	        System.out.println(x);
	    }

	    // קריאה ל-boundedGroup עם גבול עליון 10
	    ArrayList<Integer> filtered = boundedGroup(g, 10);

	    // הדפסת האיברים הקטנים מהגבול העליון
	    System.out.println("\nFiltered Group (< 10):");
	    for (int x : filtered) {
	        System.out.println(x);
	    }
	}

}
