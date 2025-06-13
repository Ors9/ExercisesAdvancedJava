import java.util.ArrayList;
import java.util.Iterator;

public class Group<T> implements Iterable<T>{
	private ArrayList<T> list;
	
	public Group() {
		list = new ArrayList<T>();
	}
	
	public boolean add(T node) {
		if(!list.contains(node)) {
			list.add(node);
			return true;
		}
		return false;
	}
	
	public boolean remove(T node) {
		return list.remove(node);
	}

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

}
