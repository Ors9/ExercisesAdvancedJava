import java.util.Map;
import java.util.TreeMap;

public class SortedTable<T extends Comparable<T> , E> {
	private TreeMap <T,E> map;
	
	public SortedTable() {
		map = new TreeMap<T,E>();
	}
	
	
	public void add(T key , E value) throws AlreadyExistException{
		if(map.containsKey(key)) {
			throw new AlreadyExistException();
		}
		map.put(key, value);
		
		
	}
	
	public void remove(T key) {
		map.remove(key);
	}
	
	public void remove() {
	    if (!map.isEmpty()) {
	        map.remove(map.firstKey());
	    }
	}
	
	public void display() {
		for(Map.Entry <T,E> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
