import java.util.ArrayList;
import java.util.HashMap;

public class Lookup<K extends Comparable<K>, V> {
    private HashMap<K, V> table;

    // Constructor
    public Lookup(K[] keys, V[] values) {
        if (keys.length != values.length) {
            throw new IllegalArgumentException("Keys and values arrays must be of equal length");
        }

        table = new HashMap<K,V>();

        for (int i = 0; i < keys.length; i++) {
            table.put(keys[i], values[i]);
        }
    }

    // Add or update a key-value pair
    public void add(K key, V value) {
        table.put(key, value);
    }

    // Get all keys as an ArrayList
    public ArrayList<K> getKeys() {
        if (table.isEmpty()) {
            return null;
        }

        return new ArrayList<K>(table.keySet());
    }                                              

    // Find value by key
    public V find(K key) {
        return table.getOrDefault(key, null);
    }
}
