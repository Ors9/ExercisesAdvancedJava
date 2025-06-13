import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Exercise1_IsSorted {
    public static void main(String[] args) {
    	ArrayList<Student> list = new ArrayList<>();
    	Random rand = new Random();

    	String[] names = {"Alice", "Bob", "Charlie", "Dor", "Or", "Maya", "Lior", "Neta", "Tal", "Yossi"};

    	for (String name : names) {
    	    int grade = rand.nextInt(101); 
    	    list.add(new Student(name, grade));
    	}

        System.out.println("== Students ==");
        for (Student s : list) {
            System.out.println(s);
        }

        try {
            boolean sorted = isSorted(list);
            System.out.println("\nIs the list sorted by grade? " + sorted);
        } catch (IllegalData e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        
        
        System.out.println("\n== Sorted Students ==");
        list.sort(Comparator.naturalOrder());
        for (Student s : list) {
            System.out.println(s);
        }

        try {
            boolean sortedAfter = isSorted(list);
            System.out.println("\nIs the list sorted by grade after sort()? " + sortedAfter);
        } catch (IllegalData e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    // Generic isSorted function
    public static <T extends Comparable<T>> boolean isSorted(ArrayList<T> arr) throws IllegalData {
        if (arr == null || arr.size() == 0) {
            throw new IllegalData("List is null or empty");
        }

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i).compareTo(arr.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    // Custom exception
    public static class IllegalData extends Exception {
        private static final long serialVersionUID = 1L;

        public IllegalData(String message) {
            super(message);
        }
    }

    // Student class with Comparable
    public static class Student implements Comparable<Student> {
        private String name;
        private int grade;

        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', grade=" + grade + "}";
        }

        @Override
        public int compareTo(Student other) {
            return Integer.compare(this.grade, other.grade);
        }
    }
}
