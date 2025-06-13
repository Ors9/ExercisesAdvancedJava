import java.util.ArrayList;
import java.util.Collections;

public class LookupPrinter {
    public static void printSortedByKey(Lookup<String, Integer> table) {
        ArrayList<String> keys = table.getKeys();
        if (keys == null) return;

        Collections.sort(keys); // מיון לקסיקוגרפי לפי מפתח

        for (String key : keys) {
            Integer value = table.find(key);
            System.out.println(key + " -> " + value);
        }
    }
    
    public static void main(String []args) {
    	String [] keys = {"Maya Malkis" , "Or Saban" , "Noy Saban" , "Nissan Saban" , "A" , "B"};
    	Integer [] vals = { 23 , 25 , 25 , 27 , 1 , 0};
    	
    	Lookup<String , Integer> map = new Lookup<String , Integer>(keys , vals);
    	
    	LookupPrinter.printSortedByKey(map);
    	
    }
}
