package src.test.java.com.HarlanHunter.InventoryProject;
import java.util.Iterator;

/**
 * Interface for Dictionary ADT. Your HashDictionary class should implement
 * this interface.
 * @author Hunter M Shaw
 */
public interface Dictionary<K,V> {
    /**
     * This returns an iterator over the collection of keys.
     * @return key iterator
     */
    public Iterator<K> keys();
    
    /**
     * This returns an iterator over the collection of values.
     * @return values iterator
     */
    public Iterator<V> elements();
    
    /**
     * If the key is in the collection of keys, return the associated
     * value. Otherwise, return null.
     * Precondition: key != null
     * @param key
     * @return value associated with key
     */
    public V get(K key);
    
    /**
     * If the key is in the collection of keys, return the associated
     * value and remove both key and value. Otherwise, return null and leave
     * collections unaltered.
     * Precondition: key != null
     * Postcondition: key, and associated value (if any), are not in dictionary
     * @param key
     * @return value associated with key
     */
    public V remove(K key);
    
    /**
     * If the key is in the collection of keys, update the associated
     * value, and return the previous value associated with key. If the
     * key is not in the collection, add both key and value to the collection
     * and return null.
     * Preconditions: key != null, value != null
     * Postcondition: (key, value) pair is in the dictionary
     * @param key
     * @param value
     * @return 
     */
    public V put(K key, V value);
    
    /**
     * If the value of a node in the collection needs changed, get the 
     * Node of the key and set the value of the node to value.
     * @param key
     * @param value
     */
    public void updateValue(K key, V value);
    
    /**
     * Checks if collection is empty.
     * @return boolean value
     */
    public boolean isEmpty();
    
    /**
     * Check collections current size.
     * @return int value - total size of collection
     */
    public int size();
}
